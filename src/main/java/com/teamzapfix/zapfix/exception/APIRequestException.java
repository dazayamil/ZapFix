package com.teamzapfix.zapfix.exception;

import com.teamzapfix.zapfix.model.enums.APIError;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
public class APIRequestException extends RuntimeException {
    
    
    private final Boolean hasError = true;
    private final String title;
    private final String message;
    private final HttpStatus statusCode;
    private Map<String, String> reasons;
    private APIError apiError;
    
    public APIRequestException(APIError apiError) {
        super();
        this.title = apiError.getTitle();
        this.message = apiError.getMessage();
        this.statusCode = apiError.getStatus();
        this.apiError = apiError;
    }
    
    public APIRequestException(
            final String title,
            final String message,
            final HttpStatus statusCode,
            final Map<String, String> reasons
    ) {
        super();
        this.title = title;
        this.message = message;
        this.statusCode = statusCode;
        this.reasons = reasons;
    }
    
    public APIRequestException(final APIError apiError, final String title, final String message) {
        super();
        this.title = title;
        this.message = message;
        this.apiError = apiError;
        this.statusCode = apiError.getStatus();
    }
}