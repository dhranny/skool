package com.skool.models;

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
    private List<Lecturer> lecturersInCharge;
    private List<Student> studentsEnrolled;
    private List<Course> prerequisites;


}
