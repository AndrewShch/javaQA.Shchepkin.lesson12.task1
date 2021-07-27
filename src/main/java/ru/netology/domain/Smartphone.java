package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product{
    private  String countryOfManufacture;

    public Smartphone(){
        super();
    }

    public Smartphone(int id, String name, int price, String countryOfManufacture) {
        super(id, name, price);
        this.countryOfManufacture = countryOfManufacture;
    }

    public String getCountryOfManufacture() {
        return countryOfManufacture;
    }

    public void setCountryOfManufacture(String countryOfManufacture) {
        this.countryOfManufacture = countryOfManufacture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(countryOfManufacture, that.countryOfManufacture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), countryOfManufacture);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "countryOfManufacture='" + countryOfManufacture + '\'' +
                '}';
    }
}
