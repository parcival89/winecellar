package be.sander.winecellar.infrastructure.ddd;

import javax.validation.constraints.NotNull;

import static be.sander.winecellar.infrastructure.validation.WinecellarValidator.validator;

public abstract class SingleValueValueObject<T> extends ValueObject {

    @NotNull
    private final T value;

    protected SingleValueValueObject(T value) {
        this.value = value;
        validator().validate(this);
    }

    public T getValue() {
        return value;
    }
}
