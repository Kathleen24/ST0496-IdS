package it.unicam.ids.backend.entity;

import it.unicam.ids.backend.id.DipendenteID;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@IdClass(DipendenteID.class)
@Table(name="Dipendente")
public class Dipendente {

    @Id
    private String nomeUtente;
    @Id
    private Integer aziendaID;

    @ManyToOne
    @JoinColumn(name = "utentePiattaforma", referencedColumnName = "id")
    private UtentePiattaforma utentePiattaforma;
    @OneToOne
    @MapsId("aziendaID")
    @JoinColumn(name = "aziendaID", referencedColumnName = "id")
    private Azienda azienda;

    private String password;
    private Boolean gestorePunti;
    private Boolean gestoreDipendenti;
    private Boolean gestoreInformazioni;
    private Boolean gestoreProgrammiFedelta;
    private Boolean responsabile;


    //region Costruttori
    public Dipendente() {}

    public Dipendente(String nomeUtente, Integer aziendaID, String password, UtentePiattaforma utentePiattaforma, Azienda azienda, Boolean gestorePunti, Boolean gestoreDipendenti, Boolean gestoreInformazioni, Boolean gestoreProgrammiFedelta, Boolean responsabile) {
        this.nomeUtente = nomeUtente;
        this.aziendaID = aziendaID;
        this.password = password;
        this.utentePiattaforma = utentePiattaforma;
        this.azienda = azienda;
        this.gestorePunti = gestorePunti;
        this.gestoreDipendenti = gestoreDipendenti;
        this.gestoreInformazioni = gestoreInformazioni;
        this.gestoreProgrammiFedelta = gestoreProgrammiFedelta;
        this.responsabile = responsabile;
    }

    public Dipendente(Dipendente d) {
        this.nomeUtente = d.getNomeUtente();
        this.aziendaID = d.getAziendaID();
        this.password = d.getPassword();
        this.utentePiattaforma = d.getUtentePiattaforma();
        this.azienda = d.getAzienda();
        this.gestorePunti = d.getGestorePunti();
        this.gestoreDipendenti = d.getGestoreDipendenti();
        this.gestoreInformazioni = d.getGestoreInformazioni();
        this.gestoreProgrammiFedelta = d.getGestoreProgrammiFedelta();
        this.responsabile = d.getResponsabile();
    }
    //endregion


    //region Getter e Setter
    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public Integer getAziendaID() {
        return aziendaID;
    }

    public void setAziendaID(Integer aziendaID) {
        this.aziendaID = aziendaID;
    }

    public UtentePiattaforma getUtentePiattaforma() {
        return utentePiattaforma;
    }

    public void setUtentePiattaforma(UtentePiattaforma utentePiattaforma) {
        this.utentePiattaforma = utentePiattaforma;
    }

    public Azienda getAzienda() {
        return azienda;
    }

    public void setAzienda(Azienda azienda) {
        this.azienda = azienda;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getGestorePunti() {
        return gestorePunti;
    }

    public void setGestorePunti(Boolean gestorePunti) {
        this.gestorePunti = gestorePunti;
    }

    public Boolean getGestoreDipendenti() {
        return gestoreDipendenti;
    }

    public void setGestoreDipendenti(Boolean gestoreDipendenti) {
        this.gestoreDipendenti = gestoreDipendenti;
    }

    public Boolean getGestoreInformazioni() {
        return gestoreInformazioni;
    }

    public void setGestoreInformazioni(Boolean gestoreInformazioni) {
        this.gestoreInformazioni = gestoreInformazioni;
    }

    public Boolean getGestoreProgrammiFedelta() {
        return gestoreProgrammiFedelta;
    }

    public void setGestoreProgrammiFedelta(Boolean gestoreProgrammiFedelta) {
        this.gestoreProgrammiFedelta = gestoreProgrammiFedelta;
    }

    public Boolean getResponsabile() {
        return responsabile;
    }

    public void setResponsabile(Boolean responsabile) {
        this.responsabile = responsabile;
    }
    //endregion

    //region equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dipendente that)) return false;
        return Objects.equals(nomeUtente, that.nomeUtente) &&
                Objects.equals(aziendaID, that.aziendaID) &&
                Objects.equals(utentePiattaforma, that.utentePiattaforma) &&
                Objects.equals(azienda, that.azienda) &&
                Objects.equals(password, that.password) &&
                Objects.equals(gestorePunti, that.gestorePunti) &&
                Objects.equals(gestoreDipendenti, that.gestoreDipendenti) &&
                Objects.equals(gestoreInformazioni, that.gestoreInformazioni) &&
                Objects.equals(gestoreProgrammiFedelta, that.gestoreProgrammiFedelta) &&
                Objects.equals(responsabile, that.responsabile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                nomeUtente, aziendaID, utentePiattaforma, azienda, password, gestorePunti,
                gestoreDipendenti, gestoreInformazioni, gestoreProgrammiFedelta, responsabile
        );
    }
    //endregion
}
