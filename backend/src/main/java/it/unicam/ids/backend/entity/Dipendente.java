package it.unicam.ids.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Dipendente")
public class Dipendente {

    @Id
    private String nomeUtente;

    private String password;
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

    public Dipendente(String nomeUtente, String password, Persona persona, Azienda azienda, Boolean gestorePunti, Boolean gestoreDipendenti, Boolean gestoreInformazioni, Boolean gestoreProgrammiFedelta, Boolean responsabile) {
        this.nomeUtente = nomeUtente;
        this.password = password;
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
        this.password = d.getPassword();
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

    public String getPassword() {
        return password;
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
