package com.nextboom.storeapi.services;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextboom.storeapi.entities.Customer;
import com.nextboom.storeapi.exceptions.NotFoundException;
import com.nextboom.storeapi.repository.CustomerRepository;

@Service
public class CustomerService {
  @Autowired
  private CustomerRepository customerRepository;

  public Customer getOne(UUID customerId) {
    Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

    if (optionalCustomer.isPresent()) {
      return optionalCustomer.get();
    }

    throw new NotFoundException("Cliente com id " + customerId + "não encontrado!");
  }

  public List<Customer> getMany() {
    List<Customer> customers = customerRepository.findAll();

    return customers;
  }

  public Customer save(Customer newCustomer) {
    Customer customer = customerRepository.save(newCustomer);

    return customer;
  }

  public Customer delete(UUID customerId) {
    Customer customer = getOne(customerId);
    customerRepository.delete(customer);

    return customer;
  }
}
