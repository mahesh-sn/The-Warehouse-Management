package com.jsp.warehouse.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jsp.warehouse.repo.AdminRepo;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private AdminRepo adminRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return adminRepo.findByEmail(email).map(UserDetailImpl::new)
				.orElseThrow(()-> new UsernameNotFoundException("Invalid Credentials"));
	}
}
