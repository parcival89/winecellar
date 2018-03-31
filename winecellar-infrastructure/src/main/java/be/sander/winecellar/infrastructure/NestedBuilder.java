package be.sander.winecellar.infrastructure;

import static be.sander.winecellar.infrastructure.validation.WinecellarValidator.validator;

public abstract class NestedBuilder<T> {

    private T instance;
    private boolean hasBeenBuild;

    protected NestedBuilder() {
        this.instance = createInstance();
    }

    protected abstract T createInstance();

    protected final T instance() {
        bailIfAlreadyBuilt();

        return instance;
    }

    public T build() {
        bailIfAlreadyBuilt();

        hasBeenBuild = true;

        validator().validate(instance);

        return instance;
    }

    private void bailIfAlreadyBuilt() {
        if (hasBeenBuild) {
            throw new IllegalStateException(String.format("This object %s has already been built", instance.toString()));
        }
    }
}
