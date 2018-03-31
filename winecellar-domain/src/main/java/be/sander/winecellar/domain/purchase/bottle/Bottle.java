package be.sander.winecellar.domain.purchase.bottle;

import be.sander.winecellar.domain.purchase.Winedomain;
import be.sander.winecellar.infrastructure.NestedBuilder;
import be.sander.winecellar.infrastructure.ddd.BaseEntity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = Bottle.TABLE_NAME)
public final class Bottle extends BaseEntity<BottleId> {
    public static final String TABLE_NAME = "BOTTLE";
    public static final String TABLE_ID = "ID";

    private static final String COLUMN_PRICE = "PRICE";

    @Id
    @Valid
    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = TABLE_ID))
    private BottleId id;

    private Winedomain winedomain;
    private Edition edition;

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = COLUMN_PRICE))
    private Price price;

    private Bottle() {
    }

    @Override
    public BottleId getId() {
        return this.id;
    }

    public static class Builder extends NestedBuilder<Bottle> {

        private Builder() {
        }

        public static Builder createFor() {
            return new Builder();
        }

        @Override
        protected Bottle createInstance() {
            return new Bottle();
        }

        public Builder withId(BottleId id) {
            this.instance().id = id;
            return this;
        }

        public Builder withWinedomain(Winedomain winedomain) {
            instance().winedomain = winedomain;
            return this;
        }

        public Builder withPrice(Price price) {
            instance().price = price;
            return this;
        }

        public Builder withEdition(Edition edition) {
            instance().edition = edition;
            return this;
        }
    }
}
