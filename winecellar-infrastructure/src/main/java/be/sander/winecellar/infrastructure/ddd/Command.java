package be.sander.winecellar.infrastructure.ddd;

public class Command<ID extends Id> {

    private ID id;
    private int version;

    public ID getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }
}
