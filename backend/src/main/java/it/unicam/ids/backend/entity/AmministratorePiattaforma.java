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


    //region Costruttori
    public AmministratorePiattaforma() {}

    /**
     * Costruisce un amministratore piattaforma i cui dati di accesso sono codificati
     *
     * @param username lo username
     * @param password la password
     */
    public AmministratorePiattaforma(String username, String password) {
        this.username = username.hashCode() + "";
        this.password = password.hashCode() + "";
    }
    //endregion


    /**
     * Determina se i parametri inseriti sono corretti e corrispondono ad un account
     *
     * @param username lo username
     * @param password la password
     * @return true se sono corretti, false altrimenti
     */
    public boolean login(String username, String password) {
        return Objects.equals(this.username, username) && Objects.equals(this.password, password);
    }

    //region Getter e Setter
    public String getUsername() {
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
    //endregion

    //region equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AmministratorePiattaforma that)) return false;
        return username.equals(that.username) && password.equals(that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
    //endregion
}
