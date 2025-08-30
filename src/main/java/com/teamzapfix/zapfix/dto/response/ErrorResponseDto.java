package com.teamzapfix.zapfix.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Map;

@Builder
@Getter
@Setter
public class ErrorResponseDto {
    private final Boolean hasError = true;
    
    private String title;
    
    private String message;
    
    private Integer statusCode;
    
    private Map<String, String> reasons;
    
    private final LocalDateTime timestamp = ZonedDateTime.now().toLocalDateTime();
}