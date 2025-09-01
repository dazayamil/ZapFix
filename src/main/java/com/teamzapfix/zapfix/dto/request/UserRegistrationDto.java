package com.teamzapfix.zapfix.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegistrationDto {
    @NotBlank(message = "{user.username.not_empty}")
    @Size(min = 2, max = 20, message = "{user.username.size}")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+", message = "{user.username.pattern}")
    private String username;
    
    @NotBlank(message = "{user.password.not_empty}")
    @Size(min = 4, message = "{user.password.size}")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).{8,}$", message = "{user.password.pattern}")
    private String password;
}