package com.skool.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lecturer extends Property{

    @Id
    String id;
    String employeeId;


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Employee_Courses",
            joinColumns = { @JoinColumn(name = "employee_id"  ) },
            inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
    private List<Course> coursesHandling;
    //TODO : Finish up the lecturer fields.
    //TODO : Decide if to create a department class.
}
