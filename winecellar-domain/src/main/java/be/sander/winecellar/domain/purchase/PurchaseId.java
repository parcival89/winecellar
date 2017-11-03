package be.sander.winecellar.domain.purchase;

import be.sander.infrastructure.ddd.Id;

import java.util.UUID;

public class PurchaseId extends Id {

    protected PurchaseId(String id) {
        super(id);
    }

    public static PurchaseId createFor(UUID uuid){
        return new PurchaseId(uuid.toString());
    }
}
