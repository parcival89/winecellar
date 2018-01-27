package be.sander.infrastructure.ddd;

public abstract class SingleValueValueObject extends ValueObject {
    private final String value;

    protected SingleValueValueObject(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
