package com.skool.services;

import com.skool.data.CourseRepo;
import com.skool.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepo couRepo;

    public Course getCourse(long courseId){
        Optional<Course> optionalCourse = couRepo.getById(courseId);
        if(optionalCourse.isEmpty())
            throw new IllegalArgumentException("There is no student as this");
        return optionalCourse.get();
    }

    public List getStudents(long courseId){
        Course course = getCourse(courseId);
        return course.getStudents();
    }
}
