package be.sander.winecellar.domain.purchase;

import be.sander.infrastructure.ddd.Id;

import java.util.UUID;

public class PurchaseId extends Id {

    private PurchaseId(String id) {
        super(id);
    }

    public static PurchaseId createFor(){
        return new PurchaseId(UUID.randomUUID().toString());
    }

    public static PurchaseId createFor(UUID uuid){
        return new PurchaseId(uuid.toString());
    }
}
