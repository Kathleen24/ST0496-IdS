package it.unicam.ids.backend.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue
    private Integer tessera;

    @OneToOne
    @JoinColumn(name = "utentePiattaformaID", referencedColumnName = "codFis")
    private UtentePiattaforma utentePiattaforma;

    @Column(unique = true)
    private String nomeUtente;
    private String password;
    private String email;
    @OneToMany
    @JoinColumn(name = "tessera") // la colonna tessera sta nella tabella ProgrammaFedeltaDelCliente
    private Set<ProgrammaFedeltaDelCliente> programmiFedelta = new HashSet<>();

    private Date dataIscrizionePiattaforma = new Date();


    //region Costruttori
    public Cliente() {}

    public Cliente(UtentePiattaforma utentePiattaforma, String nomeUtente, String password, String email, Set<ProgrammaFedeltaDelCliente> programmiFedelta, Date dataIscrizionePiattaforma) {
        this.utentePiattaforma = utentePiattaforma;
        this.nomeUtente = nomeUtente;
        this.password = password;
        this.email = email;
        this.programmiFedelta = programmiFedelta;
        this.dataIscrizionePiattaforma = dataIscrizionePiattaforma;
    }

    public Cliente(Cliente cliente) {
        this.tessera = cliente.getTessera();
        this.utentePiattaforma = cliente.getUtentePiattaforma();
        this.nomeUtente = cliente.getNomeUtente();
        this.password = cliente.getPassword();
        this.email = cliente.getEmail();
        this.programmiFedelta.addAll(cliente.getProgrammiFedelta());
        this.dataIscrizionePiattaforma = cliente.getDataIscrizionePiattaforma();
    }
    //endregion


    public void addProgrammaFedelta(ProgrammaFedeltaDelCliente pf) {
        programmiFedelta.add(pf);
    }

    //region Getter e Setter
    public Integer getTessera() {
        return tessera;
    }

    public void setTessera(Integer tessera) {
        this.tessera = tessera;
    }

    public UtentePiattaforma getUtentePiattaforma() {
        return utentePiattaforma;
    }

    public void setUtentePiattaforma(UtentePiattaforma utentePiattaforma) {
        this.utentePiattaforma = utentePiattaforma;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<ProgrammaFedeltaDelCliente> getProgrammiFedelta() {
        return programmiFedelta;
    }

    public void setProgrammiFedelta(Set<ProgrammaFedeltaDelCliente> programmiFedelta) {
        this.programmiFedelta = programmiFedelta;
    }

    public Date getDataIscrizionePiattaforma() {
        return dataIscrizionePiattaforma;
    }

    public void setDataIscrizionePiattaforma(Date dataIscrizione) {
        this.dataIscrizionePiattaforma = dataIscrizione;
    }
    //endregion

    //region equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return tessera.equals(cliente.tessera) &&
                utentePiattaforma.equals(cliente.utentePiattaforma) &&
                nomeUtente.equals(cliente.nomeUtente) &&
                password.equals(cliente.password) &&
                email.equals(cliente.email) &&
                programmiFedelta.equals(cliente.programmiFedelta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tessera, utentePiattaforma, nomeUtente, password, email, programmiFedelta);
    }
    //endregion
}
