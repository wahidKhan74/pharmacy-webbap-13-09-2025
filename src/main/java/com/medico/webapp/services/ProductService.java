package com.medico.webapp.services;

import com.medico.webapp.entity.Product;
import com.medico.webapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public List<Product> getAll() {
    return productRepository.findAll();
  }

  public Product save(Product product) {
    return  productRepository.save(product);
  }

  public void delete(String id) {
    productRepository.deleteById(id);
  }

  public Product getById(String id) {
    return productRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Product not found: " + id));
  }
}
