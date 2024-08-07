package com.stackroute.springdatajpamysql.service;

import com.stackroute.springdatajpamysql.entity.Product;
import java.util.List;
import java.util.Optional;

//Create service interface here
public interface ProductService {
    List<Product> getAllProducts();

    List<Product> getAllProductsHavingPriceLessThan(double price);

    Product getProductById(Long id);

    Product saveProduct(Product product);

    Product updateProduct(Product productDetails, Long id);

    String deleteProduct(Long id);

}
