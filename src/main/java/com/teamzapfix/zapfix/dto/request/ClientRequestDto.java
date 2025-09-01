package com.teamzapfix.zapfix.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRequestDto {
    @NotEmpty(message = "{client.name.not_empty}")
    @Size(min = 3, max = 100, message = "{client.name.size}")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+", message = "{client.name.pattern}")
    private String name;

    @NotEmpty(message = "{client.phoneNumber.not_empty}")
    @Pattern(regexp = "^\\d{10}$", message = "{client.phoneNumber.pattern}")
    private String phone;

    @Email(message = "{client.email.invalid}")
    @Size(max = 100, message = "{client.email.size}")
    private String email;
}