package it.unicam.ids.backend.id;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RecensioneID implements Serializable {

    private Integer aziendaID;
    private Integer tessera;


    //region Costruttori
    public RecensioneID(Integer aziendaID, Integer tessera) {
        this.aziendaID = aziendaID;
        this.tessera = tessera;
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
    //endregion

    //region equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecensioneID recensioneID = (RecensioneID) o;
        return Objects.equals(aziendaID, recensioneID.aziendaID) && Objects.equals(tessera, recensioneID.tessera);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aziendaID, tessera);
    }
    //endregion
}
