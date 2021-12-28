package com.example.Projekt21.service;

import com.example.Projekt21.entity.Krytyk;
import com.example.Projekt21.repository.KrytykRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class KrytykService {

    private final KrytykRepository krytykRepository;

    @Autowired
    public KrytykService(KrytykRepository krytykRepository){
        this.krytykRepository = krytykRepository;
    }

    public List<Krytyk> getKrytyk(){
        return krytykRepository.findAll();
    }

    public void addNewKrytyk(Krytyk krytyk){
        krytykRepository.save(krytyk);
    }

    public void deleteKrytyk(Long krytykId){
        boolean exists = krytykRepository.existsById(krytykId);
        if(!exists){
            throw new IllegalStateException("Krytyk o numerze id:  " + krytykId + " nie istenieje");
        }
        krytykRepository.deleteById(krytykId);
    }

    @Transactional
    public void updateKrytyk(Long krytykId, String imie, String nazwisko) {
        Krytyk krytyk = krytykRepository.findById(krytykId).orElseThrow(() -> new IllegalStateException(
                "Krytyk o numerze id:  " + krytykId + " nie istnieje"));

        if (imie != null && imie.length() > 0 && !Objects.equals(krytyk.getImie(), imie)) {
            krytyk.setImie(imie);
        }

        if (nazwisko != null && nazwisko.length() > 0 && !Objects.equals(krytyk.getNazwisko(), nazwisko)) {
            krytyk.setNazwisko(nazwisko);
        }
    }
}
