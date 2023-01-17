package it.unicam.ids.backend.entity;

import it.unicam.ids.backend.id.LivelloID;
import jakarta.persistence.*;

@Entity
@Table(name="Livello")
public class Livello {

    @EmbeddedId
    private LivelloID id;
    @ManyToOne
    @MapsId("programmaFedeltaID")
    @JoinColumns({
            @JoinColumn(name = "programmaFedeltaID", referencedColumnName = "id"),
            @JoinColumn(name = "aziendaID", referencedColumnName = "aziendaID")
    })
    private ProgrammaFedelta programmaFedelta;
    @ManyToOne
    @MapsId("bonusID")
    @JoinColumn(name = "bonusID")
    private Bonus bonus;

    private int soglia;
    private String descrizione;


    //region Costruttori
    public Livello() {
    }

    public Livello(LivelloID id, ProgrammaFedelta programmaFedelta, Bonus bonus, int soglia, String descrizione) {
        this.id = id;
        this.programmaFedelta = programmaFedelta;
        this.bonus = bonus;
        this.soglia = soglia;
        this.descrizione = descrizione;
    }
    //endregion


    //region Getter e Setter
    public LivelloID getId() {
        return id;
    }

    public void setId(LivelloID id) {
        this.id = id;
    }

    public ProgrammaFedelta getProgrammaFedelta() {
        return programmaFedelta;
    }

    public void setProgrammaFedelta(ProgrammaFedelta programmaFedelta) {
        this.programmaFedelta = programmaFedelta;
    }

    public Bonus getBonus() {
        return bonus;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }

    public int getSoglia() {
        return soglia;
    }

    public void setSoglia(int soglia) {
        this.soglia = soglia;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    //endregion
}
