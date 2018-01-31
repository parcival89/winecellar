package be.sander.winecellar.domain.purchase;

import be.sander.winecellar.infrastructure.ddd.Repository;

import javax.inject.Named;

@Named
public interface PurchaseRepository extends Repository<Purchase, PurchaseId> {
}
