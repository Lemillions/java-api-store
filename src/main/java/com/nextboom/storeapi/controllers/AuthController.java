package com.nextboom.storeapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nextboom.storeapi.dtos.Auth.LoginRequestDto;
import com.nextboom.storeapi.dtos.Auth.LoginResponseDto;
import com.nextboom.storeapi.dtos.Customer.CustomerDto;
import com.nextboom.storeapi.entities.Customer;
import com.nextboom.storeapi.services.AuthService;
import com.nextboom.storeapi.services.CustomerService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {
  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private AuthService authService;

  @Autowired
  private CustomerService customerService;

  @PostMapping("/login")
  public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginRequestDto loginDto) {
    var usernamePassword = new UsernamePasswordAuthenticationToken(loginDto.email(), loginDto.password());
    Authentication auth = authenticationManager.authenticate(usernamePassword);
    String token = authService.generateToken((Customer) auth.getPrincipal());

    return ResponseEntity.ok(new LoginResponseDto(token));
  }

  @PostMapping("/register")
  public ResponseEntity<Customer> register(@RequestBody @Valid CustomerDto customerDto) {
    String encryptedPassword = new BCryptPasswordEncoder().encode(customerDto.password());

    Customer customer = new Customer(customerDto.name(), customerDto.email(), encryptedPassword);
    
    customerService.create(customer);

    return ResponseEntity.ok().body(customer);
  }
}
