package com.skool.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Lecturer extends User{

    String employeeId;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Employee_Courses",
            joinColumns = { @JoinColumn(name = "employee_id"  ) },
            inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
    private List<Course> coursesHandling;

    @Enumerated
    @Column(name = "role")
    private User.Role role;

    public User.Role getRole() {
        return role;
    }

    public void setRole(User.Role role) {
        this.role = role;
    }
//TODO : Finish up the lecturer fields.
    //TODO : Decide if to create a department class.
}
