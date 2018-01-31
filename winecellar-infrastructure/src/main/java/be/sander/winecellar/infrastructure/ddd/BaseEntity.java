package be.sander.winecellar.infrastructure.ddd;

import java.util.Objects;

public abstract class BaseEntity<ID extends Id> extends ValueObject {

    private ID id;

    protected BaseEntity(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (obj == this)
            return true;

        return this.id.equals(this.getClass().cast(obj).getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(47 * 37, id);
    }
}