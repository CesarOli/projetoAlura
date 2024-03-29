package com.example.projetoAlura.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private Roles roles;
    private Date date;

    private static List<User> userDatabase = new ArrayList<>();

    public User(String name, String username, String email, String password, Roles roles, Date date) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.date = date;
    }

    public User() {

    }

    public boolean isEmailInUse(String emailToCheck) {
        return this.email.equals(emailToCheck);
    }

    public boolean isUsernameInUse(String usernameToCheck) {
        for(User user : userDatabase) {
            if(user.getUsername() .equals(usernameToCheck)) {
                return true;
            }
        }
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {

        username = username.toLowerCase();

        username = username.replaceAll("[^a-z]", "");
        this.username = username;
    }

    public void setEmail(String email) throws IllegalAccessException {

        if (isValidEmail(email)) {
            this.email = email;
        } else {
            throw new IllegalAccessException("Endereço de email inválido.");
        }
    }

    private boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Roles getRoles() {
        return roles;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(username, user.username) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                roles == user.roles &&
                Objects.equals(date, user.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, username, email, password, roles, date);
    }
}


