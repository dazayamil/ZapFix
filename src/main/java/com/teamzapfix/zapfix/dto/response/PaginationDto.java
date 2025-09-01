package com.teamzapfix.zapfix.dto.response;

public record PaginationDto(
        Integer pageNumber,
        
        Integer pageSize,
        
        Long totalElements,
        
        Integer totalPages,
        
        Boolean first,
        
        Boolean last,
        
        Integer numberOfElements,
        
        Boolean sorted,
        
        Boolean unsorted
) {}