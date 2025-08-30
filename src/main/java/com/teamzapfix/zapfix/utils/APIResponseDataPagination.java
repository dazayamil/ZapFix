package com.teamzapfix.zapfix.utils;

import com.teamzapfix.zapfix.model.enums.APISuccess;
import com.teamzapfix.zapfix.dto.response.PaginationDto;
import lombok.Getter;

import java.util.List;

@Getter
public class APIResponseDataPagination<T> extends APIResponseData<T> {
    private final PaginationDto pagination;
    
    public APIResponseDataPagination(APISuccess success, PaginationDto pagination, List<T> data) {
        super(success, data);
        this.pagination = pagination;
    }
}