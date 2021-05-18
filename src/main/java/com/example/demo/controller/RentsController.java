package com.example.demo.controller;

import com.example.demo.Dto.Message;
import com.example.demo.Dto.RentsDto;
import com.example.demo.service.RentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rents")
public class RentsController {

    @Autowired
    private RentsService rentsService;

    @GetMapping("/getAll")
    public List<RentsDto> getAll(){
        return rentsService.getAll();
    }

    @PostMapping("/add{idClient}{idMasina}")
    public RentsDto addRent(@RequestParam int idClient, @RequestParam int idMasina){
        return rentsService.addRent(idClient,idMasina);
    }
    @GetMapping("/finishRent{idMasina}")
    public Message finishRent(@RequestParam int idMasina){
        return rentsService.finishRent(idMasina);
    }

    @GetMapping("/istoric{idMasina}")
    public List<RentsDto> istoricMasina(@RequestParam int idMasina){
        return rentsService.istoricMasina(idMasina);
    }
}
