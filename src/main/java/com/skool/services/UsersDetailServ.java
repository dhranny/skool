package com.skool.services;

import java.util.Optional;

import com.skool.data.AdminRepo;
import com.skool.data.LecturerRepo;
import com.skool.data.StudentRepo;
import com.skool.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.skool.data.UserRepo;

@Service
public class UsersDetailServ implements UserDetailsService{

	@Autowired
	StudentRepo stuRepo;

	@Autowired
	LecturerRepo lecRepo;

	@Autowired
	AdminRepo adminRepo;

	public UserDetails loadUserByUsername(String username, String role) {
		UserDetails user;
		if (role.equalsIgnoreCase("student"))
			user = stuRepo.findByMatricNoEquals(username);
		if (role.equalsIgnoreCase("lecturer"))
			user = lecRepo.findByEmployeeId(username);
		if (role.equalsIgnoreCase("admin"))
			user = adminRepo.findByUsername(username);

		if(user == null) {
			throw new UsernameNotFoundException("The username was not found");
		}
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}
}
