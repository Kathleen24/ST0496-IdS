package it.unicam.ids.backend.entity;

import it.unicam.ids.backend.id.ProgrammaFedeltaID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.GregorianCalendar;

@Entity
@Table(name="Coalizione")
public class Coalizione {
    @Id
    @GeneratedValue
    private Integer id;
    private ProgrammaFedeltaID programmaFedeltaID;
    private Azienda aziendaMittente;
    private Azienda aziendaDestinataria;
    private GregorianCalendar dataInizio;
    private GregorianCalendar dataFine;
    private Stato stato;
    public enum Stato{ACCETTATA_ATTIVA,ACCETTATA_INATTIVA,ACCETTATA_SCADUTA,INATTESA_INATTIVA,RIFIUTATA_INATTIVA}

    //region Costruttori

    //non è possibile creare un costruttore vuoto, se vi chiedete il motivo fatemelo sapere e ve lo spiego

    public Coalizione(Integer id, ProgrammaFedeltaID programmaFedeltaID, Azienda aziendaMittente, Azienda aziendaDestinataria, GregorianCalendar dataInizio, GregorianCalendar dataFine) {
        this.id = id;
        this.programmaFedeltaID = programmaFedeltaID;
        this.aziendaMittente = aziendaMittente;
        this.aziendaDestinataria = aziendaDestinataria;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.stato=Stato.INATTESA_INATTIVA;
    }

    public Coalizione(Integer id, ProgrammaFedeltaID programmaFedeltaID, Azienda aziendaMittente, Azienda aziendaDestinataria, GregorianCalendar dataInizio, GregorianCalendar dataFine, Stato stato) {
        this.id = id;
        this.programmaFedeltaID = programmaFedeltaID;
        this.aziendaMittente = aziendaMittente;
        this.aziendaDestinataria = aziendaDestinataria;
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

    public ProgrammaFedeltaID getProgrammaFedeltaID() {
        return programmaFedeltaID;
    }

    public void setProgrammaFedeltaID(ProgrammaFedeltaID programmaFedeltaID) {
        this.programmaFedeltaID = programmaFedeltaID;
    }

    public Azienda getAziendaMittente() {
        return aziendaMittente;
    }

    public void setAziendaMittente(Azienda aziendaMittente) {
        this.aziendaMittente = aziendaMittente;
    }

    public Azienda getAziendaDestinataria() {
        return aziendaDestinataria;
    }

    public void setAziendaDestinataria(Azienda aziendaDestinataria) {
        this.aziendaDestinataria = aziendaDestinataria;
    }

    public GregorianCalendar getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(GregorianCalendar dataInizio) {
        this.dataInizio = dataInizio;
    }

    public GregorianCalendar getDataFine() {
        return dataFine;
    }

    public void setDataFine(GregorianCalendar dataFine) {
        this.dataFine = dataFine;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    //endregion


}
