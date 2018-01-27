package be.sander.winecellar.domain.purchase;

import be.sander.infrastructure.common.Address;
import be.sander.infrastructure.ddd.ValueObject;

public final class Winedomain extends ValueObject {

    private String name;

    private Address adress;

    private Winedomain() {
        super();
    }


}
