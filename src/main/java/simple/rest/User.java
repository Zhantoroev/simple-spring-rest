package simple.rest;

import javax.persistence.Entity; // JPA - Java Persistance API
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User {
    private @Id @GeneratedValue Long id;
    private String name;
    private String surname;

    public User() {}

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    // ALT + INSERT
    // CTRL + O

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return String.format("User{id=%s, name='%s', surname='%s'}", id, name, surname);
    }
}