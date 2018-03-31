package be.sander.winecellar.domain.purchase.bottle;

import be.sander.winecellar.infrastructure.ddd.ValueObject;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import static be.sander.winecellar.infrastructure.validation.WinecellarValidator.validator;
import static javax.persistence.AccessType.FIELD;

@Embeddable
@Access(FIELD)
public class Edition extends ValueObject {
    public static final String COLUMN_EDITION = "EDITION";

    @Column(name = COLUMN_EDITION)
    @Min(0)
    @NotNull
    private final Integer value;

    public Edition() {
        this.value = 0;
    }

    protected Edition(Integer value) {
        this.value = value;
        validator().validate(this);
    }
}
