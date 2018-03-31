package be.sander.winecellar.infrastructure.common;

import be.sander.winecellar.infrastructure.ddd.ValueObject;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import static be.sander.winecellar.infrastructure.validation.WinecellarValidator.validator;
import static javax.persistence.AccessType.FIELD;

@Embeddable
@Access(FIELD)
public class Street extends ValueObject {
    public static final String COLUMN_STREET = "STREET";

    public static Street createFor(String value) {
        return new Street(value);
    }

    @Column(name = COLUMN_STREET)
    @NotNull
    private final String value;

    public Street() {
        this.value = "";
    }

    private Street(String value) {
        this.value = value;
        validator().validate(this);
    }
}
