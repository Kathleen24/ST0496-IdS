package it.unicam.ids.backend.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ProgrammaFedelta")
public class ProgrammaFedelta {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "aziendaID", referencedColumnName = "id", nullable = false)
    private Azienda azienda;
    @OneToMany
    @JoinColumns({
            @JoinColumn(name = "programmaFedeltaID", referencedColumnName = "id"),
            @JoinColumn(name = "aziendaID", referencedColumnName = "aziendaID")
    })
    private List<Bonus> bonus = new ArrayList<>();
    @ElementCollection
    private List<Integer> soglie = new ArrayList<>();
    @Column(nullable = false)
    private Boolean attivo;


    //region Costruttori
    public ProgrammaFedelta() {}

    public ProgrammaFedelta(Azienda azienda, List<Bonus> bonus, List<Integer> soglie, Boolean attivo) {
        this.azienda = azienda;
        this.bonus = bonus;
        this.soglie = soglie;
        this.attivo = attivo;
    }

    public ProgrammaFedelta(ProgrammaFedelta programmaFedelta) {
        this.id = programmaFedelta.getId();
        this.azienda = programmaFedelta.getAzienda();
        this.bonus.addAll(programmaFedelta.getBonus());
        this.soglie.addAll(programmaFedelta.getSoglie());
        this.attivo = programmaFedelta.getAttivo();
    }
    //endregion


    //region Getter e Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Azienda getAzienda() {
        return azienda;
    }

    public void setAzienda(Azienda azienda) {
        this.azienda = azienda;
    }

    public List<Bonus> getBonus() {
        return bonus;
    }

    public void setBonus(List<Bonus> livelli) {
        this.bonus = livelli;
    }

    public List<Integer> getSoglie() {
        return soglie;
    }

    public void setSoglie(List<Integer> soglie) {
        this.soglie = soglie;
    }

    public Boolean getAttivo() {
        return attivo;
    }

    public void setAttivo(Boolean attivo) {
        this.attivo = attivo;
    }
    //endregion

    //region equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProgrammaFedelta that)) return false;
        return id.equals(that.id) &&
                azienda.equals(that.azienda) &&
                bonus.equals(that.bonus) &&
                soglie.equals(that.soglie) &&
                attivo.equals(that.attivo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, azienda, bonus, soglie, attivo);
    }
    //endregion
}
