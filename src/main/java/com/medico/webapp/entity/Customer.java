package com.medico.webapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String username;
  private String email;
  private String password;
  private String phone;
  private boolean isActive;
  private LocalDateTime createdAt;
  private LocalDateTime lastLogin;

  @OneToOne(cascade = CascadeType.ALL)
  private Address defaultAddress;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Address> addresses;

  // One customer -> many orders
  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
  @JsonManagedReference // parent
  private List<Order> orders;
}

