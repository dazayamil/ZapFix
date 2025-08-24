package com.teamzapfix.zapfix.service;

import com.teamzapfix.zapfix.dto.request.ClientRequestDto;
import com.teamzapfix.zapfix.dto.response.ClientResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClientService {
    ClientResponseDto createClient(ClientRequestDto dto);
    ClientResponseDto getClientById(Long id);
    List<ClientResponseDto> getAllClients();
    ClientResponseDto updateClientById(Long id, ClientRequestDto dto);
    void deleteClientById(Long id);
}
