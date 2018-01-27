package be.sander.winecellar.domain.purchase.bottle;

import be.sander.infrastructure.NestedBuilder;
import be.sander.infrastructure.ddd.Entity;
import be.sander.winecellar.domain.purchase.Winedomain;

public final class Bottle extends Entity<BottleId> {

    private Winedomain winedomain;
    private Edition edition;
    private Price price;

    private Bottle() {
        super(BottleId.createFor());
    }

    public static class Builder extends NestedBuilder<Bottle> {

        private Builder() {
            super(new Bottle());
        }

        public static Builder createFor() {
            return new Builder();
        }

        public Builder withWinedomain(Winedomain winedomain) {
            getInstance().winedomain = winedomain;
            return this;
        }

        public Builder withPrice(Price price) {
            getInstance().price = price;
            return this;
        }

        public Builder withEdition(Edition edition) {
            getInstance().edition = edition;
            return this;
        }
    }
}
