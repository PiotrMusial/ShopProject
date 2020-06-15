package com.project.shop.Services;

import com.project.shop.Entities.Product;
import com.project.shop.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findByCategory(String name) {
        return productRepository.findByCategory(name);
    }

    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

}
