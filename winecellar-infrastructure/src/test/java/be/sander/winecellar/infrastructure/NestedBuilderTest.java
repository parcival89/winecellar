package be.sander.winecellar.infrastructure;

import be.sander.winecellar.infrastructure.ddd.ValueObject;
import be.sander.winecellar.infrastructure.test.UnitTest;
import org.junit.Test;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NestedBuilderTest extends UnitTest {

    @Test
    public void builder_buildsObject() {
        SomeEntity actual = SomeEntity.Builder.createFor().withField1("SomeField").withField2(1).build();
        assertThat(actual.getField1()).isEqualTo("SomeField");
        assertThat(actual.getField2()).isEqualTo(1);
    }

    @Test
    public void builder_triggersValidation() {
        assertThatThrownBy(() -> SomeEntity.Builder.createFor().withField1(null).withField2(1).build())
            .isInstanceOf(ConstraintViolationException.class)
            .hasMessage("class be.sander.winecellar.infrastructure.SomeEntity#field1 can not have value null because may not be null");
    }

    @Test
    public void builder_cantBuildObjectsTwice() {
        SomeEntity.Builder builder = SomeEntity.Builder.createFor().withField1("").withField2(1);
        builder.build();
        assertThatThrownBy(builder::build)
            .isInstanceOf(IllegalStateException.class)
            .hasMessage("This object SomeEntity[field1=,field2=1] has already been built");
    }
}

final class SomeEntity extends ValueObject {

    @NotNull
    private String field1;
    @Min(1)
    private int field2;

    private SomeEntity() {
    }

    public String getField1() {
        return field1;
    }

    public int getField2() {
        return field2;
    }

    static class Builder extends NestedBuilder<SomeEntity> {

        public static Builder createFor() {
            return new Builder();
        }

        private Builder() {
        }

        @Override
        protected SomeEntity createInstance() {
            return new SomeEntity();
        }

        public Builder withField1(String field1) {
            this.instance().field1 = field1;
            return this;
        }

        public Builder withField2(int field2) {
            this.instance().field2 = field2;
            return this;
        }
    }
}
