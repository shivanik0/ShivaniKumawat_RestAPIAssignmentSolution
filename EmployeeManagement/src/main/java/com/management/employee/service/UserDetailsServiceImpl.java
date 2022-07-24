package com.management.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.management.employee.entity.User;
import com.management.employee.repository.IUserRepository;
import com.management.employee.security.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.getUserByUsername(username);
		if (user==null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		else
			return new UserDetailsImpl(user);	
	}

	public User addUser(User user) {
		return userRepository.save(user);
	}
}
