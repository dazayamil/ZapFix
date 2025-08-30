package com.teamzapfix.zapfix.model.enums;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum APISuccess {
    /**
     * Success response for resource retrieval operations.
     * *
     * * HTTP Status: 200 OK
     * * Typical use: GET operations
     */
    RESOURCE_RETRIEVED("Successful operation.", HttpStatus.OK),
    /**
     * Success response for resource creation operations.
     * *
     * * HTTP Status: 201 Created
     * * Typical use: POST operations
     */
    RESOURCE_CREATED("Resource created successful.", HttpStatus.CREATED),
    /**
     * Success response for resource update operations.
     * *
     * * HTTP Status: 200 OK
     * * Typical use: PUT/PATCH operations
     */
    RESOURCE_UPDATED("Resource successful updated.", HttpStatus.OK),
    /**
     * Success response for resource deletion operations.
     * *
     * * HTTP Status: 204 No Content
     * * Typical use: DELETE operations
     */
    RESOURCE_REMOVED("Resource successful deleted.", HttpStatus.NO_CONTENT);
    
    private String message;
    private final HttpStatus status;
    
    @JsonSetter
    public void setMessage(String message) {
        this.message = message;
    }
}