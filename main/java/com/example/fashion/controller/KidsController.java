package com.example.fashion.controller;

import com.example.fashion.model.Kids;
import com.example.fashion.service.KidsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kids")
@CrossOrigin("*")
public class KidsController {

    @Autowired
    private KidsService kidsService;

    // Add product
    @PostMapping("add")
    public Kids addKidsProduct(@RequestBody Kids k) {
        return kidsService.addKidsProduct(k);
    }

    // Get all products
    @GetMapping("all")
    public List<Kids> getAllkidsprodruct() {
        return kidsService.getAllKidsProducts();
    }

    // Get product by ID
    @GetMapping("/{id}")
    public Kids getKidsById(@PathVariable Long id) {
        return kidsService.getKidsById(id);
    }

    // Update product
    @PutMapping("/{id}")
    public Kids updateKidsProduct(@PathVariable Long id, @RequestBody Kids k) {
        return kidsService.updateKidsProduct(id, k);
    }

    // Delete product
    @DeleteMapping("/{id}")
    public String deleteKidsProduct(@PathVariable Long id) {
        return kidsService.deleteKidsProduct(id);
    }
}
