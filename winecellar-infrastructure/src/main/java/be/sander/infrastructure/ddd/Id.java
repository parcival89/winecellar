package be.sander.infrastructure.ddd;

public abstract class Id extends ValueObject {

    protected Id(String id) {
        super(id);
    }
}
