package it.unicam.ids.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name="AmministratorePiattaforma")
public class AmministratorePiattaforma {
    @Id
    private Integer username;
    private Integer password;

    public AmministratorePiattaforma(String username, String password) {
        this.username = username.hashCode();
        this.password = password.hashCode();
    }

    public int getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.hashCode();
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password =password.hashCode();
    }


    public boolean login(String username,String password){
        return this.username==username.hashCode()&&this.password==password.hashCode();
    }

}
