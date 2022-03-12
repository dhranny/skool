package com.skool.data;

import com.skool.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Long> {
    public Optional<Student> findStudentById();
}
