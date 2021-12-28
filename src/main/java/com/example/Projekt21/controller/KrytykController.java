package com.example.Projekt21.controller;

import com.example.Projekt21.entity.Krytyk;
import com.example.Projekt21.service.KrytykService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class KrytykController {

    private final KrytykService krytykService;

    @Autowired
    public KrytykController(KrytykService krytykService){
        this.krytykService = krytykService;
    }

    @GetMapping(path = "/krytyk/get")
    public List<Krytyk> getKrytyk(){
        return krytykService.getKrytyk();
    }

    @PostMapping(path = "/krytyk/post")
    public void registerNewKrytyk(@RequestBody Krytyk krytyk){
        krytykService.addNewKrytyk(krytyk);
    }

    @DeleteMapping(path = "/krytyk/delete/{krytykId}")
    public void deleteKrytyk(@PathVariable("krytykId")Long krytykId){
        krytykService.deleteKrytyk(krytykId);
    }

    @PutMapping(path = "/krytyk/put/{krytykId}")
    public void updateStudent(
            @PathVariable("krytykId") Long krytykId,
            @RequestParam(required = false) String imie,
            @RequestParam(required = false) String nazwisko) {
        krytykService.updateKrytyk(krytykId, imie, nazwisko);
    }
}
