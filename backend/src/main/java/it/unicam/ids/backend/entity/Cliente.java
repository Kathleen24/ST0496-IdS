package it.unicam.ids.backend.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    private Integer tessera;
    @OneToOne
    @JoinColumn(name = "persona", referencedColumnName = "id")
    private Persona persona;
    @Column(name = "nomeUtente", unique = true)
    private String nomeUtente;
    private String password;
    private String email;
    @OneToMany(mappedBy = "cliente")
    private Set<ProgrammaFedeltaDelCliente> programmiFedelta;


    //region Costruttori
    public Cliente() {
    }

    public Cliente(Integer tessera, Persona persona, String nomeUtente, String password, String email, Set<ProgrammaFedeltaDelCliente> programmiFedelta) {
        this.tessera = tessera;
        this.persona = persona;
        this.nomeUtente = nomeUtente;
        this.password = password;
        this.email = email;
        this.programmiFedelta = programmiFedelta;
    }

    public Cliente(Cliente cliente) {
        this.tessera = cliente.getTessera();
        this.persona = cliente.getPersona();
        this.nomeUtente = cliente.getNomeUtente();
        this.password = cliente.getPassword();
        this.email = cliente.getEmail();
        this.programmiFedelta = Set.copyOf(cliente.getProgrammiFedelta());
    }
    //endregion


    //region Getter e Setter
    public Integer getTessera() {
        return tessera;
    }

    public void setTessera(Integer tessera) {
        this.tessera = tessera;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
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
    //endregion
}
