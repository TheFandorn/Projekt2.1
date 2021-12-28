package com.example.Projekt21.entity;

import javax.persistence.*;

@Table
@Entity
public class Ocena {

    @Id
    @GeneratedValue
    private Long idOceny;
    @ManyToOne
    @JoinColumn(name = "idFilmu", referencedColumnName = "id")
    private Film idFilmu;
    @ManyToOne
    @JoinColumn(name = "idKrytyka", referencedColumnName = "id")
    private Krytyk idKrytyka;
    private Long ocena;

    public Ocena(Long ocena) {
        this.ocena = ocena;
    }

    public Ocena() {
    }

    public Long getIdOceny() {
        return idOceny;
    }

    public void setIdOceny(Long idOceny) {
        this.idOceny = idOceny;
    }

    public Long getOcena() {
        return ocena;
    }

    public void setOcena(Long ocena) {
        this.ocena = ocena;
    }
}
