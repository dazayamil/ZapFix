package com.teamzapfix.zapfix.mapper;

import com.teamzapfix.zapfix.dto.request.ClientRequestDto;
import com.teamzapfix.zapfix.dto.response.ClientResponseDto;
import com.teamzapfix.zapfix.model.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mapping(target = "isActive", constant = "true")
    Client toEntity(ClientRequestDto dto);
    
    ClientResponseDto toResponse(Client client);
}