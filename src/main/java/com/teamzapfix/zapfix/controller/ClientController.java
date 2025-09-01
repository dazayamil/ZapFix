package com.teamzapfix.zapfix.controller;

import com.teamzapfix.zapfix.dto.request.ClientPatchRequestDto;
import com.teamzapfix.zapfix.dto.request.ClientRequestDto;
import com.teamzapfix.zapfix.dto.response.ClientResponseDto;
import com.teamzapfix.zapfix.model.enums.APISuccess;
import com.teamzapfix.zapfix.service.impl.ClientServiceImpl;
import com.teamzapfix.zapfix.utils.APIResponseData;
import com.teamzapfix.zapfix.utils.APIResponseDataPagination;
import com.teamzapfix.zapfix.utils.APIResponseHandler;
import jakarta.validation.Valid;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Validated
@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientServiceImpl clientService;
    private final APIResponseHandler apiResponseHandler;
    
    public ClientController(ClientServiceImpl clientService, APIResponseHandler apiResponseHandler) {
        this.clientService = clientService;
        this.apiResponseHandler = apiResponseHandler;
    }
    
    @PostMapping("/create")
    public ResponseEntity<APIResponseData<ClientResponseDto>> createClient(@Valid @RequestBody ClientRequestDto dto) {
        ClientResponseDto client = clientService.createClient(dto);
        
        APISuccess.RESOURCE_CREATED.setMessageKey("client.success.message.created");
        return apiResponseHandler.handleResponse(APISuccess.RESOURCE_CREATED, client);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<APIResponseData<ClientResponseDto>> getClientById(@PathVariable Long id) {
        ClientResponseDto client = clientService.getClientById(id);
        
        APISuccess.RESOURCE_RETRIEVED.setMessageKey("client.success.message.read");
        return apiResponseHandler.handleResponse(APISuccess.RESOURCE_RETRIEVED, client);
    }
    
    @GetMapping("/all")
    public ResponseEntity<APIResponseDataPagination<ClientResponseDto>> getAllClients(
            @RequestParam(required = false) Map<String, String> keywords, @DefaultValue @PageableDefault(
                    page = 1, size = 15, direction = Sort.Direction.ASC
            ) Pageable defaultPageable
    ) {
        Pageable pageable = PageRequest.of(
                defaultPageable.getPageNumber() >= 1 ? defaultPageable.getPageNumber() - 1 : 0,
                defaultPageable.getPageSize(),
                defaultPageable.getSort()
        );
        Page<ClientResponseDto> clientToPage = clientService.getAllClients(pageable, keywords);
        
        APISuccess.RESOURCE_RETRIEVED.setMessageKey("client.success.message.read.all");
        return apiResponseHandler.handleResponse(APISuccess.RESOURCE_RETRIEVED, clientToPage);
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<APIResponseData<ClientResponseDto>> updateClientById(
            @PathVariable Long id,
            @Valid @RequestBody ClientRequestDto dto
    ) {
        ClientResponseDto client = clientService.updateClientById(id, dto);
        
        APISuccess.RESOURCE_UPDATED.setMessageKey("client.success.message.updated");
        return apiResponseHandler.handleResponse(APISuccess.RESOURCE_UPDATED, client);
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<APIResponseData<ClientResponseDto>> updatePartialClient(
            @PathVariable Long id,
            @RequestBody ClientPatchRequestDto dto
    ) {
        ClientResponseDto client = clientService.updatePartialClient(id, dto);
        
        APISuccess.RESOURCE_UPDATED.setMessageKey("client.success.message.updated");
        return apiResponseHandler.handleResponse(APISuccess.RESOURCE_UPDATED, client);
    }
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<APIResponseData<Void>> deleteClientById(@PathVariable Long id) {
        clientService.deleteClientById(id);
        
        APISuccess.RESOURCE_REMOVED.setMessageKey("client.success.message.deleted");
        return apiResponseHandler.handleResponse(APISuccess.RESOURCE_REMOVED, (Void) null);
    }
}