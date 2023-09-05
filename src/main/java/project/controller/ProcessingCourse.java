package project.controller;

import project.model.Course;
import project.util.MyException;
import java.util.List;

public class ProcessingCourse extends Processing<Course> {

    @Override
    public List<Course> read() {
        // HQL https://docs.jboss.org/hibernate/core/3.3/reference/en/html/queryhql.html
        return session.createQuery("from Course", Course.class).list();
    }

    @Override
    protected void controlInput() throws MyException {
        controlName();
    }

    @Override
    protected void controlChange() throws MyException {
       
    }

    @Override
    protected void controlDeletion() throws MyException {
       
    }

    private void controlName() throws MyException {
        if(entity.getName()==null){
            throw new MyException("Course name must be defined.");
        }
        if(entity.getName().isEmpty()){
            throw new MyException("Course name can not be empty");
        }
    }
    
}
