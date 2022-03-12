package com.skool.controller;

import com.skool.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    CourseService couServ;

    @GetMapping("/{courseid}")
    public ResponseEntity getCourseStudents(@PathVariable long courseId){
        List students = couServ.getStudents(courseId);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
