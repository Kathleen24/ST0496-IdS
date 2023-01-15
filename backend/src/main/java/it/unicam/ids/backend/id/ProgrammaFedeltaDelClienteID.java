package it.unicam.ids.backend.id;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProgrammaFedeltaDelClienteID implements Serializable {

    private ProgrammaFedeltaID programmaFedeltaID;
    private Integer tessera;


    //region Costruttori
    public ProgrammaFedeltaDelClienteID() {
    }

    public ProgrammaFedeltaDelClienteID(ProgrammaFedeltaID programmaFedeltaID, Integer tessera) {
        this.programmaFedeltaID = programmaFedeltaID;
        this.tessera = tessera;
    }
    //endregion

    //region Getter e Setter
    public ProgrammaFedeltaID getProgrammaFedeltaID() {
        return programmaFedeltaID;
    }

    public void setProgrammaFedeltaID(ProgrammaFedeltaID programmaFedeltaID) {
        this.programmaFedeltaID = programmaFedeltaID;
    }

    public Integer getTessera() {
        return tessera;
    }

    public void setTessera(Integer tessera) {
        this.tessera = tessera;
    }
    //endregion


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgrammaFedeltaDelClienteID that = (ProgrammaFedeltaDelClienteID) o;
        return Objects.equals(programmaFedeltaID, that.programmaFedeltaID) && Objects.equals(tessera, that.tessera);
    }

    @Override
    public int hashCode() {
        return Objects.hash(programmaFedeltaID, tessera);
    }
}
