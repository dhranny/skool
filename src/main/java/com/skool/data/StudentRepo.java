package com.skool.data;

import com.skool.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, String> {

    Student findByMatricNoEquals(String matricNo);
}
