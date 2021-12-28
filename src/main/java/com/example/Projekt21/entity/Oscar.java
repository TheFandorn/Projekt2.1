package com.example.Projekt21.entity;

import javax.persistence.*;

@Table
@Entity
public class Oscar {

    @Id
    @GeneratedValue
    private Long id;
    private Long rok;
    @OneToOne
    @JoinColumn(name = "idFilmu", referencedColumnName = "id")
    private Film idFilmu;
    @ManyToOne
    @JoinColumn(name = "idRezyserea", referencedColumnName = "id")
    private Rezyser idRezysera;


    public Oscar(Long idOscary, Long rok) {
        this.id = idOscary;
        this.rok = rok;
    }

    public Oscar() {
    }

    public Long getIdOscar() {
        return id;
    }

    public void setIdOscar(Long idOscary) {
        this.id = id;
    }

    public Long getRok() {
        return rok;
    }

    public void setRok(Long rok) {
        this.rok = rok;
    }

    public Film getIdFilmu() {
        return idFilmu;
    }

    public void setIdFilmu(Film idFilmu) {
        this.idFilmu = idFilmu;
    }
}
