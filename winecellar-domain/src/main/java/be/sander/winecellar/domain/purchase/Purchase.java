package be.sander.winecellar.domain.purchase;

import be.sander.infrastructure.NestedBuilder;
import be.sander.infrastructure.ddd.AggregateRoot;
import be.sander.winecellar.domain.purchase.bottle.Bottle;

import java.time.LocalDate;
import java.util.Collection;

public class Purchase extends AggregateRoot<PurchaseId> {
    private Collection<Bottle> bottles;
    private LocalDate date;
    //private Location place;

    private Purchase(PurchaseId id) {
        super(id);
    }

    public Collection<Bottle> getBottles() {
        return bottles;
    }

    public LocalDate getDate() {
        return date;
    }

//    public static class Builder extends NestedBuilder<Purchase>{
//
//        private Builder(PurchaseId purchaseId){
//            super(new Purchase(purchaseId));
//        }
//
//        public static Builder createFor(PurchaseId purchaseId){
//            return new Builder(purchaseId);
//        }
//
//        public Builder withBottles(Collection<Bottle> bottles) {
//            getInstance().bottles = bottles;
//            return this;
//        }
//
//        public Builder withDate(LocalDate date) {
//            getInstance().date = date;
//            return this;
//        }
//    }
}
