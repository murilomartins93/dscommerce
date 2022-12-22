package com.murilomartins.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murilomartins.dscommerce.entities.OrderItem;
import com.murilomartins.dscommerce.entities.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {	
	
}
