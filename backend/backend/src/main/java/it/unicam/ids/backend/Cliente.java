package it.unicam.ids.backend;

import jakarta.persistence.*;

@Entity
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

    //Costruttori
    public Cliente (){
    }
    public Cliente(Integer tessera, Persona persona, String nomeUtente, String password, String email) {
        this.tessera = tessera;
        this.persona = persona;
        this.nomeUtente = nomeUtente;
        this.password = password;
        this.email = email;
    }
    public Cliente(Cliente cliente){
        this.tessera = cliente.getTessera();
        this.persona = cliente.getPersona();
        this.nomeUtente = cliente.getNomeUtente();
        this.password = cliente.getPassword();
        this.email = cliente.getEmail();
    }

    //Getter e Setter
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

    public boolean verificaEmail() {
        // TODO: 28/12/22
        return false;
    }
}
