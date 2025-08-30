package com.teamzapfix.zapfix.utils;

import com.teamzapfix.zapfix.model.enums.APISuccess;
import com.teamzapfix.zapfix.dto.response.PaginationDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public class APIResponseHandler {
    public static <T> ResponseEntity<APIResponseData<T>> handleResponse(APISuccess success, T data) {
        APIResponseData<T> responseData = new APIResponseData<>(success, data);
        return new ResponseEntity<>(responseData, success.getStatus());
    }
    
    public static <T> ResponseEntity<APIResponseDataPagination<T>> handleResponse(APISuccess success, Page<T> page) {
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
                                                                                    page.getContent()
        );
        return new ResponseEntity<>(responseData, success.getStatus());
    }
}