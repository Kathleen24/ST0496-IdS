package it.unicam.ids.backend.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Coupon")
public class Coupon {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "aziendaID", referencedColumnName = "id")
    private Azienda azienda;
    @ManyToOne
    @JoinColumn(name = "tessera", referencedColumnName = "tessera")
    private Cliente cliente;
    private Integer valore;
    private Boolean usato;
    private Date dataScadenza;


    //region Costruttori
    public Coupon() {
    }

    public Coupon(Azienda azienda, Cliente cliente, Integer valore, Date dataScadenza) {
        this(azienda, cliente, valore, false, dataScadenza);
    }

    public Coupon(Azienda azienda, Cliente cliente, Integer valore, Boolean usato, Date dataScadenza) {
        this.azienda = azienda;
        this.cliente = cliente;
        this.valore = valore;
        this.usato = usato;
        this.dataScadenza = dataScadenza;
    }

    public Coupon(Coupon coupon) {
        this.id = coupon.getId();
        this.azienda = coupon.getAzienda();
        this.cliente = coupon.getCliente();
        this.valore = coupon.getValore();
        this.usato = coupon.isUsato();
        this.dataScadenza = coupon.getDataScadenza();
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getValore() {
        return valore;
    }

    public void setValore(Integer valore) {
        this.valore = valore;
    }

    public Boolean isUsato() {
        return usato;
    }

    public void setUsato(Boolean usato) {
        this.usato = usato;
    }

    public Date getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }
    //endregion

    //region Equals e HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coupon coupon)) return false;
        return id.equals(coupon.id) &&
                azienda.equals(coupon.azienda) &&
                Objects.equals(cliente, coupon.cliente) &&
                valore.equals(coupon.valore) &&
                usato.equals(coupon.usato) &&
                dataScadenza.equals(coupon.dataScadenza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, azienda, cliente, valore, usato, dataScadenza);
    }
    //endregion
}
