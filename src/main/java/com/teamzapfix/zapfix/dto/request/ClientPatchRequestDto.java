package com.teamzapfix.zapfix.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientPatchRequestDto {
    private String name;
    private String phone;
    private String email;
}
