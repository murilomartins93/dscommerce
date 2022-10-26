package com.murilomartins.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murilomartins.dscommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{	

}
