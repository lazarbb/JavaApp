package project.model;

import jakarta.persistence.Entity;

@Entity
public class Lecturer extends Person {

    private String iban;

    public Lecturer() {

    }

    public Lecturer(int password, String firstName, String lastName, String oib, String email, String iban) {
        super(password, firstName, lastName, oib, email);
        this.iban = iban;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

}
