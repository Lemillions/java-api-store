package com.nextboom.storeapi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextboom.storeapi.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
