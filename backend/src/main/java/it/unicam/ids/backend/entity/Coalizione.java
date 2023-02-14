package it.unicam.ids.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Coalizione")
public class Coalizione {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "programmaFedeltaID", referencedColumnName = "id", nullable = false)
    private ProgrammaFedelta programmaFedelta;
    @ManyToOne
    @JoinColumn(name = "aziendaDestinataria", referencedColumnName = "id", nullable = false)
    private Azienda aziendaDestinataria;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(nullable = false)
    private LocalDate dataInizio;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(nullable = false)
    private LocalDate dataFine;
    @Column(nullable = false)
    private Stato stato;


    //region Costruttori
    public Coalizione() {}

    public Coalizione(ProgrammaFedelta programmaFedelta, Azienda aziendaDestinataria, LocalDate dataInizio, LocalDate dataFine) {
        this.programmaFedelta = programmaFedelta;
        this.aziendaDestinataria = aziendaDestinataria;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.stato = Stato.INATTESA_INATTIVA;
    }

    public Coalizione(Integer id, ProgrammaFedelta programmaFedelta, Azienda aziendaDestinataria, LocalDate dataInizio, LocalDate dataFine, Stato stato) {
        this.id = id;
        this.programmaFedelta = programmaFedelta;
        this.aziendaDestinataria = aziendaDestinataria;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.stato = stato;
    }
    //endregion


    /**
     * Determina se questa coalizione è nello stato {@link Stato#INATTESA_INATTIVA INATTESA_INATTIVA}
     *
     * @return true se ci si trova, false altrimenti
     */
    @JsonIgnore
    public boolean isInAttesaEAccettabile() {
        return stato.equals(Stato.INATTESA_INATTIVA);
    }

    /**
     * Determina se questa coalizione è nello stato {@link Stato#ACCETTATA_INATTIVA ACCETTATA_INATTIVA}
     *
     * @return true se ci si trova, false altrimenti
     */
    @JsonIgnore
    public boolean isAccettataEInattiva() {
        return stato.equals(Stato.ACCETTATA_INATTIVA);
    }

    /**
     * Determina se questa coalizione è nello stato {@link Stato#ACCETTATA_ATTIVA ACCETTATA_ATTIVA}
     *
     * @return true se ci si trova, false altrimenti
     */
    @JsonIgnore
    public boolean isAttiva() {
        return stato.equals(Stato.ACCETTATA_ATTIVA);
    }

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

    /**
     * Restituisce l'azienda che ha creato la coalizione
     *
     * @return l'azienda che ha creato la coalizione
     */
    @JsonInclude
    public Azienda getAziendaMittente() {
        return programmaFedelta.getAzienda();
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
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
                dataInizio.equals(that.dataInizio) &&
                dataFine.equals(that.dataFine) &&
                stato == that.stato;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, programmaFedelta, aziendaDestinataria, dataInizio, dataFine, stato);
    }
    //endregion


    public enum Stato {
        ACCETTATA_ATTIVA, ACCETTATA_INATTIVA, ACCETTATA_SCADUTA, INATTESA_INATTIVA, RIFIUTATA_INATTIVA
    }
}
