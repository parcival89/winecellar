package be.sander.winecellar.domain.purchase;

import be.sander.winecellar.infrastructure.ddd.Id;

import javax.persistence.Embeddable;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Embeddable
public final class PurchaseId extends Id {

    public static PurchaseId createFor() {
        return new PurchaseId();
    }

    public static PurchaseId createFor(UUID uuid) {
        return new PurchaseId(uuid.toString());
    }

    private PurchaseId() {
        this(randomUUID().toString());
    }

    private PurchaseId(String value) {
        super(value);
    }
}
