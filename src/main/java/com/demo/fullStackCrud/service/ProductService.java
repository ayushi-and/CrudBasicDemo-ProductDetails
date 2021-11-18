package com.demo.fullStackCrud.service;

import com.demo.fullStackCrud.entity.Product;
import com.demo.fullStackCrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        productRepository.save(product);
        return product;
    }

    public Product get(long id) {
        return productRepository.findById(id).get();
    }

    public void delete(long id) {
        productRepository.deleteById(id);
    }

    public Product update(Long id, Product updatedProduct) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setBrand(updatedProduct.getBrand());
        existingProduct.setId(updatedProduct.getId());
        existingProduct.setMadeIn(updatedProduct.getMadeIn());
        existingProduct.setPrice(updatedProduct.getPrice());
        return productRepository.save(existingProduct);
    }
}
