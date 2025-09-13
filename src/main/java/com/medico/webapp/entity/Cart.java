package com.medico.webapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Cart {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String customerId;
  // private List<CartItem> items;
  private double totalPrice;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}

