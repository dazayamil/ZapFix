package com.teamzapfix.zapfix.exception;

import com.teamzapfix.zapfix.dto.response.ErrorResponseDto;
import com.teamzapfix.zapfix.model.enums.APIError;
import jakarta.el.MethodNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final MessageSource messageSource;
    
    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex
    ) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((error) -> errors.put(
                error.getField(),
                error.getDefaultMessage()
        ));
        return new ResponseEntity<>(
                ErrorResponseDto.builder()
                                .title(APIError.INVALID_REQUEST_DATA.getLocalizedTitle(messageSource))
                                .message(APIError.INVALID_REQUEST_DATA.getLocalizedMessage(messageSource))
                                .statusCode(APIError.INVALID_REQUEST_DATA.getStatus().value())
                                .reasons(errors)
                                .build(), HttpStatus.BAD_REQUEST
        );
    }
    
    @ExceptionHandler(APIRequestException.class)
    public ResponseEntity<ErrorResponseDto> handleApiRequestException(final APIRequestException ex) {
        String title = ex.getApiError() != null ? ex.getApiError().getLocalizedTitle(messageSource) : ex.getTitle();
        String message =
                ex.getApiError() != null ? ex.getApiError().getLocalizedMessage(messageSource) : ex.getMessage();
        
        return new ResponseEntity<>(
                ErrorResponseDto.builder()
                                .title(title)
                                .message(message)
                                .statusCode(ex.getStatusCode().value())
                                .reasons(ex.getReasons())
                                .build(), ex.getStatusCode()
        );
    }
    
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleNotFoundException() {
        return new ResponseEntity<>(
                ErrorResponseDto.builder()
                                .title(APIError.UNPROCESSABLE_ENTITY.getLocalizedTitle(messageSource))
                                .message(APIError.UNPROCESSABLE_ENTITY.getLocalizedMessage(messageSource))
                                .statusCode(APIError.UNPROCESSABLE_ENTITY.getStatus().value())
                                .reasons(null)
                                .build(), APIError.UNPROCESSABLE_ENTITY.getStatus()
        );
    }
    
    @ExceptionHandler(MethodNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleEndpointNotFoundException() {
        return new ResponseEntity<>(
                ErrorResponseDto.builder()
                                .title(APIError.ENDPOINT_NOT_FOUND.getLocalizedTitle(messageSource))
                                .message(APIError.ENDPOINT_NOT_FOUND.getLocalizedMessage(messageSource))
                                .statusCode(APIError.ENDPOINT_NOT_FOUND.getStatus().value())
                                .reasons(null)
                                .build(), APIError.ENDPOINT_NOT_FOUND.getStatus()
        );
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleAllExceptions() {
        return new ResponseEntity<>(
                ErrorResponseDto.builder()
                                .title(APIError.INTERNAL_SERVER_ERROR.getLocalizedTitle(messageSource))
                                .message(APIError.INTERNAL_SERVER_ERROR.getLocalizedMessage(messageSource))
                                .statusCode(APIError.INTERNAL_SERVER_ERROR.getStatus().value())
                                .reasons(null)
                                .build(), APIError.INTERNAL_SERVER_ERROR.getStatus()
        );
    }
}