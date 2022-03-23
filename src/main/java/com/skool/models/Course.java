package com.skool.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long courseId;
    private String courseDescription;
    private String courseTitle;
    private String courseCode;

    @JsonManagedReference
    @ManyToMany(mappedBy = "employeeId")
    private List<Lecturer> lecturersInCharge = new ArrayList<>();

    @JsonManagedReference
    @ManyToMany(mappedBy = "matricNo")
    private List<Student> studentsEnrolled = new ArrayList<>();

    @JsonManagedReference
    @OneToMany//(mappedBy = "courseId")
    private List<Course> prerequisites = new ArrayList<>();

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
