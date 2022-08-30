package com.skool.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private String courseDescription;
    private String courseTitle;
    private String courseCode;

    @JsonManagedReference
    @ManyToMany(mappedBy = "coursesHandling")
    private List<Lecturer> lecturersInCharge = new ArrayList<>();

    @JsonManagedReference
    @ManyToMany(mappedBy = "courses")
    public List<Student> studentsEnrolled = new ArrayList<>();

    @JsonManagedReference
    @OneToMany//(mappedBy = "courseId")
    private Set<Course> prerequisites = new HashSet<>();
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