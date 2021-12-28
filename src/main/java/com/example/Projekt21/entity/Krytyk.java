package com.example.Projekt21.entity;

import javax.persistence.*;

@Table
@Entity
public class Krytyk {

    @Id
    @GeneratedValue
    private Long id;
    private String imie;
    private String nazwisko;

    public Krytyk(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Krytyk() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
}
