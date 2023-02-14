package it.unicam.ids.backend.entity;

import it.unicam.ids.backend.id.StabilimentoID;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@IdClass(StabilimentoID.class)
@Table(name = "Stabilimento")
public class Stabilimento {

    @Id
    @GeneratedValue
    private Integer id;
    @Id
    private Integer aziendaID;

    private String informazioni;


    //region Costruttori
    public Stabilimento() {}

    public Stabilimento(Integer aziendaID, String informazioni) {
        this.aziendaID = aziendaID;
        this.informazioni = informazioni;
    }
    //endregion


    //region Getter e Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAziendaID() {
        return aziendaID;
    }

    public void setAziendaID(Integer aziendaID) {
        this.aziendaID = aziendaID;
    }

    public String getInformazioni() {
        return informazioni;
    }

    public void setInformazioni(String informazioni) {
        this.informazioni = informazioni;
    }
    //endregion

    //region equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stabilimento that)) return false;
        return Objects.equals(id, that.id) &&
                Objects.equals(aziendaID, that.aziendaID) &&
                Objects.equals(informazioni, that.informazioni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, aziendaID, informazioni);
    }
    //endregion
}
