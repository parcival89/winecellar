package be.sander.winecellar.infrastructure.ddd;

public abstract class SingleValueValueObject<T> extends ValueObject {
    private final T value;

    protected SingleValueValueObject(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
