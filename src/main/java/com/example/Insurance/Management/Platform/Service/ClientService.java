package com.example.Insurance.Management.Platform.Service;


import com.example.Insurance.Management.Platform.Dtos.ClientRequestDto;
import com.example.Insurance.Management.Platform.Models.Client;
import com.example.Insurance.Management.Platform.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public String createClient(ClientRequestDto clientRequestDto) {

        Client client = Client.builder().name(clientRequestDto.getName()).date_of_birth(clientRequestDto.getDate_of_birth()).
                address(clientRequestDto.getAddress()).contact_information(clientRequestDto.getContact_information()).build();

        clientRepository.save(client);

        return "Client Created Succesfully";
    }


    public List<Client> getAllClients() {

        List<Client> clients = clientRepository.findAll();

        return clients;
    }

    public Client getClientById(int id) {
        Client client = null;

        try{
            client = clientRepository.findById(id).get();
        }
        catch (Exception e){
            System.out.println("Client not Present");
        }


        return client;
    }


    public String updateClient(ClientRequestDto clientRequestDto, int id) {

        Client client;

        try {
            client = clientRepository.findById(id).get();
        } catch (Exception e) {
            return "Client to be updated is not present";
        }

        client.setName(clientRequestDto.getName());
        client.setAddress(clientRequestDto.getAddress());
        client.setDate_of_birth(clientRequestDto.getDate_of_birth());
        client.setContact_information(clientRequestDto.getContact_information());

        clientRepository.save(client);

        return "Client Updated Succesfully";

    }

    public String deleteClient(int id) {
        Client client;

        try {
            client = clientRepository.findById(id).get();
        } catch (Exception e) {
            return "Client to be deleted is not present";
        }

        clientRepository.delete(client);
        return "Client deleted Succesfully";

    }
}
