package project.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person extends Entity {

    private String firstName;
    private String lastName;
    private String oib;
    private String email;

    public Person() {

    }

    public Person(int password, String firstName, String lastName, String oib, String email) {
        super(password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.oib = oib;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
