package it.unicam.ids.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name="AmministratorePiattaforma")
public class AmministratorePiattaforma {
    @Id
    private String username;
    private String password;

    /**
     * Costruisce un amministratore piattaforma i cui dati di accesso sono codificati
     * @param username
     * @param password
     */
    public AmministratorePiattaforma(String username, String password) {
        this.username = username.hashCode() + "";
        this.password = password.hashCode() + "";
    }

    public int getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.hashCode()+"";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password =password.hashCode()+"";
    }


    /**
     * Determina se i parametri inseriti sono corretti e corrispondono ad un account
     * @param username
     * @param password
     * @return true se sono corretti, false altrimenti
     */
    public boolean login(String username,String password){
        return this.username==username.hashCode()&&this.password==password.hashCode();
    }

}
