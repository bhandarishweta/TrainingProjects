package com.stackroute.springdatajpamysql.repository;


import com.stackroute.springdatajpamysql.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

//Create ProductRepo interface extending JpaRepository
public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.price < :price")
    List<Product> findProductsLessThanPrice(double price);
}
