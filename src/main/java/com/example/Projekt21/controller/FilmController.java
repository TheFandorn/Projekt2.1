package com.example.Projekt21.controller;

import com.example.Projekt21.entity.Film;
import com.example.Projekt21.repository.FilmRepository;
import com.example.Projekt21.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService){
        this.filmService = filmService;
    }

    @GetMapping(path = "/film/get")
    public List<Film> getFilm(){
        return filmService.getFilm();
    }

    @PostMapping(path = "/film/post")
    public void registerNewFilm(@RequestBody Film film){
        filmService.addNewFilm(film);
    }

    @DeleteMapping(path = "/film/delete/{filmId}")
    public void deleteFilm(@PathVariable("filmId")Long filmId){
        filmService.deleteFilm(filmId);
    }

    @PutMapping(path = "/film/put/{filmId}")
    public void updateFilm(
            @PathVariable("filmId") Long filmId,
            @RequestParam(required = false) String tytul,
            @RequestParam(required = false) String gatunek,
            @RequestParam(required = false) Long rok_produkcji,
            @RequestParam(required = false) Long id_rezysera) {
        filmService.updateFilm(filmId, tytul, gatunek, rok_produkcji, id_rezysera);
    }


}
