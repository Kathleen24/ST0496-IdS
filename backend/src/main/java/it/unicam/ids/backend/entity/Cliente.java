package it.unicam.ids.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
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
    @JoinColumn(name = "utentePiattaformaID", referencedColumnName = "codFis", nullable = false)
    private UtentePiattaforma utentePiattaforma;

    @Column(unique = true, nullable = false)
    private String nomeUtente;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    @OneToMany
    @JoinColumn(name = "tessera") // la colonna tessera sta nella tabella ProgrammaFedeltaDelCliente
    private Set<ProgrammaFedeltaDelCliente> programmiFedelta = new HashSet<>();

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(nullable = false)
    private LocalDate dataIscrizionePiattaforma = LocalDate.now();


    //region Costruttori
    public Cliente() {}

    public Cliente(UtentePiattaforma utentePiattaforma, String nomeUtente, String password, String email) {
        this.utentePiattaforma = utentePiattaforma;
        this.nomeUtente = nomeUtente;
        this.password = password;
        this.email = email;
    }

    public Cliente(UtentePiattaforma utentePiattaforma, String nomeUtente, String password, String email, Set<ProgrammaFedeltaDelCliente> programmiFedelta, LocalDate dataIscrizionePiattaforma) {
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

    public LocalDate getDataIscrizionePiattaforma() {
        return dataIscrizionePiattaforma;
    }

    public void setDataIscrizionePiattaforma(LocalDate dataIscrizione) {
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
