package be.sander.winecellar.domain.purchase;

import be.sander.winecellar.domain.Bottle;
import org.junit.Test;

import java.time.LocalDate;

import static be.sander.winecellar.domain.WineCellarDomainAsserts.assertThat;
import static com.google.common.collect.Lists.newArrayList;
import static java.util.UUID.randomUUID;

public class PurchaseTest {

    @Test
    public void constructor_worksWithBuilder() {
        PurchaseId purchaseId = PurchaseId.createFor(randomUUID());
        LocalDate now = LocalDate.now();
        Bottle bottle1 = new Bottle();
        Bottle bottle2 = new Bottle();
        Bottle bottle3 = new Bottle();
        Purchase purchase = Purchase.Builder.createFor(purchaseId)
                .withBottles(newArrayList(bottle1, bottle2, bottle3))
                .withDate(now)
                .build();

        assertThat(purchase)
                .hasAListOfBottles()
                .withElementsInIt(3)
                .containingOnly(bottle1, bottle2, bottle3)
                .hasAPurchaseDateOf(now);
    }
}