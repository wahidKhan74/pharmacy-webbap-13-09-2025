package com.medico.webapp.controller;

import com.medico.webapp.entity.Product;
import com.medico.webapp.repository.ProductRepository;
import com.medico.webapp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

  @Autowired
  private ProductService productService;

  // GET all products : Fetch all products data
  @GetMapping()
  public List<Product> getProducts() {
    return productService.getAll();
  }

  // Get one product by id
  @GetMapping("/{id}")
  public Product getProduct(@PathVariable String id) {
   return productService.getById(id);
  }

  // Add new product
  @PostMapping()
  public Product addProduct(@RequestBody Product product) {
    return productService.save(product);
  }

  // Update a product
  @PutMapping("/{id}")
  public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
    product.setId(id);
    return productService.save(product);
  }

  // Delete a product
  @DeleteMapping("/{id}")
  public void deleteProduct(@PathVariable String id) {
    productService.delete(id);
  }

}
