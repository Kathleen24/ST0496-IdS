package it.unicam.ids.backend;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

@Entity
@Table(name="Dipendente")
public class Dipendete {

    @Id
    private String nomeUtente;
    @OneToMany
    @JoinColumn(name = "persona", referencedColumnName = "id")
    private Persona persona;

    @OneToOne
    @JoinColumn(name = "azienda", referencedColumnName = "id")
    private Azienda azienda;

    private Boolean gestorePunti;
    private Boolean gestoreDipendeti;
    private Boolean gestoreInformazioni;
    private Boolean gestoreProgrammiFedeltà;
    private Boolean responsabile;

    public Dipendete() {
    }

    public Dipendete(String nomeUtente, Persona persona, Azienda azienda, Boolean gestorePunti, Boolean gestoreDipendeti, Boolean gestoreInformazioni, Boolean gestoreProgrammiFedeltà, Boolean responsabile) {
        this.nomeUtente = nomeUtente;
        this.persona = persona;
        this.azienda = azienda;
        this.gestorePunti = gestorePunti;
        this.gestoreDipendeti = gestoreDipendeti;
        this.gestoreInformazioni = gestoreInformazioni;
        this.gestoreProgrammiFedeltà = gestoreProgrammiFedeltà;
        this.responsabile = responsabile;
    }

    public Dipendete(@NotNull Dipendete d){
        this.nomeUtente = d.getNomeUtente();
        this.persona = d.getPersona();
        this.azienda = d.getAzienda();
        this.gestorePunti = d.getGestorePunti();
        this.gestoreDipendeti = d.getGestoreDipendeti();
        this.gestoreInformazioni = d.getGestoreInformazioni();
        this.gestoreProgrammiFedeltà = d.getGestoreProgrammiFedeltà();
        this.responsabile = d.getResponsabile();
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public Persona getPersona() {
        return persona;
    }

    public Azienda getAzienda() {
        return azienda;
    }

    public Boolean getGestorePunti() {
        return gestorePunti;
    }

    public Boolean getGestoreDipendeti() {
        return gestoreDipendeti;
    }

    public Boolean getGestoreInformazioni() {
        return gestoreInformazioni;
    }

    public Boolean getGestoreProgrammiFedeltà() {
        return gestoreProgrammiFedeltà;
    }

    public Boolean getResponsabile() {
        return responsabile;
    }
}
