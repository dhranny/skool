package com.skool.services;

import java.util.Optional;

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
	UserRepo userRepo;
	
	public UserDetails loadUserByUsername(String username) {
		UserDetails user = userRepo.findByLastName(username);
		if(user == null) {
			throw new UsernameNotFoundException("The username was not found");
		}
		return user;
	}

	public void saveUser(@NonNull User user){
		userRepo.save(user);
	}

}
