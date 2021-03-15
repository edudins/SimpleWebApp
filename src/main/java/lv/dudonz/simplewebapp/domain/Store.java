package lv.dudonz.simplewebapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String storeName;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String cPhoneNr;
    private String cEmail;

    @OneToMany
    @JoinColumn(name = "store_id")
    private Set<Product> products = new HashSet<>();

    public Store() { }

    public Store(String storeName, String streetAddress, String city, String state, String zip, String cPhoneNr, String cEmail) {
        this.storeName = storeName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.cPhoneNr = cPhoneNr;
        this.cEmail = cEmail;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getcPhoneNr() {
        return cPhoneNr;
    }

    public void setcPhoneNr(String cPhoneNr) {
        this.cPhoneNr = cPhoneNr;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", storeName='" + storeName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", cPhoneNr='" + cPhoneNr + '\'' +
                ", cEmail='" + cEmail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Store store = (Store) o;

        return id == store.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
