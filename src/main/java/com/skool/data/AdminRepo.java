package com.skool.data;

import com.skool.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepo extends JpaRepository<Admin, Long> {
    //@Query("select a.username a.password from Admin where a.username = ?1")
    Admin findByUsername(String username);
    
}
