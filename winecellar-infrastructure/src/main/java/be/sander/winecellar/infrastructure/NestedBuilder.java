package be.sander.winecellar.infrastructure;

import be.sander.winecellar.infrastructure.ddd.ValueObject;

import static be.sander.winecellar.infrastructure.validation.WinecellarValidator.validator;

public abstract class NestedBuilder<T extends ValueObject> {

    private T instance;
    private boolean hasBeenBuild;

    protected NestedBuilder(T instance) {
        this.instance = instance;
    }

    public T build() {
        if (hasBeenBuild) {
            throw new IllegalStateException(String.format("This object %s has already been built", instance.toString()));
        }
        hasBeenBuild = true;

        validator().validate(instance);

        return instance;
    }

    protected T getInstance() {
        return instance;
    }
}
