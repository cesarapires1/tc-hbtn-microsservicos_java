package com.example.jpah2demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/addClient")
    public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
        cliente.setId(null);
        Cliente clienteCreated = clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCreated);
    }

    @GetMapping("/findAllClients")
    public ResponseEntity<List<Cliente>> findAllClients() {
        List<Cliente> allClientes = clienteRepository.findAll();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(allClientes);
    }

    @GetMapping("/findClientById/{id}")
    public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
        Cliente cliente = clienteRepository.findById(idClient).get();
        if (cliente.getId() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(cliente);
    }

    @DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long idClient){
        Cliente cliente = clienteRepository.getById(idClient);
        clienteRepository.delete(cliente);
    }

    @PutMapping("/updateClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){
        Cliente clienteAntigo = clienteRepository.getById(id);
        Cliente clienteAtualizado = new Cliente();
        clienteAtualizado = clienteAtualizado.updateCliente(clienteAntigo, cliente);

        clienteRepository.save(clienteAtualizado);
    }
}
