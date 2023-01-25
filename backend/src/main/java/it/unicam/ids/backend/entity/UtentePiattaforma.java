package it.unicam.ids.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "UtentePiattaforma")
public class UtentePiattaforma {

    @Id
    @GeneratedValue
    private int id;

    private String nome;
    private String cognome;
    private Date dataNascita;
    private String residenza;


    //region Costruttori
    public UtentePiattaforma() {}

    public UtentePiattaforma(int id, String nome, String cognome, Date dataNascita, String residenza) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.residenza = residenza;
    }
    //endregion


    //region Getter e Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getResidenza() {
        return residenza;
    }

    public void setResidenza(String residenza) {
        this.residenza = residenza;
    }
    //endregion

    //region equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UtentePiattaforma that)) return false;
        return id == that.id &&
                nome.equals(that.nome) &&
                cognome.equals(that.cognome) &&
                dataNascita.equals(that.dataNascita) &&
                residenza.equals(that.residenza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cognome, dataNascita, residenza);
    }
    //endregion
}
