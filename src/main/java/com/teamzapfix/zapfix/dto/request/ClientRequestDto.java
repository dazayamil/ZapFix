package com.teamzapfix.zapfix.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRequestDto {
    @NotBlank(message = "{client.name.notblank}")
    @Size(min = 3, max = 100, message = "{client.name.size}")
    private String name;

    @NotBlank(message = "{client.phoneNumber.notblank}")
    @Pattern(regexp = "^\\d{10}$", message = "{client.phoneNumber.pattern}")
    private String phone;

    @Email(message = "{client.email.invalid}")
    @Size(max = 100, message = "{client.email.size}")
    private String email;
}
