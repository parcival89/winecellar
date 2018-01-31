package be.sander.winecellar.domain.purchase;

public class PurchaseTestBuilder {

    private final Purchase.Builder builder;

    public static PurchaseTestBuilder aPurchase() {
        return new PurchaseTestBuilder();
    }

    private PurchaseTestBuilder() {
        this.builder = Purchase.Builder.createFor(PurchaseId.createFor());
    }

    public Purchase build() {
        return builder.build();
    }
}
