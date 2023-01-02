package it.unicam.ids.backend;

import jakarta.persistence.*;

@Entity
@Table(name="Azienda")
public class Azienda {
    @Id
    @GeneratedValue
    private Integer id;
    private String nomeAzienda;

    //Costruttori
    public Azienda() {
    }
    public Azienda(Integer id, String nomeAzienda) {
        this.id=id;
        this.nomeAzienda=nomeAzienda;
    }
    public Azienda(Azienda azienda) {
        this.id = azienda.getId();
        this.nomeAzienda = azienda.getNomeAzienda();
    }

    //Getter e Setter
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
}
