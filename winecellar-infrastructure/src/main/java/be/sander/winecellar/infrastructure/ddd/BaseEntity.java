package be.sander.winecellar.infrastructure.ddd;

import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class BaseEntity<ID extends Id> {

    public abstract ID getId();

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (other == null || this.getClass() != other.getClass() || this.getId() == null) {
            return false;
        }

        return this.getId().equals(((BaseEntity<?>) other).getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
