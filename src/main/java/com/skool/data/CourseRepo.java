package com.skool.data;

import com.skool.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepo extends JpaRepository<Course, Long> {

    public Course getById(Long courseId);

}
