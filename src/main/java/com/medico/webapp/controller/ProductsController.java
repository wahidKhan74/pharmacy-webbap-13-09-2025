package com.medico.webapp.controller;

import com.medico.webapp.dto.Response;
import com.medico.webapp.entity.Product;
import com.medico.webapp.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
@Tag(name="Products", description = "Operations related to products")
public class ProductsController {

  @Autowired
  private ProductService productService;

  // GET all products : Fetch all products data
  @GetMapping()
  @Operation(
    summary = "Get All products",
    description = "Fetch all product details",
    security = { @SecurityRequirement(name = "bearerAuth") } // Requires JWT token
  )
  public  ResponseEntity<Response> getProducts() {
    return productService.getAll();
  }

  // Get one product by id
  @GetMapping("/{id}")
  @Operation(
    summary = "Get product by ID",
    description = "Fetch product details by product ID",
    security = { @SecurityRequirement(name = "bearerAuth") } // Requires JWT token
  )
  public ResponseEntity<Response> getProduct(@PathVariable String id) {
   return productService.getById(id);
  }

  // Add new product
  @PostMapping()
  @Operation(
    summary = "Create a new product",
    description = "Add a new product to the catalog",
    security = { @SecurityRequirement(name = "bearerAuth") }
  )
  public ResponseEntity<Response> addProduct(@RequestBody Product product) {
    return productService.save(product);
  }

  // Update a product
  @PutMapping("/{id}")
  @Operation(
    summary = "Update product by ID",
    description = "Update product details by product ID",
    security = { @SecurityRequirement(name = "bearerAuth") } // Requires JWT token
  )
  public ResponseEntity<Response> updateProduct(@PathVariable String id, @RequestBody Product product) {
    product.setId(id);
    return productService.update(product);
  }

  // Delete a product
  @DeleteMapping("/{id}")
  @Operation(
    summary = "Delete product by ID",
    description = "Delete product details by product ID",
    security = { @SecurityRequirement(name = "bearerAuth") } // Requires JWT token
  )
  public ResponseEntity<Response> deleteProduct(@PathVariable String id) {
    return productService.delete(id);
  }

}
