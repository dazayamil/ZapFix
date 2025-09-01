package com.teamzapfix.zapfix.service.impl;

import com.teamzapfix.zapfix.dto.request.ClientPatchRequestDto;
import com.teamzapfix.zapfix.dto.request.ClientRequestDto;
import com.teamzapfix.zapfix.dto.response.ClientResponseDto;
import com.teamzapfix.zapfix.exception.APIRequestException;
import com.teamzapfix.zapfix.mapper.ClientMapper;
import com.teamzapfix.zapfix.model.entity.Client;
import com.teamzapfix.zapfix.model.enums.APIError;
import com.teamzapfix.zapfix.repository.ClientRepository;
import com.teamzapfix.zapfix.service.ClientService;
import com.teamzapfix.zapfix.utils.ClientSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    
    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }
    
    @Override
    public ClientResponseDto createClient(ClientRequestDto dto) {
        Client client = clientMapper.toEntity(dto);
        
        Client saveClient = clientRepository.save(client);
        
        return clientMapper.toResponse(saveClient);
    }
    
    @Override
    public ClientResponseDto getClientById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> {
            APIError.RECORD_NOT_FOUND.setTitleKey("client.error.message.not_found");
            APIError.RECORD_NOT_FOUND.setMessageKey("client.error.message.not_found.details");
            
            return new APIRequestException(APIError.RECORD_NOT_FOUND);
        });
        return clientMapper.toResponse(client);
    }
    
    @Override
    public Page<ClientResponseDto> getAllClients(Pageable pageable, Map<String, String> filters) {
        Specification<Client> spec = ClientSpecification.filter(filters);
        
        Page<Client> clients = clientRepository.findAll(spec, pageable);
        
        return clients.map(clientMapper::toResponse);
    }
    
    @Override
    public ClientResponseDto updateClientById(Long id, ClientRequestDto dto) throws APIRequestException {
        Client client = clientRepository.findById(id).orElseThrow(() -> {
            APIError.RECORD_NOT_FOUND.setTitleKey("client.error.message.not_found");
            APIError.RECORD_NOT_FOUND.setMessageKey("client.error.message.not_found.details");
            
            return new APIRequestException(APIError.RECORD_NOT_FOUND);
        });
        
        client.setName(dto.getName());
        client.setPhone(dto.getPhone());
        client.setEmail(dto.getEmail());
        
        Client updateClient = clientRepository.save(client);
        
        return clientMapper.toResponse(updateClient);
    }
    
    @Override
    public ClientResponseDto updatePartialClient(Long id, ClientPatchRequestDto dto) throws APIRequestException {
        Client client = clientRepository.findById(id).orElseThrow(() -> {
            APIError.RECORD_NOT_FOUND.setTitleKey("client.error.message.not_found");
            APIError.RECORD_NOT_FOUND.setMessageKey("client.error.message.not_found.details");
            
            return new APIRequestException(APIError.RECORD_NOT_FOUND);
        });
        
        if (dto.getName() != null && !dto.getName().isBlank()) {
            client.setName(dto.getName());
        }
        if (dto.getPhone() != null && !dto.getPhone().isBlank()) {
            client.setPhone(dto.getPhone());
        }
        if (dto.getEmail() != null && !dto.getEmail().isBlank()) {
            client.setEmail(dto.getEmail());
        }
        
        Client updateClient = clientRepository.save(client);
        
        return clientMapper.toResponse(updateClient);
    }
    
    @Override
    public void deleteClientById(Long id) throws APIRequestException {
        Client client = clientRepository.findById(id).orElseThrow(() -> {
            APIError.RECORD_NOT_FOUND.setTitleKey("client.error.message.not_found");
            APIError.RECORD_NOT_FOUND.setMessageKey("client.error.message.not_found.details");
            
            return new APIRequestException(APIError.RECORD_NOT_FOUND);
        });
        client.setIsActive(false);
        
        clientRepository.save(client);
    }
}