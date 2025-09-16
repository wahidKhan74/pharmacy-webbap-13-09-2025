package com.medico.webapp.services;

import com.medico.webapp.entity.Customer;
import com.medico.webapp.entity.Product;
import com.medico.webapp.repository.CustomerRepository;
import com.medico.webapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  public List<Customer> getAll() {
    return customerRepository.findAll();
  }

  public Customer save(Customer customer) {
    return  customerRepository.save(customer);
  }

  public void delete(String id) {
    customerRepository.deleteById(id);
  }

  public Customer getById(String id) {
    return customerRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Customer not found: " + id));
  }
}
