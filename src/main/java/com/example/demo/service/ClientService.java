package com.example.demo.service;

import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClienti(){
        return clientRepository.getClienti();
    }

    public List<Client> adaugaClient (Client client){

        if(validateCard(client))
            return clientRepository.adaugaClient(client);
        else return null;
    }

    public Optional<Client> editClientById (Client client){
        if(validateCard(client)) {
            var returnedClient = clientRepository.editClientById(client).stream().findFirst();
            if(returnedClient.isEmpty())
                throw new NotFoundException("Clientul nu a fost gasit");
        }
        return null;
    }


    public boolean validateCard(Client client){
        var cardBancar = client.getContBancar();
        cardBancar = cardBancar.replace(" ", "");
        if( cardBancar.length()!=16 || cardBancar.matches("[0-9]+") ==false){
            throw new BadRequestException("Formatul cardului bancar este gresit!");
        }

        return true;
    }
}
