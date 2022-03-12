package com.skool.data;

import com.skool.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepo extends JpaRepository {

    public Optional<Course> getById(Long courseId);

}
