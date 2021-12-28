package com.example.Projekt21.controller;

import com.example.Projekt21.entity.Rezyser;
import com.example.Projekt21.service.RezyserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping
public class RezyserController {

    private final RezyserService rezyserService;

    @Autowired
    public RezyserController(RezyserService rezyserService){
        this.rezyserService = rezyserService;
    }

    @GetMapping(path = "/rezyser/get")
    public List<Rezyser> getRezyser(){
        return rezyserService.getRezyser();
    }

    @PostMapping(path = "/rezyser/post")
    public void registerNewRezyser(@RequestBody Rezyser rezyser){
        rezyserService.addNewRezyser(rezyser);
    }

    @DeleteMapping(path = "/rezyser/delete/{rezyserId}")
    public void deleteRezyser(@PathVariable("rezyserId")Long rezyserId){
        rezyserService.deleteRezyser(rezyserId);
    }

    @PutMapping(path = "/rezyser/put/{rezyserId}")
    public void updateStudent(
            @PathVariable("rezyserId") Long rezyserId,
            @RequestParam(required = false) String imie,
            @RequestParam(required = false) String nazwisko,
            @RequestParam(required = false) Date data_urodzenia,
            @RequestParam(required = false) String kraj_pochodzenia) {
        rezyserService.updateRezyser(rezyserId, imie, nazwisko, data_urodzenia, kraj_pochodzenia);
    }
}
