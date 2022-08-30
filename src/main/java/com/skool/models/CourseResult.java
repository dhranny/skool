package com.skool.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseResult {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String studentId;
    public String getStudentId(){
        return studentId;
    }
    public void setStudentId(String studentId){
        this.studentId = studentId;
    }

    int testScore;
    public int getTestScore(){
        return testScore;
    }
    public void setTextScore(int testScore){
        this.testScore = testScore;
    }

    Long courseId;
    public Long getCourseId(){
        return courseId;
    }
    public void setCourseId(Long courseId){
        this.courseId = courseId;
    }

    int examScore;
    public int getExamScore(){
        return examScore;
    }
    public void setExamScore(int examScore){
        this.examScore = examScore;
    }

    int passScore;
    public int getPassScore(){
        return passScore;
    }
    public void setPassScore(int testScore){
        this.passScore = passScore;
    }
    public boolean isPass(){
        if (testScore + examScore >= passScore) {
            return true;
        }
        return false;
    }
}
