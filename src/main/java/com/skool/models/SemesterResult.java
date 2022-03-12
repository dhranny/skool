package com.skool.models;

import com.skool.util.ResultList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    private long studentId;

    public boolean ifPass(long courseId){
        CourseResult cResult = scores.getByCourse(courseId);
        if (cResult.isPass())
            return true;
        return false;
    }
}
