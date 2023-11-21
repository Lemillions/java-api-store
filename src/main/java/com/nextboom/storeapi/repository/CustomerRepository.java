package com.nextboom.storeapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nextboom.storeapi.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
