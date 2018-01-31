package be.sander.winecellar.domain.purchase.bottle;

import be.sander.winecellar.infrastructure.ddd.Id;

import java.util.UUID;

public final class BottleId extends Id {

    public static BottleId createFor() {
        return new BottleId(UUID.randomUUID().toString());
    }

    public static BottleId createFor(String id) {
        return new BottleId(id);
    }

    private BottleId(String id) {
        super(id);
    }
}
