package be.sander.winecellar.domain.purchase;

import be.sander.winecellar.domain.purchase.bottle.Bottle;
import org.assertj.core.api.AbstractAssert;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseAssert extends AbstractAssert<PurchaseAssert, Purchase> {
    public PurchaseAssert(Purchase purchase) {
        super(purchase, PurchaseAssert.class);
    }

    public PurchaseAssert hasAListOfBottles() {
        assertThat(actual.getBottles())
            .isNotNull();
        return this;
    }

    public PurchaseAssert withElementsInIt(int numberOfElements) {
        assertThat(actual.getBottles()).hasSize(numberOfElements);
        return this;
    }

    public PurchaseAssert containingOnly(Bottle... bottles) {
        assertThat(actual.getBottles()).containsExactlyInAnyOrder(bottles);
        return this;
    }

    public PurchaseAssert hasAPurchaseDateOf(LocalDate date) {
        assertThat(actual.getDate()).isEqualTo(date);
        return this;
    }
}
