package it.unicam.ids.backend.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Abbonamento")
public class Abbonamento {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pianoTariffario", referencedColumnName = "id")
    private PianoTariffario pianoTariffario;
    private String descrizione;
    private LocalDate dataIscrizione;
    private LocalDate dataUltimoPagamento;
    private Boolean attivo;


    //region Costruttori
    public Abbonamento() {}

    public Abbonamento(PianoTariffario pianoTariffario, String descrizione, Boolean attivo) {
        this.pianoTariffario = pianoTariffario;
        this.descrizione = descrizione;
        this.dataIscrizione = LocalDate.now();
        this.dataUltimoPagamento = null;
        this.attivo = attivo;
    }

    public Abbonamento(Integer id, PianoTariffario pianoTariffario, String descrizione, Boolean attivo) {
        this.id = id;
        this.pianoTariffario = pianoTariffario;
        this.descrizione = descrizione;
        this.dataIscrizione = LocalDate.now();
        this.dataUltimoPagamento = null;
        this.attivo = attivo;
    }

    public Abbonamento(Abbonamento abbonamento) {
        this.id = abbonamento.getId();
        this.pianoTariffario = abbonamento.getPianoTariffario();
        this.descrizione = abbonamento.getDescrizione();
        this.dataIscrizione = abbonamento.getDataIscrizione();
        this.dataUltimoPagamento = abbonamento.getDataUltimoPagamento();
        this.attivo = abbonamento.getAttivo();
    }
    //endregion


    //region Getter e Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PianoTariffario getPianoTariffario() {
        return pianoTariffario;
    }

    public void setPianoTariffario(PianoTariffario pianoTariffario) {
        this.pianoTariffario = pianoTariffario;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public LocalDate getDataIscrizione() {
        return dataIscrizione;
    }

    public void setDataIscrizione(LocalDate dataIscrizione) {
        this.dataIscrizione = dataIscrizione;
    }

    public LocalDate getDataUltimoPagamento() {
        return dataUltimoPagamento;
    }

    public void setDataUltimoPagamento(LocalDate dataUltimoPagamento) {
        this.dataUltimoPagamento = dataUltimoPagamento;
    }

    public Boolean getAttivo() {
        return attivo;
    }

    public void setAttivo(Boolean attivo) {
        this.attivo = attivo;
    }
    //endregion

    //region equals, hashCode e toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Abbonamento that = (Abbonamento) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(pianoTariffario, that.pianoTariffario))
            return false;
        if (!Objects.equals(descrizione, that.descrizione)) return false;
        if (!Objects.equals(dataIscrizione, that.dataIscrizione))
            return false;
        if (!Objects.equals(dataUltimoPagamento, that.dataUltimoPagamento))
            return false;
        return Objects.equals(attivo, that.attivo);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (pianoTariffario != null ? pianoTariffario.hashCode() : 0);
        result = 31 * result + (descrizione != null ? descrizione.hashCode() : 0);
        result = 31 * result + (dataIscrizione != null ? dataIscrizione.hashCode() : 0);
        result = 31 * result + (dataUltimoPagamento != null ? dataUltimoPagamento.hashCode() : 0);
        result = 31 * result + (attivo != null ? attivo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Abbonamento:" +
                " id=" + id +
                ", pianoTariffario=" + pianoTariffario +
                ", descrizione='" + descrizione + '\'' +
                ", dataIscrizione=" + dataIscrizione +
                ", dataUltimoPagamento=" + dataUltimoPagamento +
                ", attivo=" + attivo +
                '.';
    }
    //endregion
}
