package com.teamzapfix.zapfix.model.enums;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum APIError {
    INVALID_REQUEST_DATA(
            HttpStatus.BAD_REQUEST,
            "error.message.invalid_data.title",
            "error.message.invalid_data.details"
    ),
    INVALID_CREDENTIALS(
            HttpStatus.UNAUTHORIZED,
            "error.message.invalid_credential.title",
            "error.message.invalid_credential.details"
    ),
    BAD_REQUEST(
            HttpStatus.BAD_REQUEST,
            "error.message.bad_request.title",
            "error.message.bad_request.details"
    ),
    BAD_FORMAT(
            HttpStatus.BAD_REQUEST,
            "error.message.bad_format.title",
            "error.message.bad_format.details"
    ),
    RECORD_NOT_FOUND(
            HttpStatus.NOT_FOUND,
            "error.message.not_found.title",
            "error.message.not_found.details"
    ),
    ENDPOINT_NOT_FOUND(
            HttpStatus.NOT_FOUND,
            "error.message.endpoint_not_found.title",
            "error.message.endpoint_not_found.details"
    ),
    UNAUTHORIZED(
            HttpStatus.UNAUTHORIZED,
            "error.message.unauthorized.title",
            "error.message.unauthorized.details"
    ),
    FORBIDDEN(
            HttpStatus.FORBIDDEN,
            "error.message.forbidden.title",
            "error.message.forbidden.details"
    ),
    INTERNAL_SERVER_ERROR(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "error.message.internal_server.title",
            "error.message.internal_server.details"
    ),
    METHOD_NOT_ALLOWED(
            HttpStatus.METHOD_NOT_ALLOWED,
            "error.message.method_not_allowed.title",
            "error.message.method_not_allowed.details"
    ),
    UNPROCESSABLE_ENTITY(
            HttpStatus.UNPROCESSABLE_ENTITY,
            "error.message.unprocessable_entity.title",
            "error.message.unprocessable_entity.details"
    ),
    RESOURCE_CONFLICT(
            HttpStatus.CONFLICT,
            "error.message.resource_conflict.title",
            "error.message.resource_conflict.details"
    ),
    DUPLICATE_RESOURCE(
            HttpStatus.CONFLICT,
            "error.message.duplicate_resource.title",
            "error.message.duplicate_resource.details"
    ),
    UNIQUE_CONSTRAINT_VIOLATION(
            HttpStatus.CONFLICT,
            "error.message.unique_violation.title",
            "error.message.unique_violation.details"
    ),
    RESOURCE_ASSOCIATED_EXCEPTION(
            HttpStatus.CONFLICT,
            "error.message.associated.title",
            "error.message.associated.details"
    ),
    DATABASE_ERROR(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "error.message.database.title",
            "error.message.database.details"
    ),
    EXTERNAL_API_ERROR(
            HttpStatus.BAD_GATEWAY,
            "error.message.external.title",
            "error.message.external.details"
    );
    
    private HttpStatus status;
    private String titleKey;
    private String messageKey;
    
    @JsonSetter
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
    
    @JsonGetter
    public void setTitleKey(String titleKey) {
        this.titleKey = titleKey;
    }
    
    @JsonGetter
    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }
    
    public String getLocalizedTitle(MessageSource msgSource) {
        return msgSource.getMessage(this.titleKey, null, LocaleContextHolder.getLocale());
    }
    
    public String getLocalizedMessage(MessageSource msgSource) {
        return msgSource.getMessage(this.messageKey, null, LocaleContextHolder.getLocale());
    }
}