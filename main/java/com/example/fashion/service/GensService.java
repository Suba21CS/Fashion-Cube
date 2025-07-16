package com.example.fashion.service;

import com.example.fashion.model.Gens;
import com.example.fashion.model.ProductSize;
import com.example.fashion.repository.GensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GensService {

    @Autowired
    private GensRepository grepo;

    // Add a Gens product with sizes
    public Gens addGensProduct(Gens g) {
        if (g.getSizes() != null) {
            for (ProductSize size : g.getSizes()) {
                size.setGens(g); // Link each size to this Gens product
            }
        }
        return grepo.save(g);
    }

    // Get all Gens products
    public List<Gens> getAllGensProducts() {
        return grepo.findAll();
    }

    // Get Gens product by ID
    public Gens getGensById(Long id) {
        return grepo.findById(id).orElse(null);
    }

    // Update existing Gens product
    public Gens updateGensProduct(Long id, Gens g) {
        Gens existingProduct = getGensById(id);
        if (existingProduct != null) {
            existingProduct.setName(g.getName());
            existingProduct.setDescription(g.getDescription());
            existingProduct.setPrice(g.getPrice());
            existingProduct.setImageUrl(g.getImageUrl());

            if (g.getSizes() != null) {
                for (ProductSize size : g.getSizes()) {
                    size.setGens(existingProduct); // Re-link to existing product
                }
                existingProduct.setSizes(g.getSizes());
            }

            return grepo.save(existingProduct);
        }
        return null;
    }

    // Delete Gens product
    public String deleteGensProduct(Long id) {
        if (grepo.existsById(id)) {
            grepo.deleteById(id);
            return "Product with ID " + id + " deleted.";
        }
        return "Product with ID " + id + " not found.";
    }
}
