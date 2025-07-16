package com.teamzapfix.zapfix.model.entity;

import com.teamzapfix.zapfix.model.enums.JobStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table (name = "job")
@AllArgsConstructor
@NoArgsConstructor
@Setter
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

    @ManyToOne
    @JoinColumn(name = "client_id")
    @NotNull(message = "Client is required")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull(message = "User is required")
    private User user;
}
