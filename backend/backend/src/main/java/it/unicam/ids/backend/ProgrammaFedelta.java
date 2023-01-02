package it.unicam.ids.backend;

import jakarta.persistence.*;
@Entity
@Table(name = "ProgrammaFedelta")
public class ProgrammaFedelta {

    @EmbeddedId
    private ProgrammaFedeltaID id;

    public ProgrammaFedelta() {
    }

    public ProgrammaFedelta(ProgrammaFedeltaID id) {
        this.id = id;
    }

    public ProgrammaFedelta(ProgrammaFedelta programmaFedelta) {
        this.id = programmaFedelta.getId();
    }

    public ProgrammaFedeltaID getId() {
        return id;
    }

    public void setId(ProgrammaFedeltaID id) {
        this.id = id;
    }
}
