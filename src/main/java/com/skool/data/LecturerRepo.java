package com.skool.data;

import com.skool.models.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LecturerRepo extends JpaRepository<Lecturer, Long> {

    @Override
    Optional<Lecturer> findById(Long aId);

    Lecturer findByEmployeeId(String employeeId);
}
