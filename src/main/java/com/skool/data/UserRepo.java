package com.skool.data;

import com.skool.models.Student;
import com.skool.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    //public Optional<User> findStudentById(Long studentId);
    public User findByLastName(String lastName);
}
