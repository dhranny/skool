package com.skool.services;

import com.skool.data.AdminRepo;
import com.skool.data.LecturerRepo;
import com.skool.data.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
		else
			user = null;

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
