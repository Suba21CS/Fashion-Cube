package com.example.fashion.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fashion.model.ProductSize;
import com.example.fashion.model.Womens;
import com.example.fashion.repository.WomensRepository;

@Service
public class WomensService {

    @Autowired
    private WomensRepository wrepo;

    public Womens addWomensProduct(Womens w) {
        if (w.getSizes() != null) {
            for (ProductSize size : w.getSizes()) {
                size.setWomens(w);  // ✅ Correct reference
            }
        }
        return wrepo.save(w);
    }

    public List<Womens> getAllWomensProducts() {
        return wrepo.findAll();
    }

    public Womens getWomensById(Long id) {
        return wrepo.findById(id).orElse(null);
    }

    public Womens updateWomensProduct(Long id, Womens w) {
        Womens existingProduct = getWomensById(id);
        if (existingProduct != null) {
            existingProduct.setName(w.getName());
            existingProduct.setDescription(w.getDescription());
            existingProduct.setPrice(w.getPrice());
            existingProduct.setImageUrl(w.getImageUrl());
            return wrepo.save(existingProduct);
        }
        return null;
    }

    public String deleteWomensProduct(Long id) {
        wrepo.deleteById(id);
        return "Product with ID " + id + " deleted.";
    }
}
