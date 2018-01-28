package be.sander.winecellar.infrastructure.common;

import be.sander.winecellar.infrastructure.ddd.SingleValueValueObject;

public class Street extends SingleValueValueObject<String> {

    private Street(String value) {
        super(value);
    }

    public static Street createFor(String value) {
        return new Street(value);
    }
}
