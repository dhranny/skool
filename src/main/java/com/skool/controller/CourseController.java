package com.skool.controller;

import com.skool.models.CourseResult;
import com.skool.services.CourseService;
import com.skool.services.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    CourseService couServ;

    @Autowired
    KafkaService kafserv;
    
    @GetMapping("/{courseid}")
    public ResponseEntity getCourseStudents(@PathVariable long courseId){
        List students = couServ.getStudents(courseId);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PatchMapping("/{courseId}/score/")
    public ResponseEntity updateScore(@PathVariable long courseId, @RequestBody List<CourseResult> results){
        couServ.updateScores(courseId, results);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/{couseId}")
    public ResponseEntity sendMessage(@PathVariable Long courseId,@RequestBody String message){
        //todo : wrap messages in an object along with date and student id
        kafserv.send(courseId.toString(), message);
        return ResponseEntity.accepted().build();
    }

}
