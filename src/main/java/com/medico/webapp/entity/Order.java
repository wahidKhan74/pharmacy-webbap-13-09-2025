package com.medico.webapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String customerId;
  private double totalAmount;
  private String status;          // PENDING, SHIPPED, DELIVERED, CANCELLED
  private LocalDateTime orderDate;
  private LocalDateTime deliveryDate;

  //  private Payment paymentDetails;
 //  private Address shippingAddress;
 //  private List<OrderItem> items;
}

