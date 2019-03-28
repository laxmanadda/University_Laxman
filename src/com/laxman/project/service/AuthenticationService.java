package com.laxman.project.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.laxman.project.DAO.UserDAO;
import com.laxman.project.entity.user;

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		user userInfo = userDAO.getUserInfo(username);
		GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());
		UserDetails userDetails = (UserDetails)new User(userInfo.getUser_name(), userInfo.getPassword(), Arrays.asList(authority));
		return userDetails;
	}
}

