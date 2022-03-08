package com.skool.services;

import com.skool.data.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {
    @Autowired
    private CourseRepo courseRepo;

    public boolean checkMassEligibility(List<Long> coursesId) {
        if(0 ==
        coursesId.stream().filter(this::checkEligibility).count())
            return true;
        return false;
    }

    public boolean checkEligibility(Long courseId){

        //Todo : do some shit to check course eligibility
        return true;
    }
}
