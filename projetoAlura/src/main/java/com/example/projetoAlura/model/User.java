package com.example.projetoAlura.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "username", unique = true)
    private String username;

    private String name;
    private String email;
    private String password;
    private Roles roles;
    private Date date;

    public User() {

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


