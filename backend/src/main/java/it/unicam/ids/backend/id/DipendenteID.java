package it.unicam.ids.backend.id;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DipendenteID implements Serializable {

    private String nomeUtente;
    private Integer aziendaID;


    //region Costruttori
    public DipendenteID() {}

    public DipendenteID(String nomeUtente, Integer aziendaID) {
        this.nomeUtente = nomeUtente;
        this.aziendaID = aziendaID;
    }
    //endregion


    //region Getter e Setter
    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public Integer getAziendaID() {
        return aziendaID;
    }

    public void setAziendaID(Integer aziendaID) {
        this.aziendaID = aziendaID;
    }
    //endregion

    //region equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DipendenteID that)) return false;
        return nomeUtente.equals(that.nomeUtente) && aziendaID.equals(that.aziendaID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeUtente, aziendaID);
    }
    //endregion
}
