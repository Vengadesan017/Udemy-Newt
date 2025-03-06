package com.vengat.Student.repo;

import com.vengat.Student.model.Student;
import jdk.jfr.Registered;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    public void save(Student s){
        System.out.println("saving " + s);
    }

    public List<Student> findall() {
        List<Student> ss = new ArrayList<>();
        return ss;
    }
}
