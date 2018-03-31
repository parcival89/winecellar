package be.sander.winecellar.domain.purchase.bottle;

import be.sander.winecellar.infrastructure.ddd.ValueObject;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import static javax.persistence.AccessType.FIELD;

//TODO [Sander] validatie op getallen
@Embeddable
@Access(FIELD)
public class Price extends ValueObject {
    public static final String COLUMN_PRICE = "PRICE";


    public static Price createFor(long centimes) {
        return new Price(centimes);
    }

    @Column(name = COLUMN_PRICE)
    @NotNull
    @Min(0)
    private Long centimes;

    private Price(Long centimes) {
        this.centimes = centimes;
    }
}
