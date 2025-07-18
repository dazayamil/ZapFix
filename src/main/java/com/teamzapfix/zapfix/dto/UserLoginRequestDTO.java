package com.teamzapfix.zapfix.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginRequestDTO {
    @NotBlank(message = "{user.user_login.notblank}")
    private String username;

    @NotBlank(message = "{user.pass_login.notblank}")
    private String password;
}
