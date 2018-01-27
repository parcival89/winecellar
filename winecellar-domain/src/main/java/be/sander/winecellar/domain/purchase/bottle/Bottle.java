package be.sander.winecellar.domain.purchase.bottle;

import be.sander.infrastructure.NestedBuilder;
import be.sander.infrastructure.ddd.Entity;

public class Bottle extends Entity<BottleId> {

    private Bottle() {
        super(BottleId.createFor());
    }

    private Bottle(BottleId id) {
        super(id);
    }

//    public static class Builder extends NestedBuilder<Bottle> {
//
//        private Builder() {
//            super(new Bottle());
//        }
//
//        public static Builder createFor() {
//            return new Builder();
//        }
//    }
}
