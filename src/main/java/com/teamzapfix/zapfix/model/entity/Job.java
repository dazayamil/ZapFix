package com.teamzapfix.zapfix.model.entity;

import com.teamzapfix.zapfix.model.enums.JobStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Table (name = "job")
@AllArgsConstructor
@Getter
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Description is required")
    private String description;
    @NotNull(message = "Date is required")
    private LocalDate date;
    @Positive(message = "Cost must be greater than 0")
    private double cost;
    @PositiveOrZero(message = "Deposit cannot be negative")
    private double deposit;
    @NotNull(message = "State is required")
    private JobStatus state;
    private boolean isActive;
    @NotNull(message = "Client is required")
    private Client client;
    @NotNull(message = "User is required")
    private User user;
}
