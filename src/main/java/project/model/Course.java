package project.model;

import jakarta.persistence.Column;

import java.math.BigDecimal;

@jakarta.persistence.Entity
public class Course extends Entity {

    @Column(nullable = false)
    private String name;
    private BigDecimal price;
    private BigDecimal enrollment;
    private Integer duration;
    @Column(columnDefinition = "boolean")
    private boolean verified;

    public Course() {

    }

    public Course(Integer password, String name, BigDecimal price, BigDecimal enrollment, Integer duration, boolean verified) {
        super(password);
        this.name = name;
        this.price = price;
        this.enrollment = enrollment;
        this.duration = duration;
        this.verified = verified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(BigDecimal enrollment) {
        this.enrollment = enrollment;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

}
