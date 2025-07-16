package com.example.fashion.controller;

import com.example.fashion.model.Womens;
import com.example.fashion.service.WomensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/womens")
@CrossOrigin("*")
public class WomensController {

    @Autowired
    private WomensService womensService;
    @GetMapping("/womens-page")
    public String womensPage() {
        return "womens"; // resolves to templates/womens.html
    }

    // Add product
    @PostMapping("add")
    public Womens addWomensProduct(@RequestBody Womens w) {
        return womensService.addWomensProduct(w);
    }

    // Get all products
    @GetMapping("all")
    public List<Womens> getAllWomensProducts() {
        return womensService.getAllWomensProducts();
    }

    // Get product by ID
    @GetMapping("/{id}")
    public Womens getWomensById(@PathVariable Long id) {
        return womensService.getWomensById(id);
    }

    // Update product
    @PutMapping("/{id}")
    public Womens updateWomensProduct(@PathVariable Long id, @RequestBody Womens w) {
        return womensService.updateWomensProduct(id, w);
    }

    // Delete product
    @DeleteMapping("/{id}")
    public String deleteWomensProduct(@PathVariable Long id) {
        return womensService.deleteWomensProduct(id);
    }
}
