package com.example.Projekt21.controller;

import com.example.Projekt21.entity.Oscar;
import com.example.Projekt21.service.OscarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class OscarController {

    private final OscarService oscarService;

    @Autowired
    public OscarController(OscarService oscarService){
        this.oscarService = oscarService;
    }

    @GetMapping(path = "/oscar/get")
    public List<Oscar> getOscar(){
        return oscarService.getOscar();
    }

    @PostMapping(path = "/oscar/post")
    public void registerNewOscar(@RequestBody Oscar oscar){
        oscarService.addNewOscar(oscar);
    }

    @DeleteMapping(path = "/oscar/delete/{oscarId}")
    public void deleteOscar(@PathVariable("oscarId")Long oscarId){
        oscarService.deleteOscar(oscarId);
    }

    @PutMapping(path = "/oscar/put/{oscarId}")
    public void updateStudent(
            @PathVariable("oscarId") Long oscarId,
            @RequestParam(required = false) Long rok) {
        oscarService.updateOscar(oscarId, rok);
    }
}
