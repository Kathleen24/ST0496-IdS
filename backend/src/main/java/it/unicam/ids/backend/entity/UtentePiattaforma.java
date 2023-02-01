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
    private String luogoNascita;
    private String indirizzo;
    private String città;
    private String provincia;
    private String cap;
    private String cellulare;

    //region Costruttori
    public UtentePiattaforma() {}

    public UtentePiattaforma(String codFis, String nome, String cognome, Date dataNascita, String luogoNascita, String indirizzo, String città, String provincia, String cap, String cellulare) {
        this.codFis = codFis;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.luogoNascita = luogoNascita;
        this.indirizzo = indirizzo;
        this.città = città;
        this.provincia = provincia;
        this.cap = cap;
        this.cellulare = cellulare;
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

    public String getLuogoNascita() {
        return luogoNascita;
    }

    public void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getCellulare() {
        return cellulare;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }

    //endregion

    //region equals e hashCode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtentePiattaforma that = (UtentePiattaforma) o;
        return Objects.equals(codFis, that.codFis) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(cognome, that.cognome) &&
                Objects.equals(dataNascita, that.dataNascita) &&
                Objects.equals(luogoNascita, that.luogoNascita) &&
                Objects.equals(indirizzo, that.indirizzo) &&
                Objects.equals(città, that.città) &&
                Objects.equals(provincia, that.provincia) &&
                Objects.equals(cap, that.cap) &&
                Objects.equals(cellulare, that.cellulare);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codFis, nome, cognome, dataNascita, luogoNascita, indirizzo, città, provincia, cap, cellulare);
    }

    //endregion
}
