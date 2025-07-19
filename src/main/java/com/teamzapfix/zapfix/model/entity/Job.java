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
    private Long id;
    private String description;
    private LocalDate date;
    private double cost;
    private double deposit;

    @Enumerated(EnumType.STRING)
    private JobStatus state;
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
