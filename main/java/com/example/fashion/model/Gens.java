package com.example.fashion.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Gens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;
    private String imageUrl;

    @OneToMany(mappedBy = "gens", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductSize> sizes;

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public List<ProductSize> getSizes() { return sizes; }
    public void setSizes(List<ProductSize> sizes) { this.sizes = sizes; }
}
