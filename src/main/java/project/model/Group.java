package project.model;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@jakarta.persistence.Entity
public class Group extends Entity {

    private String name;
    @ManyToOne
    private Course course;
    private Integer maxStudents;
    @ManyToOne
    private Lecturer lecturer;
    private Date startingDate;

    @ManyToMany
    private List<Student> students;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(Integer maxStudents) {
        this.maxStudents = maxStudents;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
