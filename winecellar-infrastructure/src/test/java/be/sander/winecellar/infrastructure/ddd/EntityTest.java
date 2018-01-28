package be.sander.winecellar.infrastructure.ddd;

import be.sander.winecellar.infrastructure.test.UnitTest;
import org.junit.Test;

import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EntityTest extends UnitTest {

    @Test
    public void equals_onlyChecksId() {
        TestId id = new TestId("id 1");
        assertThat(new TestEntity(id, "extra")).isEqualTo(new TestEntity(id, null));
        assertThat(new TestEntity(id, "extra")).isEqualTo(new TestEntity(id, "extra"));
        assertThat(new TestEntity(id, "extra")).isNotEqualTo(new TestEntity(new TestId("Olifant"), "extra"));
    }

    @Test
    public void validation_works(){
        assertThatThrownBy(() -> new TestId(null))
                .isInstanceOf(ConstraintViolationException.class)
                .hasMessage("class be.sander.winecellar.infrastructure.ddd.EntityTest$TestId#value can not have value null because may not be null");

    }

    private class TestId extends Id {
        protected TestId(String id) {
            super(id);
        }
    }

    private class TestEntity extends Entity<TestId> {
        private String extraField;

        TestEntity(TestId id, String extraField) {
            super(id);
            this.extraField = extraField;
        }
    }
}