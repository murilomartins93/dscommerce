package com.murilomartins.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murilomartins.dscommerce.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);
	
}
