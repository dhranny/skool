package com.skool.controller;

import com.skool.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value  ="register")
public class RegistrationController {
    @Autowired
    RegistrationService regServ;

    @PostMapping
    public ResponseEntity postRegistration(List<Long> coursesId){
        if(regServ.checkMassEligibility(coursesId))
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
