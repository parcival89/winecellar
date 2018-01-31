package be.sander.winecellar.domain.purchase.bottle;

import be.sander.winecellar.infrastructure.ddd.ValueObject;

//TODO [Sander] validatie op getallen
public class Price extends ValueObject{

    private long number;
    private long centimes;

    private Price(long number, long centimes){
        this.number = number;
        this.centimes = centimes;
    }

    public static Price createFor(long number, long centimes) {
        return new Price(number, centimes);
    }
}
