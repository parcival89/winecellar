package be.sander.winecellar.infrastructure.ddd;

public abstract class AggregateRoot<ID extends Id> extends BaseEntity<ID> {

    protected AggregateRoot(ID id) {
        super(id);
    }
}
