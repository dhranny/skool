package com.skool.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student extends Property{

    @Id
    String id;

    private String matricNo;
    private String level;
    private String dept;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Student_Courses",
            joinColumns = { @JoinColumn(name = "matric_no"  ) },
            inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
    private List<Course> courses;

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
}
