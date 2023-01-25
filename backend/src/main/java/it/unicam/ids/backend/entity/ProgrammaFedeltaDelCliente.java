package it.unicam.ids.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.unicam.ids.backend.id.ProgrammaFedeltaDelClienteID;
import jakarta.persistence.*;

import java.sql.Date;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name="ProgrammaFedeltaDelCliente")
public class ProgrammaFedeltaDelCliente {

    @EmbeddedId
    private ProgrammaFedeltaDelClienteID id;

    @ManyToOne
    @MapsId("programmaFedeltaID")
    @JoinColumns({
            @JoinColumn(name = "programmaFedeltaID", referencedColumnName = "id"),
            @JoinColumn(name = "aziendaID", referencedColumnName = "aziendaID")
    })
    private ProgrammaFedelta programmaFedelta;

    private Integer puntiRaccolti;
    private boolean sonoXp;
    private Date dataIscrizione;


    //region Costruttori
    public ProgrammaFedeltaDelCliente() {}

    public ProgrammaFedeltaDelCliente(ProgrammaFedeltaDelClienteID id, ProgrammaFedelta programmaFedelta) {
        this.id = id;
        this.programmaFedelta = programmaFedelta;
        this.puntiRaccolti = 0;
        this.sonoXp = false;
        this.dataIscrizione = new Date(Instant.now().toEpochMilli());
    }

    public ProgrammaFedeltaDelCliente(ProgrammaFedeltaDelClienteID id, ProgrammaFedelta programmaFedelta, Integer puntiRaccolti, boolean sonoXp, Date dataIscrizione) {
        this.id = id;
        this.programmaFedelta = programmaFedelta;
        this.puntiRaccolti = puntiRaccolti;
        this.sonoXp = sonoXp;
        this.dataIscrizione = dataIscrizione;
    }
    //endregion


    public void addPunti(int punti) {
        puntiRaccolti += punti;
    }

    //region Getter e Setter
    public ProgrammaFedeltaDelClienteID getId() {
        return id;
    }

    public void setId(ProgrammaFedeltaDelClienteID id) {
        this.id = id;
    }

    @JsonIgnore
    public ProgrammaFedelta getProgrammaFedelta() {
        return programmaFedelta;
    }

    public void setProgrammaFedelta(ProgrammaFedelta programmaFedelta) {
        this.programmaFedelta = programmaFedelta;
    }

    public Integer getPuntiRaccolti() {
        return puntiRaccolti;
    }

    public void setPuntiRaccolti(Integer puntiRaccolti) {
        this.puntiRaccolti = puntiRaccolti;
    }

    public boolean isSonoXp() {
        return sonoXp;
    }

    public void setSonoXp(boolean sonoXp) {
        this.sonoXp = sonoXp;
    }

    public Date getDataIscrizione() {
        return dataIscrizione;
    }

    public void setDataIscrizione(Date dataIscrizione) {
        this.dataIscrizione = dataIscrizione;
    }
    //endregion

    //region equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProgrammaFedeltaDelCliente that)) return false;
        return sonoXp == that.sonoXp &&
                id.equals(that.id) &&
                programmaFedelta.equals(that.programmaFedelta) &&
                puntiRaccolti.equals(that.puntiRaccolti) &&
                dataIscrizione.equals(that.dataIscrizione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, programmaFedelta, puntiRaccolti, sonoXp, dataIscrizione);
    }
    //endregion
}
