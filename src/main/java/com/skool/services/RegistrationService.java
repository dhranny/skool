package com.skool.services;

import com.skool.data.CourseRepo;
import com.skool.models.Course;
import com.skool.models.SemesterResult;
import com.skool.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.InputMismatchException;
import java.util.List;

@Service
public class RegistrationService {


    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private CourseService couServ;

    SemesterResult lastResult;

    Student student;


    public boolean checkMassEligibility(@NonNull List<Long> coursesToReg) {
        if(0 ==
        coursesToReg.stream().filter(this::checkEligibility).count())
            return true;
        return false;
    }

    public boolean checkEligibility(Long courseId){
        if(!courseRepo.existsById(courseId))
            throw new InputMismatchException("Course does not exist");
        if(lastResult.ifPass(courseId))
            return true;
        return false;
    }

    public void register(Long courseId){
        Course course = (Course)couServ.getCourse(courseId);
        course.addStudent(student);
    }
}
