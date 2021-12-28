package com.example.Projekt21.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Table
@Entity
public class Film {

    @Id
    @GeneratedValue
    private Long id;
    private String tytul;
    private String gatunek;
    private Long rok_produkcji;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Rezyser rezyser;

    public Film(String tytul, String gatunek, Long rok_produkcji,Rezyser rezyser) {
        this.tytul = tytul;
        this.gatunek = gatunek;
        this.rok_produkcji = rok_produkcji;
        this.rezyser = rezyser;
    }

    @JsonCreator
    public Film() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public Long getRok_produkcji() {
        return rok_produkcji;
    }

    public void setRok_produkcji(Long rok_produkcji) {
        this.rok_produkcji = rok_produkcji;
    }

    public Rezyser getRezyser() {
        return rezyser;
    }

    public void setRezyser(Rezyser rezyser) {
        this.rezyser = rezyser;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", tytul='" + tytul + '\'' +
                ", gatunek='" + gatunek + '\'' +
                ", rok_produkcji=" + rok_produkcji +
                ", id_rezysera=" + rezyser +
                '}';
    }
}
