package com.teamzapfix.zapfix.service;

import com.teamzapfix.zapfix.dto.request.ClientPatchRequestDto;
import com.teamzapfix.zapfix.dto.request.ClientRequestDto;
import com.teamzapfix.zapfix.dto.response.ClientResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface ClientService {
    ClientResponseDto createClient(ClientRequestDto dto);
    
    ClientResponseDto getClientById(Long id);
    
    Page<ClientResponseDto> getAllClients(Pageable pageable, Map<String, String> filters);
    
    ClientResponseDto updateClientById(Long id, ClientRequestDto dto);
    
    ClientResponseDto updatePartialClient(Long id, ClientPatchRequestDto dto);
    
    void deleteClientById(Long id);
}