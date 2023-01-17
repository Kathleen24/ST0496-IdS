package it.unicam.ids.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name="Bonus")
public class Bonus {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer valore;
    private String descrizione;
    private enum Tipo{PUNTI,CASHBACK,SCONTO};


    //region Costruttori
    public Bonus() {
    }

    public Bonus(Integer id, Integer valore, String descrizione) {
        this.id = id;
        this.valore = valore;
        this.descrizione = descrizione;
    }
    //endregion


    //region Getter e Setter

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

    //endregion

    //region Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bonus bonus = (Bonus) o;
        return Objects.equals(id, bonus.id) && Objects.equals(valore, bonus.valore) && Objects.equals(descrizione, bonus.descrizione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valore, descrizione);
    }
    //endregion
}
