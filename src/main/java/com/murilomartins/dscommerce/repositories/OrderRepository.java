package com.murilomartins.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murilomartins.dscommerce.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{	
	
}
