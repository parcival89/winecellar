package be.sander.winecellar.infrastructure.ddd;

import javax.persistence.Access;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static be.sander.winecellar.infrastructure.validation.WinecellarValidator.validator;
import static javax.persistence.AccessType.FIELD;

@MappedSuperclass
@Access(FIELD)
public abstract class Id extends ValueObject implements Serializable {

    @NotNull
    private final String value;

    protected Id() {
        this.value = null;
    }

    protected Id(String value) {
        this.value = value;
        validator().validate(this);
//        Preconditions.checkArgument(isNotBlank(value), "Value is required.");
    }

    public String getValue() {
        return value;
    }
}
