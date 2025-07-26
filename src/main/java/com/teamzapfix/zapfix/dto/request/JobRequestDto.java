package com.teamzapfix.zapfix.dto.request;

import com.teamzapfix.zapfix.model.entity.User;
import com.teamzapfix.zapfix.model.enums.JobStatus;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class JobRequestDto {
    @NotBlank(message = "{job.description.notblank}")
    @Size(min = 10, max = 500, message = "{job.description.size}")
    private String description;

    @Positive(message = "{job.cost.notnull}")
    private Double cost;

    @PositiveOrZero(message = "{job.deposit.positive}")
    private Double deposit;

    @NotBlank(message = "{job.state.notblank}")
    private JobStatus state;

    @NotNull(message = "{job.clientId.notnull}")
    @Positive(message = "{job.clientId.positive}")
    private Long clientId;
}
