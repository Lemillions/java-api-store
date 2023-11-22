package com.nextboom.storeapi.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.nextboom.storeapi.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
  UserDetails findByEmail(String email);
  Optional<Customer> findOneByEmail(String email);
}
