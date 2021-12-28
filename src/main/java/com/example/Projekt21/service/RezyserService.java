package com.example.Projekt21.service;

import com.example.Projekt21.entity.Rezyser;
import com.example.Projekt21.repository.RezyserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Service
public class RezyserService {

    private final RezyserRepository rezyserRepository;

    @Autowired
    public RezyserService(RezyserRepository rezyserRepository){
        this.rezyserRepository = rezyserRepository;
    }

    public List<Rezyser> getRezyser(){
        return rezyserRepository.findAll();
    }

    public void addNewRezyser(Rezyser rezyser){
        rezyserRepository.save(rezyser);
    }

    public void deleteRezyser(Long rezyserId){
        boolean exists = rezyserRepository.existsById(rezyserId);
        if(!exists){
            throw new IllegalStateException("Rezyser o numerze id:  " + rezyserId + " nie istenieje");
        }
        rezyserRepository.deleteById(rezyserId);
    }

    @Transactional
    public void updateRezyser(Long rezyserId, String imie, String nazwisko, Date data_urodzenia, String kraj_pochodzenia) {
        Rezyser rezyser = rezyserRepository.findById(rezyserId).orElseThrow(() -> new IllegalStateException(
                "Rezyser o numerze id:  " + rezyserId + " nie istnieje"));

        if (imie != null && imie.length() > 0 && !Objects.equals(rezyser.getImie(), imie)) {
            rezyser.setImie(imie);
        }

        if (nazwisko != null && nazwisko.length() > 0 && !Objects.equals(rezyser.getNazwisko(), nazwisko)) {
            rezyser.setNazwisko(nazwisko);
        }

        if (data_urodzenia != null && data_urodzenia != rezyser.getData_urodzenia()) {
            rezyser.setData_urodzenia(data_urodzenia);
        }

        if (kraj_pochodzenia != null && kraj_pochodzenia.length() > 0 && !Objects.equals(rezyser.getKraj_pochodzenia(), kraj_pochodzenia)) {
            rezyser.setKraj_pochodzenia(kraj_pochodzenia);
        }
    }
}
