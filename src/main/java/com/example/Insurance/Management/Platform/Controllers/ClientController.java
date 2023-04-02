package com.example.Insurance.Management.Platform.Controllers;


import com.example.Insurance.Management.Platform.Dtos.ClientRequestDto;
import com.example.Insurance.Management.Platform.Models.Client;
import com.example.Insurance.Management.Platform.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<String> createClient(@RequestBody() ClientRequestDto clientRequestDto) {
        String str = clientService.createClient(clientRequestDto);

        return new ResponseEntity<>(str, HttpStatus.CREATED);
    }


    @GetMapping("getall")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClients();

        if (clients == null) {
            return new ResponseEntity<>(clients, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(clients, HttpStatus.ACCEPTED);

        }

    }

    @GetMapping("getclientbyid")
    public ResponseEntity<Client> getClientById(@RequestParam("id") int id) {
        Client client = clientService.getClientById(id);

        if (client == null) {
            return new ResponseEntity<>(client, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(client, HttpStatus.ACCEPTED);

        }

    }

    @PutMapping("update")
    public ResponseEntity<String> updateClient(@RequestBody() ClientRequestDto clientRequestDto, @RequestParam("id") int id) {
        String str = clientService.updateClient(clientRequestDto, id);

        if (str == "Client to be updated is not present") {
            return new ResponseEntity<>(str, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(str, HttpStatus.ACCEPTED);
        }

    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteClient(@RequestParam("id") int id) {

        String str = clientService.deleteClient(id);

        if (str == "Client to be deleted is not present") {
            return new ResponseEntity<>(str, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(str, HttpStatus.ACCEPTED);
        }

    }


}
