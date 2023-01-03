package it.unicam.ids.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Azienda")
public class Azienda {

    @Id
    @GeneratedValue
    private Integer id;
    private String nomeAzienda;


    //region Costruttori
    public Azienda() {
    }

    public Azienda(Integer id, String nomeAzienda) {
        this.id = id;
        this.nomeAzienda = nomeAzienda;
    }

    public Azienda(Azienda azienda) {
        this.id = azienda.getId();
        this.nomeAzienda = azienda.getNomeAzienda();
    }
    //endregion


    //region Getter e Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public void setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
    }
    //endregion
}
