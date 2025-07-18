package com.teamzapfix.zapfix.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "User_name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String userName;

    @NotBlank(message = "Password is required")
    @Size(min = 4, max = 100, message = "Password must be at least 4 characters long")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Invalid password format")
    private String password;
}
