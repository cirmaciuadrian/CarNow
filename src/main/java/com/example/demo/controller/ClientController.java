package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clienti")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/get")
    public List<Client> getClienti(){
        return clientService.getClienti();
    }

    @PostMapping("/add")
    public ResponseEntity<?> adaugaClient (@RequestBody @Valid Client client){

       return ResponseEntity.ok().body(clientService.adaugaClient(client));
    }

    @PutMapping("/edit{id}")
    public ResponseEntity<?>  editClientById (@RequestParam int id, @RequestBody @Valid Client client){
        client.setId(id);
        return ResponseEntity.ok().body(clientService.editClientById(client));
    }



}