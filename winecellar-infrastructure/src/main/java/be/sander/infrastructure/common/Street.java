package be.sander.infrastructure.common;

import be.sander.infrastructure.ddd.SingleValueValueObject;

public class Street extends SingleValueValueObject{

    private Street(String value) {
        super(value);
    }

    public static Street createFor(String value){
        return new Street(value);
    }
}
