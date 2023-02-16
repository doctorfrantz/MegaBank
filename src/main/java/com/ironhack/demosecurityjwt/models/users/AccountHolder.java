package com.ironhack.demosecurityjwt.models.users;

import com.ironhack.demosecurityjwt.models.Role;
import com.ironhack.demosecurityjwt.models.User;
import com.ironhack.demosecurityjwt.tools.Address;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class AccountHolder extends User {
    /* - name: String;
- dateOfBirth: LocalDate;
- primaryAddress: @NotNull Address;
- mailingAddress: @Nullable String;*/
    private String name;

    private LocalDate dateOfBirth;

    @NotNull
    private Address primaryAddress;

    @Nullable
    private String mailingAddress;

    public AccountHolder(String username, String password, Collection<Role> roles) {
        super(username, password, roles);
    }

    public AccountHolder() {
    }

    public AccountHolder(String username, String password, Collection<Role> roles, String name, LocalDate dateOfBirth, Address primaryAddress, String mailingAddress) {
        super(username, password, roles);
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }

    public AccountHolder(String name, LocalDate dateOfBirth, Address primaryAddress, String mailingAddress) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
}
