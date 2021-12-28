package com.example.Projekt21.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table
public class Rezyser {

    @Id
    @GeneratedValue
    private Long id;
    private String imie;
    private String nazwisko;
    private Date data_urodzenia;
    private String kraj_pochodzenia;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "rezyser")
    private List<Film> filmList;

    @JsonCreator
    public Rezyser(@JsonProperty("imie") String imie, @JsonProperty("nazwisko") String nazwisko,
                   @JsonProperty("data_urodzenia") Date data_urodzenia, @JsonProperty("kraj_pochodzenia") String kraj_pochodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data_urodzenia = data_urodzenia;
        this.kraj_pochodzenia = kraj_pochodzenia;
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

    public Date getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(Date data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public String getKraj_pochodzenia() {
        return kraj_pochodzenia;
    }

    public void setKraj_pochodzenia(String kraj_pochodzenia) {
        this.kraj_pochodzenia = kraj_pochodzenia;
    }

    @JsonCreator
    public Rezyser() {

    }

    @Override
    public String toString() {
        return "Reżyserzy{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", data_urodzenia=" + data_urodzenia +
                ", kraj_pochodzenia='" + kraj_pochodzenia + '\'' +
                '}';
    }
}
