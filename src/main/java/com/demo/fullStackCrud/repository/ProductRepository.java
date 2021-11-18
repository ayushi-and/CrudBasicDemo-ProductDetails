package com.demo.fullStackCrud.repository;

import com.demo.fullStackCrud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
