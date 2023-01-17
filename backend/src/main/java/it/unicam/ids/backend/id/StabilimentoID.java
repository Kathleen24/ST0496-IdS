package it.unicam.ids.backend.id;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StabilimentoID implements Serializable {

    private Integer aziendaID;
    private Integer id;


    //region Costruttori
    public StabilimentoID() {
    }

    public StabilimentoID(Integer aziendaID, Integer id) {
        this.aziendaID = aziendaID;
        this.id = id;
    }
    //endregion


    //region Getter e Setter
    public Integer getAziendaID() {
        return aziendaID;
    }

    public void setAziendaID(Integer aziendaID) {
        this.aziendaID = aziendaID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    //endregion


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StabilimentoID that)) return false;
        return aziendaID.equals(that.aziendaID) && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aziendaID, id);
    }
}
