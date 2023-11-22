package com.nextboom.storeapi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextboom.storeapi.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
}
