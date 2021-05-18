package com.example.demo.controller;

import com.example.demo.Dto.MasiniValabileDto;
import com.example.demo.model.Masina;
import com.example.demo.service.ClientService;
import com.example.demo.service.MasinaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/masini")
public class MasinaController {

    @Autowired
    private MasinaService masinaService;

    @GetMapping("/get{id}")
    public ResponseEntity<?> getMasinaById(@RequestParam int id){
        return ResponseEntity.ok().body(masinaService.getMasinaById(id));
    }
    @PostMapping("/add")
    public ResponseEntity<?> addMasina(@RequestBody @Valid Masina masina){
        return ResponseEntity.ok().body(masinaService.addMasina(masina));
    }
    @GetMapping("/valabilitate{nrInmatriculare}")
    public List<MasiniValabileDto> getMasinaById(@RequestParam String nrInmatriculare){
        return masinaService.valabilitateDupaNrDeInmatriculare(nrInmatriculare);
    }
    @GetMapping("/getall")
    public List<Masina> getMasini (){
        return masinaService.getMasini();
    }
    @GetMapping("/search{cautare}")
    public List<Masina> searchMasini(@RequestParam String cautare){
        return masinaService.searchMasini(cautare);
    }

}
