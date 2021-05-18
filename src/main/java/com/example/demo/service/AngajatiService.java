package com.example.demo.service;

import com.example.demo.Dto.Message;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.model.Angajat;
import com.example.demo.repository.AngajatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AngajatiService {

    @Autowired
    private AngajatRepository angajatRepository;

    public List<Angajat> getAll(){
        return angajatRepository.getAll();
    }

    public Angajat addAngajat (Angajat angajat){
        var cnp = angajat.getCnp();
        if(cnp.matches("[0-9]+") ==false){
            throw new BadRequestException("Cnp-ul este format doar din cifre!");
        }
        if(angajatRepository.cautaAngajatDupaCnp(cnp).isPresent()){
            throw new BadRequestException("Cnp-ul exita deja in baza de date!");
        }
        return angajatRepository.addAngajat(angajat);

    }

    public Message delteAngajat (int id){
        if(angajatRepository.stergeAngajat(id))
            return new Message("Angajatul cu id-ul "+ id + " a fost sters cu succes!");
        throw new BadRequestException("Ceva nu a functionat");
    }
}
