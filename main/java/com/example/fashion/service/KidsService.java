package com.example.fashion.service;

import com.example.fashion.model.Kids;
import com.example.fashion.repository.KidsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KidsService {

    @Autowired
    private KidsRepository krepo;

    // Add a new kids product
    public Kids addKidsProduct(Kids k) {
        return krepo.save(k);
    }

    // Get all kids products
    public List<Kids> getAllKidsProducts() {
        return krepo.findAll();
    }

    // Get a kids product by ID
    public Kids getKidsById(Long id) {
        return krepo.findById(id).orElse(null);
    }

    // Update a kids product
    public Kids updateKidsProduct(Long id, Kids k) {
        Kids existingProduct = getKidsById(id);
        
        if (existingProduct != null) {
            existingProduct.setName(k.getName());
            existingProduct.setDescription(k.getDescription());
            existingProduct.setPrice(k.getPrice());
            existingProduct.setImageUrl(k.getImageUrl());

            return krepo.save(existingProduct); // Saves and returns the updated product
        }

        return null; // Or throw custom exception like: throw new ResourceNotFoundException("Product not found");
    }


    // Delete a kids product
    public String deleteKidsProduct(Long id) {
        if (krepo.existsById(id)) {
            krepo.deleteById(id);
            return "Product with ID " + id + " deleted.";
        }
        return "Product with ID " + id + " not found.";
    }
}
