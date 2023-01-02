package it.unicam.ids.backend;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Persona {

    @Id
    private int id;
    private String nome;
    private String cognome;
    private Date dataNascita;
    private String residenza;


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public String getResidenza() {
        return residenza;
    }

    public void setResidenza(String residenza) {
        this.residenza = residenza;
    }
}
