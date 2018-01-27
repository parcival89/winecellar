package be.sander.infrastructure.ddd;

public abstract class Id extends SingleValueValueObject {

    protected Id(String id) {
        super(id);
    }
}
