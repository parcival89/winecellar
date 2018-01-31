package be.sander.winecellar.domain.purchase;

import be.sander.winecellar.domain.DomainIntegrationTest;
import org.junit.Test;

import javax.inject.Inject;

import static be.sander.winecellar.domain.WineCellarDomainAsserts.assertThat;

public class PurchaseRepositoryIntegrationTest extends DomainIntegrationTest {

    @Inject
    private PurchaseRepository purchaseRepository;

    @Test
    public void findOne() {
        Purchase purchase = PurchaseTestBuilder.aPurchase().build();
        purchaseRepository.save(purchase);

        assertThat(purchaseRepository.findAll())
            .isNotEmpty()
            .hasSize(1)
            .containsExactly(purchase);
    }
}
