package be.sander.winecellar.domain.purchase.bottle;

import be.sander.winecellar.infrastructure.ddd.SingleValueValueObject;

public class Edition extends SingleValueValueObject<Integer> {

    protected Edition(Integer value) {
        super(value);
    }
}
