package jpabook.jpashop.domain;


import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Adress {
    private String city;
    private String street;
    private String zipcode;

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }

    private void setCity(String city) {
        this.city = city;
    }

    private void setStreet(String street) {
        this.street = street;
    }

    private void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adress adress = (Adress) o;
        return Objects.equals(getCity(), adress.getCity()) &&
                Objects.equals(getStreet(), adress.getStreet()) &&
                Objects.equals(getZipcode(), adress.getZipcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getZipcode());
    }
}
