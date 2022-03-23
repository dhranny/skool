package com.skool.models;

import com.skool.util.ResultList;

import javax.persistence.*;
import java.util.HashMap;

@Entity
public class SemesterResult {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private int level;

    public int getLevel(){
        return level;
    }

    private int passScore;

    private int semester;

    public int getSemester(){
        return semester;
    }

    private int gpa;

    private int cgpa;

    private ResultList scores = new ResultList();

    @ManyToOne
    private Student student;

    public boolean ifPass(long courseId){
        CourseResult cResult = scores.getByCourse(courseId);
        if (cResult.isPass())
            return true;
        return false;
    }
}
