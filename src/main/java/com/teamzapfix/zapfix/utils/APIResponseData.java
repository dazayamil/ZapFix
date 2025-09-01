package com.teamzapfix.zapfix.utils;

import com.teamzapfix.zapfix.model.enums.APISuccess;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class APIResponseData<T> {
    private final Object data;
    private final Boolean hasError = false;
    private final String message;
    private final Integer statusCode;
    private final LocalDateTime timestamp = LocalDateTime.now();
    
    /**
     * Constructor that initializes the standard API success response.
     *
     * @param success APISuccess instance containing the HTTP message and status.
     * @param data    Object with the data resulting from the operation.
     */
    public APIResponseData(APISuccess success, T data) {
        this.data = data;
        this.message = success.getMessage();
        this.statusCode = success.getStatus().value();
    }
    
    public APIResponseData(APISuccess success, List<T> data) {
        this.data = data;
        this.message = success.getMessage();
        this.statusCode = success.getStatus().value();
    }
    
}