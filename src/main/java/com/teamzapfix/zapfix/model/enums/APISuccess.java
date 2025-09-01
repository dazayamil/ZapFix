package com.teamzapfix.zapfix.model.enums;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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
    RESOURCE_RETRIEVED("success.message.read", HttpStatus.OK),
    /**
     * Success response for resource creation operations.
     * *
     * * HTTP Status: 201 Created
     * * Typical use: POST operations
     */
    RESOURCE_CREATED("success.message.created", HttpStatus.CREATED),
    /**
     * Success response for resource update operations.
     * *
     * * HTTP Status: 200 OK
     * * Typical use: PUT/PATCH operations
     */
    RESOURCE_UPDATED("success.message.updated", HttpStatus.OK),
    /**
     * Success response for resource deletion operations.
     * *
     * * HTTP Status: 204 No Content
     * * Typical use: DELETE operations
     */
    RESOURCE_REMOVED("success.message.deleted", HttpStatus.NO_CONTENT);
    
    private String messageKey;
    private final HttpStatus status;
    
    @JsonSetter
    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }
    
    public String getLocalizedMessage(MessageSource msgSource) {
        return msgSource.getMessage(this.messageKey, null, LocaleContextHolder.getLocale());
    }
}