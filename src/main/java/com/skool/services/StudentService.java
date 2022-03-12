package com.skool.services;

import com.skool.data.StudentRepo;
import com.skool.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo stuRepo;

    public void saveAllStudent(List<Student> students){
        if(students == null || students.isEmpty())
            throw new IllegalArgumentException("list of students is Null or empty");
        stuRepo.saveAll(students);
    }
}
