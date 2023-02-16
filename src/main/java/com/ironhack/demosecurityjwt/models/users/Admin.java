package com.ironhack.demosecurityjwt.models.users;

import com.ironhack.demosecurityjwt.models.Role;
import com.ironhack.demosecurityjwt.models.User;
import jakarta.persistence.Entity;

import java.util.Collection;

@Entity
public class Admin extends User {
    /* - name: String; */
    private String name;

    public Admin(Long id, String username, String password, Collection<Role> roles) {
        super(id, username, password, roles);
    }

    public Admin() {
    }

    public Admin(Long id, String username, String password, Collection<Role> roles, String name) {
        super(id, username, password, roles);
        this.name = name;
    }

    public Admin(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}