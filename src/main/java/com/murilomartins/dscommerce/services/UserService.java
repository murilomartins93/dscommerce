package com.murilomartins.dscommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.murilomartins.dscommerce.dto.UserDTO;
import com.murilomartins.dscommerce.entities.User;
import com.murilomartins.dscommerce.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = repository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Email not found");
		}
		return user;
	}
	
	protected User authenticated() {
		
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			return repository.findByEmail(username);
		}
		catch (Exception e) {
			throw new UsernameNotFoundException("Invalid user");
		}
		
	}

	@Transactional(readOnly = true)
	public UserDTO getMe() {
		User entity = authenticated();
		return new UserDTO(entity);
	}

}
