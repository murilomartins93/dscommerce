package com.murilomartins.dscommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.murilomartins.dscommerce.entities.Order;
import com.murilomartins.dscommerce.entities.OrderItem;
import com.murilomartins.dscommerce.enums.OrderStatus;

public class OrderDTO {

	private Long id;
	private Instant moment;
	private OrderStatus status;
	
	private ClientDTO client;
	
	private PaymentDTO payment;
	
	@NotEmpty(message = "Must have at least one item")
	private List<OrderItemDTO> items = new ArrayList<>();

	public OrderDTO(Long id, Instant moment, OrderStatus status, ClientDTO client, PaymentDTO payment) {
		this.id = id;
		this.moment = moment;
		this.status = status;
		this.client = client;
		this.payment = payment;
	}
	
	public OrderDTO(Order entity) {
		id = entity.getId();
		moment = entity.getMoment();
		status = entity.getStatus();
		client = new ClientDTO(entity.getClient());
		payment = (entity.getPayment() == null) ? null : new PaymentDTO(entity.getPayment());
		for (OrderItem item : entity.getItems()) { 
			items.add(new OrderItemDTO(item));
		}
	}

	public Long getId() {
		return id;
	}

	public Instant getMoment() {
		return moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public ClientDTO getClient() {
		return client;
	}

	public PaymentDTO getPayment() {
		return payment;
	}

	public List<OrderItemDTO> getItems() {
		return items;
	}
	
	public Double getTotal() {
		double sum = 0.0;
		for (OrderItemDTO item : items) {
			sum += item.getSubtotal();
		}
		return sum;
	}
	
}
