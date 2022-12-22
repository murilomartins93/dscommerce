package com.murilomartins.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murilomartins.dscommerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{	

}
