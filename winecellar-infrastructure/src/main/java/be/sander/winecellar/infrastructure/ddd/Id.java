package be.sander.winecellar.infrastructure.ddd;

public abstract class Id extends SingleValueValueObject<String> {

    protected Id(String id) {
        super(id);
    }
}
