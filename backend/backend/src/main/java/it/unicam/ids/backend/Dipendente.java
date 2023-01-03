package it.unicam.ids.backend;

import jakarta.persistence.*;

@Entity
@Table(name="Dipendente")
public class Dipendente {

    @Id
    private String nomeUtente;
    @ManyToOne
    @JoinColumn(name = "persona", referencedColumnName = "id")
    private Persona persona;

    @OneToOne
    @JoinColumn(name = "azienda", referencedColumnName = "id")
    private Azienda azienda;

    private Boolean gestorePunti;
    private Boolean gestoreDipendenti;
    private Boolean gestoreInformazioni;
    private Boolean gestoreProgrammiFedelta;
    private Boolean responsabile;


    //region Costruttori
    public Dipendente() {
    }

    public Dipendente(String nomeUtente, Persona persona, Azienda azienda, Boolean gestorePunti, Boolean gestoreDipendenti, Boolean gestoreInformazioni, Boolean gestoreProgrammiFedelta, Boolean responsabile) {
        this.nomeUtente = nomeUtente;
        this.persona = persona;
        this.azienda = azienda;
        this.gestorePunti = gestorePunti;
        this.gestoreDipendenti = gestoreDipendenti;
        this.gestoreInformazioni = gestoreInformazioni;
        this.gestoreProgrammiFedelta = gestoreProgrammiFedelta;
        this.responsabile = responsabile;
    }

    public Dipendente(Dipendente d) {
        this.nomeUtente = d.getNomeUtente();
        this.persona = d.getPersona();
        this.azienda = d.getAzienda();
        this.gestorePunti = d.getGestorePunti();
        this.gestoreDipendenti = d.getGestoreDipendenti();
        this.gestoreInformazioni = d.getGestoreInformazioni();
        this.gestoreProgrammiFedelta = d.getGestoreProgrammiFedelta();
        this.responsabile = d.getResponsabile();
    }
    //endregion

    //region Getter
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

    public Boolean getGestoreDipendenti() {
        return gestoreDipendenti;
    }

    public Boolean getGestoreInformazioni() {
        return gestoreInformazioni;
    }

    public Boolean getGestoreProgrammiFedelta() {
        return gestoreProgrammiFedelta;
    }

    public Boolean getResponsabile() {
        return responsabile;
    }
    //endregion
}
