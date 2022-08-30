package com.skool.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Student")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student extends User{

    private String matricNo;
    private String level;
    private String dept;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Student_Courses",
            joinColumns = { @JoinColumn(name = "student_id", referencedColumnName="id") },
            inverseJoinColumns = { @JoinColumn(name = "course_id", referencedColumnName="id") }
    )
    public List<Course> courses;

    @OneToMany
    private List<SemesterResult> results;

    public SemesterResult getLastResult(){
        //todo : Find a reasonable way to get last result from list of results
        SemesterResult lastLevel = results.get(0);
        for (SemesterResult re: results) {
            if (lastLevel.getLevel() >= re.getLevel() | lastLevel.getSemester() >= re.getSemester())
                lastLevel = re;

        }
        return lastLevel;
    }

    protected void addCourse(Course course){
        if (course == null) {
            throw new NullPointerException("Course cannot be null");
        }
        courses.add(course);
    }

    @Override
    public String getUsername() {
        if(super.getUsername() == null)
            return matricNo;
        return super.getUsername();

    }
}
