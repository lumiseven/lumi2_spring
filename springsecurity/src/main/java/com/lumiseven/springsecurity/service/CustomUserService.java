package com.lumiseven.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.lumiseven.springsecurity.dao.SysUserRepository;
import com.lumiseven.springsecurity.domain.SysUser;

public class CustomUserService implements UserDetailsService{

	@Autowired
	SysUserRepository sysUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser user = sysUserRepository.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("username not found.");
		}
		return user;
	}

}
