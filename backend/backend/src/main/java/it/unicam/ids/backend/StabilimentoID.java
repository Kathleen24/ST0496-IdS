package it.unicam.ids.backend;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class StabilimentoID implements Serializable {
    private Integer aziendaID;
    private Integer id;

    public StabilimentoID(){
    };

    public StabilimentoID(Integer aziendaID, Integer id) {
        this.aziendaID = aziendaID;
        this.id = id;
    }

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
}
