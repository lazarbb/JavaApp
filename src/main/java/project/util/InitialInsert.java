package project.util;

import com.github.javafaker.Faker;
import project.model.Group;
import project.model.Student;
import project.model.Lecturer;
import project.model.Course;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class InitialInsert {
    
    private static final int NUMBER_COURSE = 12;
    private static final int NUMBER_STUDENT = 11256;
    private static final int NUMBER_LECTURER = 7;
    private static final int NUMBER_GROUP = 220;
    
    private Faker faker;
    private Session session;
    private List<Course> courses;
    private List<Student> students;
    private List<Lecturer> lecturers;
    
    public InitialInsert() {
        faker = new Faker();
        session = HibernateUtil.getSession();
        courses = new ArrayList<>();
        students = new ArrayList<>();
        lecturers = new ArrayList<>();
        session.getTransaction().begin();
        createCourses();
        createStudents();
        createLecturers();
        createGroups();
        session.getTransaction().commit();
    }
    
    private void createCourses() {
        Course s;
        for (int i = 0; i < NUMBER_COURSE; i++) {
            s = new Course();
            s.setName(faker.beer().name());
            s.setPrice(new BigDecimal(faker.number().numberBetween(910, 1560)));
            s.setEnrollment(new BigDecimal(faker.number().numberBetween(50, 120)));
            s.setDuration(faker.number().numberBetween(90, 350));
            s.setVerified(faker.bool().bool());
            session.persist(s);
            courses.add(s);
        }
    }
    
    private void createStudents() {
        
        Student p;
        for (int i = 0; i < NUMBER_STUDENT; i++) {
            p = new Student();
            p.setFirstName(faker.name().firstName());
            p.setLastName(faker.name().lastName());
            //p.setOib(Tools.getOib());
            p.setOib("25265854585");
            p.setContractNumber(faker.business().creditCardNumber());
            p.setEmail(faker.internet().emailAddress());
            session.persist(p);
            students.add(p);
            
        }
        
    }
    
    private void createLecturers() {
        Lecturer p;
        for (int i = 0; i < NUMBER_LECTURER; i++) {
            p = new Lecturer();
            p.setFirstName(faker.name().firstName());
            p.setLastName(faker.name().lastName());
            p.setOib(Tools.getOib());
            p.setIban(faker.business().creditCardNumber());
            p.setEmail(faker.internet().emailAddress());
            session.persist(p);
            lecturers.add(p);
            
        }
    }
    
    private void createGroups() {
        
        Group g;
        List<Student> p;
        for (int i = 0; i < NUMBER_GROUP; i++) {
            g = new Group();
            g.setName(faker.chuckNorris().fact());
            g.setStartingDate(faker.date().birthday(1, 10));
            g.setLecturer(lecturers.get(faker.number().numberBetween(0, NUMBER_LECTURER - 1)));
            g.setCourse(courses.get(faker.number().numberBetween(0, NUMBER_COURSE - 1)));
            g.setMaxStudents(faker.number().numberBetween(5, 30));
            p = new ArrayList<>();
            for (int j = 0; j < faker.number().numberBetween(5, g.getMaxStudents()); j++) {
                p.add(students.get(faker.number().numberBetween(0, NUMBER_STUDENT - 1)));
            }
            g.setStudents(p);
            session.persist(g);
            
        }
    }
}
