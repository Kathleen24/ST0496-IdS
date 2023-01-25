package it.unicam.ids.backend.entity;

import it.unicam.ids.backend.id.DipendenteID;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="Dipendente")
public class Dipendente {

    @EmbeddedId
    private DipendenteID id;

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
    public Dipendente() {
    }

    public Dipendente(DipendenteID id, String password, UtentePiattaforma utentePiattaforma, Azienda azienda, Boolean gestorePunti, Boolean gestoreDipendenti, Boolean gestoreInformazioni, Boolean gestoreProgrammiFedelta, Boolean responsabile) {
        this.id = id;
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
        this.id = d.getId();
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
    public DipendenteID getId() {
        return id;
    }

    public void setId(DipendenteID id) {
        this.id = id;
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
        return id.equals(that.id) &&
                utentePiattaforma.equals(that.utentePiattaforma) &&
                azienda.equals(that.azienda) &&
                password.equals(that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, utentePiattaforma, azienda, password);
    }
    //endregion
}
