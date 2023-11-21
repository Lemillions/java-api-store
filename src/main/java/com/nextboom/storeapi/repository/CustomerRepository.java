package com.nextboom.storeapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextboom.storeapi.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
