package it.unicam.ids.backend.entity;

import it.unicam.ids.backend.id.ProgrammaFedeltaID;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ProgrammaFedelta")
public class ProgrammaFedelta {

    @EmbeddedId
    private ProgrammaFedeltaID id;
    @OneToMany(mappedBy = "programmaFedelta")
    private Set<ProgrammaFedeltaDelCliente> clientiIscritti;
    @OneToMany(mappedBy = "programmaFedelta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Livello> livelli;


    //region Costruttori
    public ProgrammaFedelta() {
    }

    public ProgrammaFedelta(ProgrammaFedeltaID id, List<Livello> livelli) {
        this.id = id;
        this.clientiIscritti = Set.of();
        this.livelli = livelli;
    }

    public ProgrammaFedelta(ProgrammaFedeltaID id, Set<ProgrammaFedeltaDelCliente> clientiIscritti, List<Livello> livelli) {
        this.id = id;
        this.clientiIscritti = clientiIscritti;
        this.livelli = livelli;
    }

    public ProgrammaFedelta(ProgrammaFedelta programmaFedelta) {
        this.id = programmaFedelta.getId();
        this.clientiIscritti = Set.copyOf(programmaFedelta.getClientiIscritti());
        this.livelli = List.copyOf(programmaFedelta.getLivelli());
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

    public List<Livello> getLivelli() {
        return livelli;
    }

    public void setLivelli(List<Livello> livelli) {
        this.livelli = livelli;
    }

    @Transient
    public List<Integer> getSoglie() {
        return livelli.stream().map(Livello::getSoglia).toList();
    }
    //endregion
}
