package be.sander.infrastructure.ddd;

public abstract class SingleValueValueObject<T> extends ValueObject {
    private final T value;

    protected SingleValueValueObject(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
