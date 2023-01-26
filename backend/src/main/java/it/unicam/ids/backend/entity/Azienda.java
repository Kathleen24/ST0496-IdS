package it.unicam.ids.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="Azienda")
public class Azienda {

    @Id
    @GeneratedValue
    private Integer id;
    private Date dataIscrizionePiattoforma;
    private String nomeAzienda;
    private String terminiLegali;
    private String infoAttivita;
    private String link;


    //region Costruttori
    public Azienda() {
    }

    public Azienda(String nomeAzienda, String terminiLegali, String infoAttivita, String link) {
        this.dataIscrizionePiattoforma = new Date();
        this.nomeAzienda = nomeAzienda;
        this.terminiLegali = terminiLegali;
        this.infoAttivita = infoAttivita;
        this.link = link;
    }

    public Azienda(Azienda azienda) {
        this.id = azienda.getId();
        this.dataIscrizionePiattoforma = azienda.getDataIscrizionePiattoforma();
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

    public Date getDataIscrizionePiattoforma() {
        return dataIscrizionePiattoforma;
    }

    public void setDataIscrizionePiattoforma(Date dataIscrizionePiattoforma) {
        this.dataIscrizionePiattoforma = dataIscrizionePiattoforma;
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
                nomeAzienda.equals(azienda.nomeAzienda) &&
                terminiLegali.equals(azienda.terminiLegali) &&
                Objects.equals(infoAttivita, azienda.infoAttivita) &&
                Objects.equals(link, azienda.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeAzienda, terminiLegali, infoAttivita, link);
    }
    //endregion
}
