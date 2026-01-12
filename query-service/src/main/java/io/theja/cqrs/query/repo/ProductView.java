package io.theja.cqrs.query.repo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// TODO 7: Add query entity.
@Entity
public class ProductView {

    @Id
    private String id;
    private String name;
    private double price;

    public ProductView() {
    }

    public ProductView(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
