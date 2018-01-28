package be.sander.winecellar.infrastructure.ddd;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EntityTest {

    @Test
    public void equals_onlyChecksId() {
        TestId id = new TestId("id 1");
        assertThat(new TestEntity(id, "extra")).isEqualTo(new TestEntity(id, null));
        assertThat(new TestEntity(id, "extra")).isEqualTo(new TestEntity(id, "extra"));
        assertThat(new TestEntity(id, "extra")).isNotEqualTo(new TestEntity(new TestId("Olifant"), "extra"));
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