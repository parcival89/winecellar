package be.sander.winecellar.domain.purchase.bottle;

import be.sander.winecellar.domain.purchase.Winedomain;

public class BottleTestBuilder {

    private Bottle.Builder builder;

    private BottleTestBuilder() {
        builder = Bottle.Builder.createFor();
    }

    public static BottleTestBuilder aBottle() {
        return new BottleTestBuilder();
    }

    public Bottle build() {
        return builder.build();
    }

    public BottleTestBuilder withWinedomain(Winedomain winedomain) {
        builder.withWinedomain(winedomain);
        return this;
    }

    public BottleTestBuilder withPrice(Price price) {
        builder.withPrice(price);
        return this;
    }

    public BottleTestBuilder withEdition(Edition edition) {
        builder.withEdition(edition);
        return this;
    }
}
