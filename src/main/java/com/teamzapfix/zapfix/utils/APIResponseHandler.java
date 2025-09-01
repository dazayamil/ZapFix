package com.teamzapfix.zapfix.utils;

import com.teamzapfix.zapfix.dto.response.PaginationDto;
import com.teamzapfix.zapfix.model.enums.APISuccess;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class APIResponseHandler {
    private final MessageSource msgSource;
    
    public APIResponseHandler(MessageSource msgSource) {
        this.msgSource = msgSource;
    }
    
    public <T> ResponseEntity<APIResponseData<T>> handleResponse(APISuccess success, T data) {
        APIResponseData<T> responseData = new APIResponseData<>(success, data, msgSource);
        return new ResponseEntity<>(responseData, success.getStatus());
    }
    
    public <T> ResponseEntity<APIResponseDataPagination<T>> handleResponse(APISuccess success, Page<T> page) {
        PaginationDto pagination = new PaginationDto(
                page.getPageable().getPageNumber(),
                page.getPageable().getPageSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.isFirst(),
                page.isLast(),
                page.getNumberOfElements(),
                page.getSort().isSorted(),
                page.getSort().isUnsorted()
        );
        APIResponseDataPagination<T> responseData = new APIResponseDataPagination<>(
                success,
                                                                                    pagination,
                                                                                    page.getContent(),
                                                                                    msgSource
        );
        return new ResponseEntity<>(responseData, success.getStatus());
    }
}