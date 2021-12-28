package com.example.Projekt21.service;

import com.example.Projekt21.entity.Film;
import com.example.Projekt21.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository){
        this.filmRepository = filmRepository;
    }

    public List<Film> getFilm(){
        return filmRepository.findAll();
    }

    public void addNewFilm(Film film){
        filmRepository.save(film);
    }

    public void deleteFilm(Long filmId){
        boolean exists = filmRepository.existsById(filmId);
        if(!exists){
            throw new IllegalStateException("Film o numerze id:  " + filmId + " nie istenieje");
        }
        filmRepository.deleteById(filmId);
    }


    @Transactional
    public void updateFilm(Long filmId, String tytul, String gatunek, Long rok_produkcji, Long id_rezysera) {
        Film film = filmRepository.findById(filmId).orElseThrow(() -> new IllegalStateException(
                "Film o numerze id:  " + filmId + " nie istnieje"));

        if (tytul != null && tytul.length() > 0 && !Objects.equals(film.getTytul(), tytul)) {
            film.setTytul(tytul);
        }

        if (gatunek != null && gatunek.length() > 0 && !Objects.equals(film.getGatunek(), gatunek)) {
            film.setGatunek(gatunek);
        }

        if (rok_produkcji != null && rok_produkcji > 0 && rok_produkcji != film.getRok_produkcji()) {
            film.setRok_produkcji(rok_produkcji);
        }
    }
}
