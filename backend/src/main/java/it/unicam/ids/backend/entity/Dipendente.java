package it.unicam.ids.backend.entity;

import it.unicam.ids.backend.id.DipendenteID;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@IdClass(DipendenteID.class)
@Table(name = "Dipendente")
public class Dipendente {

    @Id
    private String nomeUtente;
    @Id
    private Integer aziendaID;

    @ManyToOne
    @JoinColumn(name = "utentePiattaforma", referencedColumnName = "codFis", nullable = false)
    private UtentePiattaforma utentePiattaforma;
    @ManyToOne
    @MapsId("aziendaID")
    @JoinColumn(name = "aziendaID", referencedColumnName = "id", nullable = false)
    private Azienda azienda;

    @Column(nullable = false)
    private String password;
    private Boolean gestorePunti;
    private Boolean gestoreDipendenti;
    private Boolean gestoreInformazioni;
    private Boolean gestoreProgrammiFedelta;
    private Boolean responsabile;


    //region Costruttori
    public Dipendente() {}

    public Dipendente(String nomeUtente, UtentePiattaforma utentePiattaforma, Azienda azienda, String password) {
        this(nomeUtente, azienda.getId(), utentePiattaforma, azienda, password, false, false, false, false, false);
    }

    public Dipendente(String nomeUtente, Integer aziendaID, UtentePiattaforma utentePiattaforma, Azienda azienda, String password, Boolean gestorePunti, Boolean gestoreDipendenti, Boolean gestoreInformazioni, Boolean gestoreProgrammiFedelta, Boolean responsabile) {
        this.nomeUtente = nomeUtente;
        this.aziendaID = aziendaID;
        this.utentePiattaforma = utentePiattaforma;
        this.azienda = azienda;
        this.password = password;
        this.gestorePunti = gestorePunti;
        this.gestoreDipendenti = gestoreDipendenti;
        this.gestoreInformazioni = gestoreInformazioni;
        this.gestoreProgrammiFedelta = gestoreProgrammiFedelta;
        this.responsabile = responsabile;
    }

    public Dipendente(Dipendente dipendente) {
        this.nomeUtente = dipendente.getNomeUtente();
        this.aziendaID = dipendente.getAziendaID();
        this.password = dipendente.getPassword();
        this.utentePiattaforma = dipendente.getUtentePiattaforma();
        this.azienda = dipendente.getAzienda();
        this.gestorePunti = dipendente.getGestorePunti();
        this.gestoreDipendenti = dipendente.getGestoreDipendenti();
        this.gestoreInformazioni = dipendente.getGestoreInformazioni();
        this.gestoreProgrammiFedelta = dipendente.getGestoreProgrammiFedelta();
        this.responsabile = dipendente.getResponsabile();
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
