package be.sander.winecellar.infrastructure.ddd;

import be.sander.winecellar.infrastructure.test.UnitTest;
import org.junit.Test;

import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseEntityTest extends UnitTest {

    @Test
    public void equals_onlyChecksId() {
        TestId id = new TestId("id 1");
        assertThat(new TestBaseEntity(id, "extra")).isEqualTo(new TestBaseEntity(id, null));
        assertThat(new TestBaseEntity(id, "extra")).isEqualTo(new TestBaseEntity(id, "extra"));
        assertThat(new TestBaseEntity(id, "extra")).isNotEqualTo(new TestBaseEntity(new TestId("Olifant"), "extra"));
    }

    @Test
    public void validation_works() {
        assertThatThrownBy(() -> new TestId(null))
            .isInstanceOf(ConstraintViolationException.class)
            .hasMessage("class be.sander.winecellar.infrastructure.ddd.BaseEntityTest$TestId#value can not have value null because may not be null");

    }

    private class TestId extends Id {
        protected TestId(String id) {
            super(id);
        }
    }

    private class TestBaseEntity extends BaseEntity<TestId> {
        private String extraField;

        TestBaseEntity(TestId id, String extraField) {
            super(id);
            this.extraField = extraField;
        }
    }
}
