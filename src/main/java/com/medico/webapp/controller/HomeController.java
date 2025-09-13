package com.medico.webapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  @GetMapping("/")
  public String indexMapping() {
    return "The Spring application is Up and Running !";
  }

  @GetMapping("/hello")
  public String helloMapping() {
    return "Hello , Spring boot !";
  }
}
