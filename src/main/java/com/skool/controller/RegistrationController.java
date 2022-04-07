package com.skool.controller;
import com.skool.models.Admin;
import com.skool.models.LoginModel;
import com.skool.models.Token;
import com.skool.models.User;
import com.skool.services.AdminService;
import com.skool.services.JwtUtil;
import com.skool.services.RegistrationService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class RegistrationController {
    @Autowired
    RegistrationService regServ;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    AdminService adminServ;

    @Autowired
    AuthenticationManager authManager;
    @Autowired
    UserDetailsService userDetailsServ;

    /**
     * @param coursesId
     * @return ResponseEntity<>
     *     Endpoint for course registration it
     *     receives a list of course ids check the
     *     eligibility of student to register and
     *     then register the student.
     */
    @PostMapping("register")
    public ResponseEntity postRegistration(List<Long> coursesId){
        if(regServ.checkMassEligibility(coursesId)) {
            coursesId.forEach(courseId -> regServ.register(courseId));//using a for each to loop through the courseid list
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("login")
    public ResponseEntity postMapping(@NotNull @RequestBody LoginModel login){
        User user = (User)userDetailsServ.loadUserByUsername(login.getUsername());  //converted Userdetails to user
        String token = jwtUtil.makeToken(user);
        return ResponseEntity.ok(new Token(token));
    }

    @PostMapping("admin/register")
    public ResponseEntity adminReg(@RequestBody Admin admin){
        adminServ.saveAdmin(admin);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "admin/login", consumes = "application/json")
    public ResponseEntity adminLogin(@RequestBody LoginModel login){
        System.out.println("came here");
        Admin admin = adminServ.findAdmin(login.getUsername());
       // Authentication authentication = authManager.authenticate(new
         //       UsernamePasswordAuthenticationToken(admin.getUsername(), admin.getPassword()));
        //SecurityContextHolder.getContext().setAuthentication(authentication);
        String stringToken = jwtUtil.makeToken(admin);
        return ResponseEntity.ok(new Token(stringToken));
    }
}
