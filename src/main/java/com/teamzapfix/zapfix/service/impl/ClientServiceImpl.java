package com.teamzapfix.zapfix.service.impl;

import com.teamzapfix.zapfix.dto.request.ClientRequestDto;
import com.teamzapfix.zapfix.dto.response.ClientResponseDto;
import com.teamzapfix.zapfix.exception.ClientNotFoundException;
import com.teamzapfix.zapfix.mapper.ClientMapper;
import com.teamzapfix.zapfix.model.entity.Client;
import com.teamzapfix.zapfix.repository.ClientRepository;
import com.teamzapfix.zapfix.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;
    private ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper){
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
    public ClientResponseDto getClientById(Long id) throws ClientNotFoundException {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
        return clientMapper.toResponse(client);
    }

    @Override
    public List<ClientResponseDto> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(client -> clientMapper.toResponse(client))
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponseDto updateClient(Long id, ClientRequestDto dto) throws ClientNotFoundException {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
        client.setName(dto.getName());
        client.setPhone(dto.getPhone());
        client.setEmail(dto.getEmail());

        Client updateClient = clientRepository.save(client);
        return clientMapper.toResponse(updateClient);
    }
}
