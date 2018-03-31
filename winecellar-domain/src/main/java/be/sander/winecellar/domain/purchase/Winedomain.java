package be.sander.winecellar.domain.purchase;

import be.sander.winecellar.infrastructure.common.Address;
import be.sander.winecellar.infrastructure.ddd.ValueObject;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static javax.persistence.AccessType.FIELD;

@Embeddable
@Access(FIELD)
public final class Winedomain extends ValueObject {
    public static final String COLUMN_NAME = "WINDOMAIN_NAME";

    @Column(name = COLUMN_NAME)
    @NotNull
    private String name;

    @Embedded
    @Valid
    @NotNull
    private Address adress;

    private Winedomain() {
    }
}
