package com.teamzapfix.zapfix.dto.response;

import com.teamzapfix.zapfix.model.enums.JobStatus;

import java.time.LocalDate;

public class JobResponseDto {
    private Long id;
    private String description;
    private LocalDate date;
    private double cost;
    private double deposit;
    private JobStatus state;
    private Long clienteId;
    private String clientName;
    private Long userId;
    private String username;

}
