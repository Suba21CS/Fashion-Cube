package com.example.fashion.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "kids")
public class Kids {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 1000)
    private String description;

    private double price;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "kids", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductSize> sizes;

    public Kids() {}

    public Kids(String name, String description, double price, String imageUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    // Getters and setters
    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public List<ProductSize> getSizes() { return sizes; }
    public void setSizes(List<ProductSize> sizes) {
        this.sizes = sizes;
        for (ProductSize size : sizes) {
            size.setKids(this);
        }
    }
}
