package it.unicam.ids.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "UtentePiattaforma")
public class UtentePiattaforma {

    @Id
    private String codFis;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cognome;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(nullable = false)
    private Date dataNascita;
    @Column(nullable = false)
    private String residenza;


    //region Costruttori
    public UtentePiattaforma() {}

    public UtentePiattaforma(String codFis, String nome, String cognome, Date dataNascita, String residenza) {
        this.codFis = codFis;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.residenza = residenza;
    }
    //endregion


    //region Getter e Setter
    public String getCodFis() {
        return codFis;
    }

    public void setCodFis(String codFis) {
        this.codFis = codFis;
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
        return Objects.equals(codFis, that.codFis) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(cognome, that.cognome) &&
                Objects.equals(dataNascita, that.dataNascita) &&
                Objects.equals(residenza, that.residenza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codFis, nome, cognome, dataNascita, residenza);
    }
    //endregion
}
