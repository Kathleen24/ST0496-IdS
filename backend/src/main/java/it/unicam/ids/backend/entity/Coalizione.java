package it.unicam.ids.backend.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name="Coalizione")
public class Coalizione {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "programmaFedeltaID", referencedColumnName = "id")
    private ProgrammaFedelta programmaFedelta;
    @ManyToOne
    @JoinColumn(name = "aziendaDestinataria", referencedColumnName = "id")
    private Azienda aziendaDestinataria;

    @Transient
    private Azienda aziendaMittente;
    private Date dataInizio;
    private Date dataFine;
    private Stato stato;


    //region Costruttori
    public Coalizione() {}

    public Coalizione(Integer id, ProgrammaFedelta programmaFedelta, Azienda aziendaDestinataria, Date dataInizio, Date dataFine) {
        this.id = id;
        this.programmaFedelta = programmaFedelta;
        this.aziendaDestinataria = aziendaDestinataria;
        this.aziendaMittente = programmaFedelta.getAzienda();
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.stato = Stato.INATTESA_INATTIVA;
    }

    public Coalizione(Integer id, ProgrammaFedelta programmaFedelta, Azienda aziendaDestinataria, Date dataInizio, Date dataFine, Stato stato) {
        this.id = id;
        this.programmaFedelta = programmaFedelta;
        this.aziendaDestinataria = aziendaDestinataria;
        this.aziendaMittente = programmaFedelta.getAzienda();
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.stato = stato;
    }
    //endregion


    //region Getter e Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProgrammaFedelta getProgrammaFedelta() {
        return programmaFedelta;
    }

    public void setProgrammaFedelta(ProgrammaFedelta programmaFedelta) {
        this.programmaFedelta = programmaFedelta;
    }

    public Azienda getAziendaDestinataria() {
        return aziendaDestinataria;
    }

    public void setAziendaDestinataria(Azienda aziendaDestinataria) {
        this.aziendaDestinataria = aziendaDestinataria;
    }

    public Azienda getAziendaMittente() {
        return aziendaMittente;
    }

    public void setAziendaMittente(Azienda aziendaMittente) {
        this.aziendaMittente = aziendaMittente;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }
    //endregion
    
    //region equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coalizione that)) return false;
        return id.equals(that.id) &&
                programmaFedelta.equals(that.programmaFedelta) &&
                aziendaDestinataria.equals(that.aziendaDestinataria) &&
                aziendaMittente.equals(that.aziendaMittente) &&
                dataInizio.equals(that.dataInizio) &&
                dataFine.equals(that.dataFine) &&
                stato == that.stato;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, programmaFedelta, aziendaDestinataria, aziendaMittente, dataInizio, dataFine, stato);
    }
    //endregion

    public enum Stato {
        ACCETTATA_ATTIVA, ACCETTATA_INATTIVA, ACCETTATA_SCADUTA, INATTESA_INATTIVA, RIFIUTATA_INATTIVA
    }
}
