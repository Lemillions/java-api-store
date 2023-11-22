package com.nextboom.storeapi.dtos.Customer;

import jakarta.validation.constraints.NotBlank;

public record CustomerDto(@NotBlank String name, @NotBlank String email, @NotBlank String password) {
  
}
