package it.unicam.ids.backend.id;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LivelloID implements Serializable {
    private ProgrammaFedeltaID programmaFedeltaID;
    private Integer bonusID;

    //region Costruttori
    public LivelloID() {
    }

    public LivelloID(ProgrammaFedeltaID programmaFedeltaID, Integer bonusID) {
        this.programmaFedeltaID = programmaFedeltaID;
        this.bonusID = bonusID;
    }
   //endregion


    //region Getter e Setter
    public ProgrammaFedeltaID getProgrammaFedeltaID() {
        return programmaFedeltaID;
    }

    public void setProgrammaFedeltaID(ProgrammaFedeltaID programmaFedeltaID) {
        this.programmaFedeltaID = programmaFedeltaID;
    }

    public Integer getBonusID() {
        return bonusID;
    }

    public void setBonusID(Integer bonusID) {
        this.bonusID = bonusID;
    }
    //endregion


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LivelloID livelloID = (LivelloID) o;
        return Objects.equals(programmaFedeltaID, livelloID.programmaFedeltaID) && Objects.equals(bonusID, livelloID.bonusID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(programmaFedeltaID, bonusID);
    }
}
