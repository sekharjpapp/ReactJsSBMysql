package com.pixel.controller;

import com.pixel.model.Product;
import com.pixel.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping("/findAll")
    public Flux<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @GetMapping("/product/{id}")
    public Mono<Product> getProductById(@PathVariable int id) {
        return productRepository.findById(id);
    }
    @PostMapping("/insert")
    public void insertProduct(@RequestBody Product product) {
        productRepository.save(product);
    }
    @PutMapping("/update/{id}")
    public Mono<Product> updateProduct(@RequestBody Product product, @PathVariable int id) {
        return productRepository.findById(id)
                .map(p-> {
                    p.setName(product.getName());
                    p.setPrice(product.getPrice());
                    return p;
                }).flatMap(p->productRepository.save(p));
    }
    @DeleteMapping("/product/{id}")
    public void deleteProductById(@PathVariable int id) {
         productRepository.deleteById(id);
    }
}
