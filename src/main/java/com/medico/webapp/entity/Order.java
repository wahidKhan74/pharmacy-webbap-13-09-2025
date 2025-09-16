package com.medico.webapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private double totalAmount;
  private String status;          // PENDING, SHIPPED, DELIVERED, CANCELLED
  private LocalDateTime orderDate;
  private LocalDateTime deliveryDate;

  //  private Payment paymentDetails;

  // Many orders -> one customer
  @ManyToOne
  @JoinColumn(name = "customer_id")
  @JsonBackReference // child
  private Customer customer;

   @OneToOne
   private Address shippingAddress;

   @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
   private List<OrderItem> items;
}

