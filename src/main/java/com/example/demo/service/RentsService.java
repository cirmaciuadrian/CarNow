package com.example.demo.service;
import com.example.demo.Dto.Message;
import com.example.demo.Dto.RentsDto;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.model.Rent;
import com.example.demo.querys.Querys;
import com.example.demo.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.*;
import java.util.Calendar;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class RentsService {

    @Autowired
    private RentRepository rentRepository;

    public List<RentsDto> getAll(){
        return rentRepository.getAll();
    }

    public RentsDto addRent(int idClient, int idMasina){
        if(!rentRepository.clientExists(idClient))
            throw new BadRequestException("Clientul nu exista");
        if(!rentRepository.carExits(idMasina))
            throw new BadRequestException("Masina nu exista");
        if(!rentRepository.carIsFree(idMasina))
            throw new BadRequestException("Masina este deja inchiriaata");
        Rent rent = new Rent();
        rent.idClient=idClient;
        rent.idMasina=idMasina;
        rent.dataInchiriere = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        rent.pretTotal = 0;
        rentRepository.markCarAsBusy(idMasina);
        return rentRepository.addRent(rent);
    }

    public Message finishRent(int idMasina){
        var rentBd = rentRepository.getDataInceput(idMasina);
        if(rentBd.isEmpty())
            throw new BadRequestException("Masina selectata nu este inchiriata!");
        var rent = rentBd.get();
        java.sql.Date dataInchiriere= rent.getDataInchiriere();
        LocalDate dataFinalizare =  LocalDate.now();
        LocalDate dataInchiriereConvertita = dataInchiriere.toLocalDate();
        var zile = Period.between(dataInchiriereConvertita, dataFinalizare).getDays() ;

        var pret = rentRepository.getPretMasina(idMasina);
        rent.pretTotal = zile*pret +pret;
        rent.dataFinalizare =  new java.sql.Date(Calendar.getInstance().getTime().getTime());
        if(rentRepository.finishRent(rent)){
            rentRepository.markCarAsFree(idMasina);
            return new Message("Aveti de plata "+rent.getPretTotal()+" LEI!");
        }
        return new Message("Ceva nu a functionat");
    }

    public List<RentsDto> istoricMasina (int idMasina){
        var listaMasini = rentRepository.getIstoricMasina(idMasina);
        if(listaMasini.isEmpty())
            throw new BadRequestException("Masina selectata nu are un istoric");
        else return listaMasini;
    }

}
