package it.unicam.ids.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.unicam.ids.backend.id.ProgrammaFedeltaDelClienteID;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@IdClass(ProgrammaFedeltaDelClienteID.class)
@Table(name="ProgrammaFedeltaDelCliente")
public class ProgrammaFedeltaDelCliente {

    @Id
    private Integer programmaFedeltaID;
    @Id
    private Integer tessera;

    @ManyToOne
    @MapsId("programmaFedeltaID")
    @JoinColumns({
            @JoinColumn(name = "programmaFedeltaID", referencedColumnName = "id"),
            @JoinColumn(name = "aziendaID", referencedColumnName = "aziendaID")
    })
    private ProgrammaFedelta programmaFedelta;

    private Integer puntiRaccolti;
    private boolean sonoXp;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataIscrizione;


    //region Costruttori
    public ProgrammaFedeltaDelCliente() {}

    public ProgrammaFedeltaDelCliente(Integer programmaFedeltaID, Integer tessera, ProgrammaFedelta programmaFedelta) {
        this.programmaFedeltaID = programmaFedeltaID;
        this.tessera = tessera;
        this.programmaFedelta = programmaFedelta;
        this.puntiRaccolti = 0;
        this.sonoXp = false;
        this.dataIscrizione = LocalDate.now();
    }

    public ProgrammaFedeltaDelCliente(Integer programmaFedeltaID, Integer tessera, ProgrammaFedelta programmaFedelta, Integer puntiRaccolti, boolean sonoXp, LocalDate dataIscrizione) {
        this.programmaFedeltaID = programmaFedeltaID;
        this.tessera = tessera;
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
    public Integer getProgrammaFedeltaID() {
        return programmaFedeltaID;
    }

    public void setProgrammaFedeltaID(Integer programmaFedeltaID) {
        this.programmaFedeltaID = programmaFedeltaID;
    }

    public Integer getTessera() {
        return tessera;
    }

    public void setTessera(Integer tessera) {
        this.tessera = tessera;
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

    public LocalDate getDataIscrizione() {
        return dataIscrizione;
    }

    public void setDataIscrizione(LocalDate dataIscrizione) {
        this.dataIscrizione = dataIscrizione;
    }
    //endregion

    //region equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProgrammaFedeltaDelCliente that)) return false;
        return programmaFedeltaID.equals(that.programmaFedeltaID) &&
                tessera.equals(that.tessera) &&
                programmaFedelta.equals(that.programmaFedelta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(programmaFedeltaID, tessera, programmaFedelta);
    }
    //endregion
}
