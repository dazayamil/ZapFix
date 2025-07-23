package com.teamzapfix.zapfix.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegistrationDto {
    @NotBlank(message = "{user.username.notblank}")
    @Size(min = 2, max = 100, message = "{user.username.size}")
    private String username;

    @NotBlank(message = "{user.password.notblank}")
    @Size(min = 4, message = "{user.password.size}")
    private String password;
}
