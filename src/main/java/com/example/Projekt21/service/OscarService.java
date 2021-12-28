package com.example.Projekt21.service;

import com.example.Projekt21.entity.Oscar;
import com.example.Projekt21.repository.OscarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class OscarService {

    private final OscarRepository oscarRepository;

    @Autowired
    public OscarService(OscarRepository oscarRepository){
        this.oscarRepository = oscarRepository;
    }

    public List<Oscar> getOscar(){
        return oscarRepository.findAll();
    }

    public void addNewOscar(Oscar oscar){
        oscarRepository.save(oscar);
    }

    public void deleteOscar(Long oscarId){
        boolean exists = oscarRepository.existsById(oscarId);
        if(!exists){
            throw new IllegalStateException("Oscar o numerze id:  " + oscarId + " nie istenieje");
        }
        oscarRepository.deleteById(oscarId);
    }

    @Transactional
    public void updateOscar(Long oscarId, Long rok) {
        Oscar oscar = oscarRepository.findById(oscarId).orElseThrow(() -> new IllegalStateException(
                "Oscar o numerze id:  " + oscarId + " nie istnieje"));

        if (rok != null && rok > 0 && rok != oscar.getRok()) {
            oscar.setRok(rok);
        }
    }
}
