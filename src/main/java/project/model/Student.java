package project.model;

import jakarta.persistence.Entity;

@Entity
public class Student extends Person {

    private String contractNumber;

    public Student() {

    }

    public Student(int password, String firstName, String lastName, String oib, String email, String contractNumber) {
        super(password, firstName, lastName, oib, email);
        this.contractNumber = contractNumber;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

}
