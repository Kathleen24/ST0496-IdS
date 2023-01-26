package it.unicam.ids.backend.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="Bonus")
public class Bonus {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "aziendaID", referencedColumnName = "id")
    private Azienda azienda;
    private Integer valore;
    private String descrizione;
    private Tipo tipo;


    //region Costruttori
    public Bonus() {}

    public Bonus(Azienda azienda, Integer valore, String descrizione, Tipo tipo) {
        this.azienda = azienda;
        this.valore = valore;
        this.descrizione = descrizione;
        this.tipo = tipo;
    }
    //endregion


    //region Getter e Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Azienda getAzienda() {
        return azienda;
    }

    public void setAzienda(Azienda azienda) {
        this.azienda = azienda;
    }

    public Integer getValore() {
        return valore;
    }

    public void setValore(Integer valore) {
        this.valore = valore;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo type) {
        this.tipo = type;
    }
    //endregion

    //region Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bonus bonus)) return false;
        return id.equals(bonus.id) &&
                azienda.equals(bonus.azienda) &&
                valore.equals(bonus.valore) &&
                Objects.equals(descrizione, bonus.descrizione) &&
                tipo == bonus.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, azienda, valore, descrizione, tipo);
    }
    //endregion


    public enum Tipo {
        PUNTI {
            @Override
            public String toString() {
                return "Punti";
            }
        },
        CASHBACK {
            @Override
            public String toString() {
                return "Cashback";
            }
        },
        SCONTO {
            @Override
            public String toString() {
                return "Sconto";
            }
        }
    }
}
