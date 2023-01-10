package it.unicam.ids.backend.entity;

import it.unicam.ids.backend.id.ProgrammaFedeltaID;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "ProgrammaFedelta")
public class ProgrammaFedelta {

    @EmbeddedId
    private ProgrammaFedeltaID id;
    @OneToMany(mappedBy = "cliente")
    private Set<ProgrammaFedeltaDelCliente> clientiIscritti;


    //region Costruttori
    public ProgrammaFedelta() {
    }

    public ProgrammaFedelta(ProgrammaFedeltaID id, Set<ProgrammaFedeltaDelCliente> clientiIscritti) {
        this.id = id;
        this.clientiIscritti = clientiIscritti;
    }

    public ProgrammaFedelta(ProgrammaFedelta programmaFedelta) {
        this.id = programmaFedelta.getId();
        this.clientiIscritti = Set.copyOf(programmaFedelta.getClientiIscritti());
    }
    //endregion


    //region Getter e Setter
    public ProgrammaFedeltaID getId() {
        return id;
    }

    public void setId(ProgrammaFedeltaID id) {
        this.id = id;
    }

    public Set<ProgrammaFedeltaDelCliente> getClientiIscritti() {
        return clientiIscritti;
    }

    public void setClientiIscritti(Set<ProgrammaFedeltaDelCliente> clientiIscritti) {
        this.clientiIscritti = clientiIscritti;
    }
    //endregion
}
