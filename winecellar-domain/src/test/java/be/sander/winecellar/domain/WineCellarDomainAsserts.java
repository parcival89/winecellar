package be.sander.winecellar.domain;

import be.sander.winecellar.domain.purchase.Purchase;
import be.sander.winecellar.domain.purchase.PurchaseAssert;
import org.assertj.core.api.Assertions;

public class WineCellarDomainAsserts extends Assertions {

    public static PurchaseAssert assertThat(Purchase purchase) {
        return new PurchaseAssert(purchase);
    }
}
