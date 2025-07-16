package com.example.fashion.controller;

import com.example.fashion.model.Gens;
import com.example.fashion.service.GensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gens")
@CrossOrigin("*")
public class GensController {

    @Autowired
    private GensService gensService;

    // Add product
    @PostMapping("/add")
    public Gens addGensProduct(@RequestBody Gens g) {
        return gensService.addGensProduct(g);
    }

    // Get all products
    @GetMapping("/all")
    public List<Gens> getAllGensProducts() {
        return gensService.getAllGensProducts();
    }

    // Get product by ID
    @GetMapping("/{id}")
    public Gens getGensById(@PathVariable Long id) {
        return gensService.getGensById(id);
    }

    // Update product
    @PutMapping("/{id}")
    public Gens updateGensProduct(@PathVariable Long id, @RequestBody Gens g) {
        return gensService.updateGensProduct(id, g);
    }

    // Delete product
    @DeleteMapping("/{id}")
    public String deleteGensProduct(@PathVariable Long id) {
        return gensService.deleteGensProduct(id);
    }
}
