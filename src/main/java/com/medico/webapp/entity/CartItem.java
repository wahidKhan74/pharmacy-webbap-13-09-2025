package com.medico.webapp.entity;

import lombok.Data;

@Data
public class CartItem {
  private String productId;
  private int quantity;
  private double price;       // snapshot price
}
