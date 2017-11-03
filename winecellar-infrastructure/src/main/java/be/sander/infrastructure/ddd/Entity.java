package be.sander.infrastructure.ddd;

public abstract class Entity<ID extends Id> {

    private ID id;

    protected Entity(ID id){
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (obj == this)
            return true;

        return this.id.equals(this.getClass().cast(obj).getId());
    }
}
