package com.teamzapfix.zapfix.dto.request;

import com.teamzapfix.zapfix.model.enums.JobStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobRequestDto {
    @NotEmpty(message = "{job.description.not_empty}")
    @Size(min = 10, max = 500, message = "{job.description.size}")
    private String description;

    @NotNull(message = "{job.cost.not_null}")
    @Positive(message = "{job.cost.positive}")
    private Double cost;
    
    @NotNull(message = "{job.deposit.not_null}")
    @PositiveOrZero(message = "{job.deposit.positive}")
    @Min(value = 0, message = "{job.deposit.positive_mayor}")
    private Double deposit;

    @NotBlank(message = "{job.state.not_blank}")
    private JobStatus state;

    @NotEmpty(message = "{job.clientId.not_empty}")
    private Long clientId;
}