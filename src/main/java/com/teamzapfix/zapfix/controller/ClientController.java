package com.teamzapfix.zapfix.controller;

import com.teamzapfix.zapfix.dto.request.ClientRequestDto;
import com.teamzapfix.zapfix.dto.response.ClientResponseDto;
import com.teamzapfix.zapfix.exception.ClientNotFoundException;
import com.teamzapfix.zapfix.model.entity.Client;
import com.teamzapfix.zapfix.service.impl.ClientServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private ClientServiceImpl clientService;

    @Autowired
    public ClientController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @PostMapping()
    public ResponseEntity<ClientResponseDto> createClient(@Valid @RequestBody ClientRequestDto dto) {
        ClientResponseDto response = clientService.createClient(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Long id) {
            ClientResponseDto response = clientService.getClientById(id);
            return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientResponseDto>> getAllClients() {
        List<ClientResponseDto> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);  
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClientById(@PathVariable Long id, @Valid @RequestBody ClientRequestDto dto) {
        ClientResponseDto response = clientService.updateClientById(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClientById(@PathVariable Long id){
        clientService.deleteClientById(id);
        return ResponseEntity.noContent().build();
    }
}