package be.sander.winecellar.infrastructure.ddd;

import javax.persistence.Access;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

import static javax.persistence.AccessType.FIELD;

@MappedSuperclass
@Access(FIELD)
public abstract class Id extends SingleValueValueObject<String> implements Serializable {

    protected Id(String id) {
        super(id);
    }
}
