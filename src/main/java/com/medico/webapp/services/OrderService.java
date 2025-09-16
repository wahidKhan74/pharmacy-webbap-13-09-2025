package com.medico.webapp.services;

import com.medico.webapp.entity.Order;
import com.medico.webapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  public List<Order> getAll() {
    return orderRepository.findAll();
  }

  public Order save(Order order) {
    return  orderRepository.save(order);
  }

  public void delete(String id) {
    orderRepository.deleteById(id);
  }

  public Order getById(String id) {
    return orderRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Order not found: " + id));
  }
}
