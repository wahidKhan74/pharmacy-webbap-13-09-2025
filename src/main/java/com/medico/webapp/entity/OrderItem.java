package com.medico.webapp.entity;

import lombok.Data;

@Data
public class OrderItem {
  private String productId;
  private String name;
  private int quantity;
  private double price;   // snapshot price at time of order
}
