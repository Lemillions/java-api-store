package com.nextboom.storeapi.dtos;

import jakarta.validation.constraints.NotBlank;

public record CustomerDto(@NotBlank String name, @NotBlank String email, @NotBlank String password) {
  
}
