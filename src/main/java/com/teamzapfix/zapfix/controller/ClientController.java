@RestController
@RequestMapping("/client")
public class ClientController {
    private ClientServiceImpl clientService;

    public ClientController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @PostMapping()
    public ResponseEntity<Client> createClient(@Valid @RequestBody ClientRequestDto dto) {
        ClientResponseDto response = clientService.createClient(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);    
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Long id) {
        try{
            ClientResponseDto response = clientService.getClientById(id);
            return ResponseEntity.ok(response);
        } catch (ClientNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientResponseDto>> getAllClients() {
        List<ClientResponseDto> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);  
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClientById(@PathVariable Long id, @Valid @RequestBody ClientRequestDto dto) {
        try {
            ClientResponseDto response = clientService.updateClientById(id, dto);
            return ResponseEntity.ok(response);
        } catch (ClientNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());    
        }
}