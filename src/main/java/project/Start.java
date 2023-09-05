package project;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import project.controller.ProcessingCourse;
import project.model.Course;
import project.util.MyException;

import java.util.List;

public class Start {

    public static void main(String[] args) {
        
        String json = "";

        List<Course> list = new Gson().fromJson(json,
                new TypeToken<List<Course>>(){}.getType());
        
        ProcessingCourse pc = new ProcessingCourse();
        
        for(Course s : list){
            pc.setEntity(s);
            try {
                pc.create();
            } catch (MyException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
