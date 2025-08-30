package com.teamzapfix.zapfix.model.enums;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum APIError {
    INVALID_REQUEST_DATA(
            HttpStatus.BAD_REQUEST,
            "Invalid request data",
            "The requested data contains invalid values or is in an incorrect format."
    ),
    INVALID_CREDENTIALS(
            HttpStatus.UNAUTHORIZED,
                        "Invalid credentials",
                        "The credentials provided are incorrect or have expired."
    ),
    BAD_REQUEST(
            HttpStatus.BAD_REQUEST,
                "Bad Request",
                "The request does not meet basic syntax or parameter requirements."
    ),
    BAD_FORMAT(
            HttpStatus.BAD_REQUEST,
            "Unsupported format",
            "The content of the request has an invalid or incompatible format"
    ),
    RECORD_NOT_FOUND(
            HttpStatus.NOT_FOUND,
            "Resource not found",
            "The requested resource does not exist or has been " + "deleted."
    ),
    ENDPOINT_NOT_FOUND(
            HttpStatus.NOT_FOUND,
            "Route not available",
            "The requested URL does not correspond to any available resource."
    ),
    UNAUTHORIZED(
            HttpStatus.UNAUTHORIZED,
                 "Unauthorized access",
                 "Valid credentials are required to access this resource."
    ),
    FORBIDDEN(
            HttpStatus.FORBIDDEN,
            "Insufficient permissions",
            "Your account does not have the necessary privileges for this operation."
    ),
    INTERNAL_SERVER_ERROR(
            HttpStatus.INTERNAL_SERVER_ERROR,
                          "System error",
                          "An unexpected error occurred. Please try again later."
    ),
    METHOD_NOT_ALLOWED(
            HttpStatus.METHOD_NOT_ALLOWED,
                       "Disallowed method",
                       "The HTTP verb used is not supported for this resource."
    ),
    UNPROCESSABLE_ENTITY(
            HttpStatus.UNPROCESSABLE_ENTITY,
            "Validation error",
            "The request is syntactically valid but failed business validations."
    ),
    RESOURCE_CONFLICT(
            HttpStatus.CONFLICT,
            "Resource conflict",
            "The current state of the resource creates a conflict with the requested operation."
    ),
    DUPLICATE_RESOURCE(
            HttpStatus.CONFLICT,
                       "Duplicate resource",
                       "A resource with the same identifier values already exists."
    ),
    UNIQUE_CONSTRAINT_VIOLATION(
            HttpStatus.CONFLICT,
            "Single Constraint Violation",
            "An attempt was made to create a resource with an existing unique field."
    ),
    RESOURCE_ASSOCIATED_EXCEPTION(
            HttpStatus.CONFLICT,
            "Existing dependencies",
            "The resource cannot be modified due to relationships with other elements."
    ),
    DATABASE_ERROR(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "Persistence error",
            "A critical operation with the data storage system failed."
    ),
    TIMEOUT_ERROR(
            HttpStatus.REQUEST_TIMEOUT,
            "Timed out",
            "The operation exceeded the maximum time allowed for its execution."
    ),
    EXTERNAL_API_ERROR(
            HttpStatus.BAD_GATEWAY,
            "Error de servicio externo",
            "Communication with a required third-party service failed."
    );
    
    private HttpStatus status;
    private String title;
    private String message;
    
    @JsonSetter
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
    
    @JsonGetter
    public void setTitle(String title) {
        this.title = title;
    }
    
    @JsonGetter
    public void setMessage(String message) {
        this.message = message;
    }
}