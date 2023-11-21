package com.nextboom.storeapi.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextboom.storeapi.dtos.CustomerDto;
import com.nextboom.storeapi.entities.Customer;
import com.nextboom.storeapi.services.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer/")
public class CustomerController {
  @Autowired
  private CustomerService customerService;

  @GetMapping("")
  public ResponseEntity<List<Customer>> getCustomer() {
    List<Customer> customers = customerService.getMany();

    return ResponseEntity.ok(customers);
  }

  @PostMapping("")
  public ResponseEntity<Customer> createCustomer(@RequestBody @Valid CustomerDto customerDto) {
    Customer customer = new Customer();
    BeanUtils.copyProperties(customerDto, customer);
    Customer newCustomer = customerService.save(customer);

    return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);
  }

  @PutMapping("{id}")
  public ResponseEntity<Customer> updateCustomer(@PathVariable("id") UUID id,
      @RequestBody @Valid CustomerDto customerDto) {
    Customer customer = customerService.getOne(id);

    BeanUtils.copyProperties(customerDto, customer);
    return ResponseEntity.ok(customer);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") UUID id) {
    Customer customerDeleted = customerService.delete(id);

    return ResponseEntity.ok(customerDeleted);
  }

}
