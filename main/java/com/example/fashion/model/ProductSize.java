package com.example.fashion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class ProductSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String size;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    @ManyToOne
    @JoinColumn(name = "womens_id")
    @JsonIgnore
    private Womens womens;

    @ManyToOne
    @JoinColumn(name = "kids_id", nullable = true)
    @JsonIgnore
    private Kids kids;

    // ✅ Add Gens relationship
    @ManyToOne
    @JoinColumn(name = "gens_id", nullable = true)
    @JsonIgnore
    private Gens gens;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public Womens getWomens() { return womens; }
    public void setWomens(Womens womens) { this.womens = womens; }

    public Kids getKids() { return kids; }
    public void setKids(Kids kids) { this.kids = kids; }

    public Gens getGens() { return gens; }
    public void setGens(Gens gens) { this.gens = gens; }
	
}