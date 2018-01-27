package be.sander.infrastructure.common;

import be.sander.infrastructure.ddd.SingleValueValueObject;
import be.sander.infrastructure.ddd.ValueObject;

public class HouseNumber extends ValueObject{
    private String number;
    private String busNumber;

    private HouseNumber (String number, String busNumber) {
        this.number = number;
        this.busNumber = busNumber;
    }

    public static HouseNumber createFor(String number, String busNumber) {return new HouseNumber(number,busNumber);}
}
