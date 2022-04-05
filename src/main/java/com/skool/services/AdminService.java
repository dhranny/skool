package com.skool.services;

import com.skool.data.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AdminService {

    @Autowired
    AdminRepo adminRepo;

    

}
