package com.murilomartins.dscommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.murilomartins.dscommerce.dto.OrderDTO;
import com.murilomartins.dscommerce.entities.Order;
import com.murilomartins.dscommerce.repositories.OrderRepository;
import com.murilomartins.dscommerce.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	@Transactional(readOnly = true)
	public OrderDTO findById(Long id) {
		Order order = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Resource not found"));
		return new OrderDTO(order);
	}

}
