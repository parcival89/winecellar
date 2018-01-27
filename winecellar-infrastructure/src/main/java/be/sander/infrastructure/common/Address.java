package be.sander.infrastructure.common;

import be.sander.infrastructure.NestedBuilder;
import be.sander.infrastructure.ddd.ValueObject;

public class Address extends ValueObject {

    private Street street;
    private HouseNumber number;
    private Municipality zipcode;
    private Country country;

    private Address() {
    }

    public Country getCountry() {
        return country;
    }

    public Street getStreet() {
        return street;
    }

    public HouseNumber getNumber() {
        return number;
    }

    public Municipality getZipcode() {
        return zipcode;
    }

    public static class Builder extends NestedBuilder<Address> {

        private Builder() {
            super(new Address());
        }

        public static Builder createFor() {
            return new Builder();
        }

        public Builder withCountry(Country country) {

            return this;
        }

        public Builder withStreet(Street street) {

            return this;
        }

        public Builder withNumber(Number number) {

            return this;
        }

        public Builder withZipcode(Zipcode zipcode) {

            return this;
        }

    }
}
