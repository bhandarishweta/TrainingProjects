package com.stackroute.springdatajpamysql.controller;

import com.stackroute.springdatajpamysql.entity.Product;
import com.stackroute.springdatajpamysql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class ProductController {
    // Add controllers here for CRUD operations on Product entity.
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService pService){
        this.productService= pService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<List<Product>> getAllProductsHavingPriceLessThan(@PathVariable double price) {
        return ResponseEntity.ok(productService.getAllProductsHavingPriceLessThan(price));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if(product != null){
            return ResponseEntity.ok(product);
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product productDetails,@PathVariable Long id) {
        Product updatedProduct = productService.updateProduct(productDetails, id);
        return updatedProduct != null ? ResponseEntity.ok(updatedProduct) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        String response = productService.deleteProduct(id);
        return response.equals("Product Deleted") ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }
}



