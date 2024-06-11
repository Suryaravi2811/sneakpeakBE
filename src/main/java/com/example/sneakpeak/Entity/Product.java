package com.example.sneakpeak.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private String type;
    private String price;
    private String delivery;
    private String description;
    private String details;
    private String water;
    private String style;
    private String closure;
    private String heel;
    private String country;
    private String color;
    private String brand;
    private String manufacturerDetails;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(image, product.image) && Objects.equals(type, product.type) && Objects.equals(price, product.price) && Objects.equals(delivery, product.delivery) && Objects.equals(description, product.description) && Objects.equals(details, product.details) && Objects.equals(water, product.water) && Objects.equals(style, product.style) && Objects.equals(closure, product.closure) && Objects.equals(heel, product.heel) && Objects.equals(country, product.country) && Objects.equals(color, product.color) && Objects.equals(brand, product.brand) && Objects.equals(manufacturerDetails, product.manufacturerDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, image, type, price, delivery, description, details, water, style, closure, heel, country, color, brand, manufacturerDetails);
    }
}
