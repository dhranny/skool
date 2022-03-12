package com.skool.controller;

import com.skool.models.Student;
import com.skool.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin")
public class SchoolAdmin {
    
    @Autowired
    StudentService stuServ;
    
    public ResponseEntity addStudents(List<Student> students){
        stuServ.saveAllStudent(students);
        return new ResponseEntity(HttpStatus.OK);
    }


//todo : add endpoint for adding only one student
}
