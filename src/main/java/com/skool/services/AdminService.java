package com.skool.services;

import com.skool.data.AdminRepo;
import com.skool.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AdminService {

    @Autowired
     AdminRepo adminRepo;

    public void saveAdmin(Admin admin){
        adminRepo.save(admin);
    }

    public Admin findAdmin(String username){
        return adminRepo.findByUsername(username);
    }
    

}
