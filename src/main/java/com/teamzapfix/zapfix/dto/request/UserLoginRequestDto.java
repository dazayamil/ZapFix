package com.teamzapfix.zapfix.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginRequestDto {
    @NotBlank(message = "{user.user_login.not_empty}")
    private String username;

    @NotBlank(message = "{user.pass_login.not_empty}")
    private String password;
}