package it.unicam.ids.backend.entity;

import it.unicam.ids.backend.id.ProgrammaFedeltaDelClienteID;
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
    @JoinColumn(name = "programmaFedeltaID")
    private ProgrammaFedelta programmaFedelta;
    private Integer puntiRaccolti;
    private boolean sonoXp;


    //region Getter e Setter
    public ProgrammaFedeltaDelClienteID getId() {
        return id;
    }

    public void setId(ProgrammaFedeltaDelClienteID id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

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
}
