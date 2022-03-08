package com.skool.models;

import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashMap;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private int level;

    private int passScore;

    private int semester;

    private int gpa;

    private int cgpa;

    private HashMap<Course, Integer> scores = new HashMap();

    private long studentId;

    public boolean ifPass(long courseId){
        int score = scores.get(courseId);
        if (score >= passScore)
            return true;
        return false;
    }
}
