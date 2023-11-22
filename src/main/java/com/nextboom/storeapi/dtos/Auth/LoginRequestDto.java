package com.nextboom.storeapi.dtos.Auth;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDto(@NotBlank String email, @NotBlank String password) {
  
}
