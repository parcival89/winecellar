package be.sander.winecellar.domain.purchase.bottle;

import be.sander.winecellar.domain.purchase.Winedomain;

import static be.sander.winecellar.domain.purchase.bottle.Price.createFor;

public class BottleTestBuilder {

    private static final Price DEFAULT_PRICE = createFor(2599L);
    private Bottle.Builder builder;

    private Price price = DEFAULT_PRICE;

    private BottleTestBuilder() {
        builder = Bottle.Builder.createFor()
            .withId(BottleId.createFor());
    }

    public static BottleTestBuilder aBottle() {
        return new BottleTestBuilder();
    }

    public Bottle build() {
        return builder
            .withPrice(price)
            .build();
    }

    public BottleTestBuilder withWinedomain(Winedomain winedomain) {
        builder.withWinedomain(winedomain);
        return this;
    }

    public BottleTestBuilder withPrice(Price price) {
        this.price = price;
        return this;
    }

    public BottleTestBuilder withEdition(Edition edition) {
        builder.withEdition(edition);
        return this;
    }
}
