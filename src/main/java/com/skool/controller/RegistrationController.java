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

    /**
     * @param coursesId
     * @return ResponseEntity<>
     *     Endpoint for course registration it
     *     receives a list of course ids check the
     *     eligibility of student to register and
     *     then register the student.
     */
    @PostMapping
    public ResponseEntity postRegistration(List<Long> coursesId){
        if(regServ.checkMassEligibility(coursesId)) {
            coursesId.forEach(courseId -> regServ.register(courseId));//using a for each to loop through the courseid list
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
