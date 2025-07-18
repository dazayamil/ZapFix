package com.teamzapfix.zapfix.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClientRequestDTO {
    @NotBlank(message = "{client.name.notblank}")
    @Size(min = 3, max = 100, message = "{client.name.size}")
    private String name;

    @NotBlank(message = "{client.phoneNumber.notblank}")
    @Pattern(regexp = "^\\d{10}$", message = "{client.phoneNumber.pattern}")
    private String phone;

    @Email(message = "{client.email.notblank}")
    @Size(max = 100, message = "{client.email.size}")
    private String email;
}
