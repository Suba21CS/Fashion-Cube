package com.example.fashion.service;

import com.example.fashion.model.Product;
import com.example.fashion.model.ProductSize;
import com.example.fashion.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        if (product.getSizes() != null) {
            for (ProductSize size : product.getSizes()) {
                size.setProduct(product); // set the back-reference
            }
        }
        return productRepository.save(product);
    }


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = getProductById(id);
        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setImageUrl(updatedProduct.getImageUrl());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "Product with ID " + id + " deleted.";
    }
}
