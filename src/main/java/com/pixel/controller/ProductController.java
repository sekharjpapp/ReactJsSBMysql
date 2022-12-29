package com.pixel.controller;

import com.pixel.model.Product;
import com.pixel.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping("/productfindAll")
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @GetMapping("/product/{id}")
    public Optional<Product> getProductById(@PathVariable int id) {
        return productRepository.findById(id);
    }
    @PostMapping("/insert")
    public void insertProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProductById(@PathVariable int id) {
         productRepository.deleteById(id);
    }
}
