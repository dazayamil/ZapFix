package com.teamzapfix.zapfix.dto.request;

import com.teamzapfix.zapfix.model.entity.User;
import com.teamzapfix.zapfix.model.enums.JobStatus;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class JobRequestDto {
    @NotBlank(message = "{job.description.notblank}")
    @Size(min = 10, max = 500, message = "{job.description.size}")
    private String description;

    @Positive(message = "{job.cost.notnull}")
    private double cost;

    @PositiveOrZero(message = "{job.deposit.positive}")
    private double deposit;

    @NotBlank(message = "{job.state.notblank}")
    private JobStatus state;

    @NotNull(message = "{job.clientId.notnull}")
    @Positive(message = "{job.clientId.positive}")
    private Long clientId;
}
