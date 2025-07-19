package com.teamzapfix.zapfix.dto;

import com.teamzapfix.zapfix.model.entity.User;
import com.teamzapfix.zapfix.model.enums.JobStatus;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class JobRequestDTO {
    @NotNull(message = "{job.user.notnull}")
    private User user;

    @NotNull(message = "{job.clientId.notnull}")
    @Positive(message = "{job.clientId.positive}")
    private Long clientId;

    @NotBlank(message = "{job.description.notblank}")
    @Size(min = 10, max = 500, message = "{job.description.size}")
    private String description;

    @NotNull(message = "{job.date.notnull}")
    private LocalDate date;

    @Positive(message = "{job.cost.notnull}")
    private double cost;

    @PositiveOrZero(message = "{job.deposit.positive}")
    private double deposit;

    @NotBlank(message = "{job.state.notblank}")
    private JobStatus state;
}
