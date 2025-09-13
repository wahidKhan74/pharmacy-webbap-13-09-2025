package com.medico.webapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String username;
  private String email;
  private String password;
  private String phone;
  private boolean isActive;

  // private Address defaultAddress;

  // private List<Address> addresses;

  private LocalDateTime createdAt;
  private LocalDateTime lastLogin;
}

