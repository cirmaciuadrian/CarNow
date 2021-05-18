package com.example.demo.controller;

import com.example.demo.Dto.Message;
import com.example.demo.model.Angajat;
import com.example.demo.service.AngajatiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/angajati")
public class AngajatiController {

    @Autowired
    private AngajatiService angajatiService;

    @GetMapping("/getAll")
    public List<Angajat> getAll(){
        return angajatiService.getAll();
    }

    @PostMapping("/add")
    public Angajat addAngajat(@RequestBody @Valid Angajat angajat){
        return angajatiService.addAngajat(angajat);
    }

    @DeleteMapping("/delete{id}")
    public Message deleteAngajat (@RequestParam int id){
        return angajatiService.delteAngajat(id);
    }
}
