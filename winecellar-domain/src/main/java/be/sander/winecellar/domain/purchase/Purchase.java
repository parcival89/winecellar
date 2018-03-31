package be.sander.winecellar.domain.purchase;

import be.sander.winecellar.domain.purchase.bottle.Bottle;
import be.sander.winecellar.infrastructure.NestedBuilder;
import be.sander.winecellar.infrastructure.ddd.AggregateRoot;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = Purchase.TABLE_NAME)
public final class Purchase extends AggregateRoot<PurchaseId> {
    public static final String TABLE_NAME = "PURCHASE";
    public static final String TABLE_ID = "ID";

    @Id
    @NotNull
    @Valid
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = TABLE_ID))
    private PurchaseId id;

    @ElementCollection(fetch = EAGER)
    @OrderColumn(name = "ORDER_ID")
    @CollectionTable(
        name = Bottle.TABLE_NAME,
        joinColumns = @JoinColumn(name = "OVEREENKOMST_ID", referencedColumnName = TABLE_ID)
    )
    @Valid
    private Collection<Bottle> bottles;

    private LocalDate date;
    //private Location place;

    private Purchase() {
    }

    public PurchaseId getId() {
        return this.id;
    }

    public Collection<Bottle> getBottles() {
        return bottles;
    }

    public LocalDate getDate() {
        return date;
    }

    public static class Builder extends NestedBuilder<Purchase> {

        private Builder() {
        }

        @Override
        protected Purchase createInstance() {
            return new Purchase();
        }

        public static Builder createFor(PurchaseId purchaseId) {
            return new Builder()
                .withId(purchaseId);
        }

        private Builder withId(PurchaseId purchaseId) {
            this.instance().id = purchaseId;
            return this;
        }

        public Builder withBottles(Collection<Bottle> bottles) {
            instance().bottles = bottles;
            return this;
        }

        public Builder withDate(LocalDate date) {
            instance().date = date;
            return this;
        }
    }
}
