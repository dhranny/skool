package com.skool.controller;

import com.skool.models.Student;
import com.skool.models.Token;
import com.skool.services.JwtUtil;
import com.skool.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentEnd {
    
    @Autowired
    StudentService stuServ;

    @Autowired
    JwtUtil jwt;

    @PostMapping("/login")
    public ResponseEntity studentLogin(@RequestBody Student student){
        String tokenString = jwt.makeToken(student);
        Token token = new Token(tokenString);
        return ResponseEntity.ok(token);
    }
}
// todo Create student end