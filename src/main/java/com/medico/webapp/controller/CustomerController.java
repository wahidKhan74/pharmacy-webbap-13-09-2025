package com.medico.webapp.controller;

import com.medico.webapp.entity.Customer;
import com.medico.webapp.services.CustomerService;
import com.medico.webapp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  // GET all customers : Fetch all customers data
  @GetMapping()
  public List<Customer> getCustomers() {
    return customerService.getAll();
  }

  // Get one customer by id
  @GetMapping("/{id}")
  public Customer getCustomer(@PathVariable String id) {
   return customerService.getById(id);
  }

  // Add new customer
  @PostMapping()
  public Customer addCustomer(@RequestBody Customer customer) {
    return customerService.save(customer);
  }

  // Update a customer
  @PutMapping("/{id}")
  public Customer updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
    customer.setId(id);
    return customerService.save(customer);
  }

  // Delete a customer
  @DeleteMapping("/{id}")
  public void deleteCustomer(@PathVariable String id) {
    customerService.delete(id);
  }

}
