package it.unicam.ids.backend.entity;

import it.unicam.ids.backend.id.RecensioneID;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@IdClass(RecensioneID.class)
@Table(name = "Recensione")
public class Recensione {

    @Id
    private Integer aziendaID;
    @Id
    private Integer tessera;

    @Column(nullable = false)
    private Integer voto;
    private String descrizione;


    //region Costruttori
    public Recensione() {}

    public Recensione(Integer aziendaID, Integer tessera, Integer voto, String descrizione) {
        this.aziendaID = aziendaID;
        this.tessera = tessera;
        this.voto = voto;
        this.descrizione = descrizione;
    }
    //endregion


    //region Getter e Setter
    public Integer getAziendaID() {
        return aziendaID;
    }

    public void setAziendaID(Integer aziendaID) {
        this.aziendaID = aziendaID;
    }

    public Integer getTessera() {
        return tessera;
    }

    public void setTessera(Integer tessera) {
        this.tessera = tessera;
    }

    public Integer getVoto() {
        return voto;
    }

    public void setVoto(Integer voto) {
        this.voto = voto;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    //endregion

    //region Equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recensione that = (Recensione) o;
        return Objects.equals(aziendaID, that.aziendaID) &&
                Objects.equals(tessera, that.tessera) &&
                Objects.equals(voto, that.voto) &&
                Objects.equals(descrizione, that.descrizione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aziendaID, tessera, voto, descrizione);
    }
    //endregion
}


