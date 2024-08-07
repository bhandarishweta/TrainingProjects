package com.stackroute.springdatajpamysql.service;


import com.stackroute.springdatajpamysql.entity.Product;
import com.stackroute.springdatajpamysql.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

//Implement ProductService here
public class ProductServiceImpl implements ProductService {
    private ProductRepo productRepo;
    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
    @Override
    public List<Product> getAllProductsHavingPriceLessThan(double price) {
        return productRepo.findProductsLessThanPrice(price);
    }
    @Override
    public Product getProductById(Long id) {

        return productRepo.findById(id).orElse(null);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }
    @Override
    public Product updateProduct(Product productDetails, Long id) {
        Optional<Product> productOptional = productRepo.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(productDetails.getName());
            product.setPrice(productDetails.getPrice());
            return productRepo.save(product);
        } else {
            return null; // Or throw an exception
        }
    }

    @Override
    public String deleteProduct(Long id) {
       // if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
            return "Product Deleted";
        //} else {
          //  return "Product Not Found"; // Or throw an exception
        //}
    }

}
