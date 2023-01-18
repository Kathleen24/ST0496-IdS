package it.unicam.ids.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.unicam.ids.backend.id.ProgrammaFedeltaDelClienteID;
import it.unicam.ids.backend.id.ProgrammaFedeltaID;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="ProgrammaFedeltaDelCliente")
public class ProgrammaFedeltaDelCliente {

    @EmbeddedId
    private ProgrammaFedeltaDelClienteID id;

    @ManyToOne
    @MapsId("tessera")
    @JoinColumn(name = "tessera")
    private Cliente cliente;
    @ManyToOne
    @MapsId("programmaFedeltaID")
    @JoinColumns({
            @JoinColumn(name = "programmaFedeltaID", referencedColumnName = "id"),
            @JoinColumn(name = "aziendaID", referencedColumnName = "aziendaID")
    })
    private ProgrammaFedelta programmaFedelta;

    private Integer puntiRaccolti;
    private boolean sonoXp;


    //region Costruttori
    public ProgrammaFedeltaDelCliente() {
    }

    public ProgrammaFedeltaDelCliente(ProgrammaFedeltaDelClienteID id, Cliente cliente, ProgrammaFedelta programmaFedelta) {
        this.id = id;
        this.cliente = cliente;
        this.programmaFedelta = programmaFedelta;
        this.puntiRaccolti = 0;
        this.sonoXp = false;
    }

    public ProgrammaFedeltaDelCliente(ProgrammaFedeltaDelClienteID id, Cliente cliente, ProgrammaFedelta programmaFedelta, Integer puntiRaccolti, boolean sonoXp) {
        this.id = id;
        this.cliente = cliente;
        this.programmaFedelta = programmaFedelta;
        this.puntiRaccolti = puntiRaccolti;
        this.sonoXp = sonoXp;
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
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProgrammaFedeltaDelCliente that)) return false;
        return sonoXp == that.sonoXp
                && id.equals(that.id)
                && cliente.equals(that.cliente)
                && programmaFedelta.equals(that.programmaFedelta)
                && puntiRaccolti.equals(that.puntiRaccolti);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cliente, programmaFedelta, puntiRaccolti, sonoXp);
    }

    @Override
    public String toString() {
        return "ProgrammaFedeltaDelCliente{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", programmaFedelta=" + programmaFedelta +
                ", puntiRaccolti=" + puntiRaccolti +
                ", sonoXp=" + sonoXp +
                '}';
    }
}
