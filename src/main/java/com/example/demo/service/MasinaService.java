package com.example.demo.service;

import com.example.demo.Dto.MasiniValabileDto;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Masina;
import com.example.demo.querys.Querys;
import com.example.demo.repository.MasinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MasinaService {

    @Autowired
    private MasinaRepository masinaRepository;
    private Object MasiniValabileDto;

    public Optional<Masina> getMasinaById(int id){
        var masina  =masinaRepository.getMasinaById(id);
        if(masina.isEmpty())
            throw new NotFoundException("Masina nu a fost gasita");
        else return masina;
    }

    public Masina addMasina (Masina masina){
        var nrInmatriculare = masina.getNrInmatriculare();
        if(masinaRepository.getMasiniByNrInmatriculare(nrInmatriculare).stream().findFirst().isPresent()){
            throw new BadRequestException("Acest numar de inmatriculare exita deja in baza de date!");
        }
        return masinaRepository.addMasina(masina);
    }

    public List<MasiniValabileDto> valabilitateDupaNrDeInmatriculare(String cautare){
        var listaMasiniRepo =  masinaRepository.getMasiniByNrInmatriculare(cautare);
         List<MasiniValabileDto> listaMasini = new ArrayList<MasiniValabileDto>();
        for(int i=0;i<listaMasiniRepo.size();i++) {
            MasiniValabileDto masina = new MasiniValabileDto();
            masina.numarInmatriculare = listaMasiniRepo.get(i).nrInmatriculare;
            if(listaMasiniRepo.get(i).isInchiriata())
                masina.valabil="masina ocupata";
            else masina.valabil="masina libera";
            listaMasini.add(masina);
        }
        if(listaMasini.isEmpty()) {
            MasiniValabileDto masina = new MasiniValabileDto();
            masina.numarInmatriculare = " - ";
            masina.valabil = "-";
        }
        return listaMasini;

    }

    public List<Masina> getMasini (){
        return masinaRepository.getMasini();
    }

    public List<Masina> searchMasini(String cautare){
        return masinaRepository.searchMasini(cautare);
    }
}
