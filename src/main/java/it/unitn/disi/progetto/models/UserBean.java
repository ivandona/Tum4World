package it.unitn.disi.progetto.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class UserBean implements Serializable {
    int id;
    String name;
    String surname;
    String email;
    LocalDate birthdate;
    String phoneNumber;
    UserRole userRole;
    String username;
    String password;
    // activity_1 = true -> l'utente è iscritto a quella attività
    // activity_1 = false -> l'utente non è iscritto a quella attività
    Boolean activity_1;
    Boolean activity_2;
    Boolean activity_3;

    public UserBean() {}

    public UserBean(String name, String surname, String email, LocalDate birthdate, String phoneNumber, UserRole userRole,
                    String username, String password, Boolean activity_1, Boolean activity_2, Boolean activity_3) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
        this.userRole = userRole;
        this.username = username;
        this.password = password;
        this.activity_1 = activity_1;
        this.activity_2 = activity_2;
        this.activity_3 = activity_3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActivity_1() {
        return activity_1;
    }

    public void setActivity_1(Boolean activity_1) {
        this.activity_1 = activity_1;
    }

    public Boolean getActivity_2() {
        return activity_2;
    }

    public void setActivity_2(Boolean activity_2) {
        this.activity_2 = activity_2;
    }

    public Boolean getActivity_3() {
        return activity_3;
    }

    public void setActivity_3(Boolean activity_3) {
        this.activity_3 = activity_3;
    }
}
