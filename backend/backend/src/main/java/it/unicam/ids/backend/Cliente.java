package it.unicam.ids.backend;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cliente {

    @Id
    private int tessera;
    @OneToOne
    @JoinColumn(name = "persona", referencedColumnName = "id")
    private Persona persona;
    @Column(name = "nomeUtente", unique = true)
    private String nomeUtente;
    private String password;
    private String email;


    public boolean verificaEmail() {
        // TODO: 28/12/22
        return false;
    }
}
