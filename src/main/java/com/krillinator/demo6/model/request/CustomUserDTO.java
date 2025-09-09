package com.krillinator.demo6.model.request;

import jakarta.validation.constraints.*;

public record CustomUserDTO(
        @NotBlank(message = "Username must not be empty")
        @Size(min = 5, max = 50,message = "Username must be 5-50 characters long")
        String username,

        @NotBlank(message = "Password must not be empty")
        @Size(min = 5, max = 100,message = "Username must be 5-50 characters long")
        String password
) {
}
