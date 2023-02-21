package it.unicam.ids.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Azienda")
public class Azienda {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "abbonamento", referencedColumnName = "id")
    private Abbonamento abbonamento;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(nullable = false)
    private LocalDate dataIscrizionePiattaforma = LocalDate.now();
    private String nomeAzienda;
    private String terminiLegali;
    private String infoAttivita;
    private String link;


    //region Costruttori
    public Azienda() {}

    public Azienda(Abbonamento abbonamento, String nomeAzienda, String terminiLegali, String infoAttivita, String link) {
        this.abbonamento = abbonamento;
        this.dataIscrizionePiattaforma = LocalDate.now();
        this.nomeAzienda = nomeAzienda;
        this.terminiLegali = terminiLegali;
        this.infoAttivita = infoAttivita;
        this.link = link;
    }

    public Azienda(Azienda azienda) {
        this.id = azienda.getId();
        this.abbonamento = azienda.getAbbonamento();
        this.dataIscrizionePiattaforma = azienda.getDataIscrizionePiattaforma();
        this.nomeAzienda = azienda.getNomeAzienda();
        this.terminiLegali = azienda.getNomeAzienda();
        this.infoAttivita = azienda.getInfoAttivita();
        this.link = azienda.getLink();
    }
    //endregion


    //region Getter e Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Abbonamento getAbbonamento() {
        return abbonamento;
    }

    public void setAbbonamento(Abbonamento abbonamento) {
        this.abbonamento = abbonamento;
    }

    public LocalDate getDataIscrizionePiattaforma() {
        return dataIscrizionePiattaforma;
    }

    public void setDataIscrizionePiattaforma(LocalDate dataIscrizionePiattoforma) {
        this.dataIscrizionePiattaforma = dataIscrizionePiattoforma;
    }

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public void setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
    }

    public String getTerminiLegali() {
        return terminiLegali;
    }

    public void setTerminiLegali(String terminiLegali) {
        this.terminiLegali = terminiLegali;
    }

    public String getInfoAttivita() {
        return infoAttivita;
    }

    public void setInfoAttivita(String infoAttivita) {
        this.infoAttivita = infoAttivita;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    //endregion

    //region equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Azienda azienda)) return false;
        return id.equals(azienda.id) &&
                abbonamento.equals(azienda.abbonamento) &&
                dataIscrizionePiattaforma.equals(azienda.dataIscrizionePiattaforma) &&
                nomeAzienda.equals(azienda.nomeAzienda) &&
                terminiLegali.equals(azienda.terminiLegali) &&
                Objects.equals(infoAttivita, azienda.infoAttivita) &&
                Objects.equals(link, azienda.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, abbonamento, dataIscrizionePiattaforma, nomeAzienda, terminiLegali, infoAttivita, link);
    }
    //endregion
}
