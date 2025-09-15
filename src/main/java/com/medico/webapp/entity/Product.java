package com.medico.webapp.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;                 // Unique product ID

  private String name;               // Product name
  private String description;        // Detailed description
  private double price;              // Base price
  private double discountPrice;      // Discounted price if applicable
  private boolean isAvailable;       // Availability status

  private int stock;                 // Quantity available
  private String sku;                // Stock Keeping Unit
  private String brand;              // Brand name
  private String category;           // Category (e.g., electronics, fashion)
  private String subCategory;        // Sub-category (e.g., mobile, shoes)

  @ElementCollection
  private List<String> images;       // URLs of product images
  private String thumbnail;          // Main thumbnail image

  private double rating;             // Average customer rating
  private int totalReviews;          // Number of reviews

  private LocalDate createdAt;       // Creation timestamp
  private LocalDate updatedAt;       // Last update timestamp

  private boolean isFeatured;        // Highlighted product
  private boolean isOnSale;          // For promotional purposes
  @ElementCollection
  private List<String> tags;         // Search tags (SEO, keywords)

  // private Map<String, String> specifications; // Key-value specs (e.g., color: red, size: M)
}
