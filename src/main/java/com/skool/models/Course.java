package com.skool.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String courseDescription;
    private String courseTitle;
    private String courseCode;

    @JsonManagedReference
    private List<Lecturer> lecturersInCharge;

    @JsonManagedReference
    private List<Student> studentsEnrolled;

    @JsonManagedReference
    private List<Course> prerequisites;

    public void addStudent(Student student){
        if (student == null) {
            throw new NullPointerException("Student cannot be null");
        }
        //todo : write code to check if student is already registered
        studentsEnrolled.add(student);
        student.addCourse(this);
    }

    public List<Student> getStudents(){
        return studentsEnrolled;
    }

}
