package lv.dudonz.simplewebapp.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; // Can be other data structures. (DD)

    private String firstName;
    private String lastName;
    @ManyToMany(mappedBy = "customers")
    private Set<Product> products;

    public Customer() {
        // As required by JPA (zero-args constructor)
    }

    public Customer(String firstName, String lastName, Set<Product> products) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    
}
