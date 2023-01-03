package it.unicam.ids.backend;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProgrammaFedeltaID implements Serializable{

    private Integer aziendaID;
    private Integer id;


    //region Costruttori
    public ProgrammaFedeltaID() {
    }

    public ProgrammaFedeltaID(Integer aziendaID, Integer id) {
        this.aziendaID = aziendaID;
        this.id = id;
    }

    public ProgrammaFedeltaID(ProgrammaFedeltaID programmaFedeltaID) {
        this.aziendaID = programmaFedeltaID.getAziendaID();
        this.id = programmaFedeltaID.getId();
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
}
