package it.unicam.ids.backend;

import jakarta.persistence.*;

@Entity
@Table(name="Stabilimento")
public class Stabilimento {
    @EmbeddedId
    private StabilimentoID id;
    private String informazioni;

    public Stabilimento(StabilimentoID id, String informazioni) {
        this.id = id;
        this.informazioni = informazioni;
    }

    public StabilimentoID getId() {
        return id;
    }

    public void setId(StabilimentoID id) {
        this.id = id;
    }

    public String getInformazioni() {
        return informazioni;
    }

    public void setInformazioni(String informazioni) {
        this.informazioni = informazioni;
    }
}
