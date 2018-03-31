package be.sander.winecellar.infrastructure.ddd;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AggregateRoot<ID extends Id> extends BaseEntity<ID> {

    protected AggregateRoot() {
    }
}
