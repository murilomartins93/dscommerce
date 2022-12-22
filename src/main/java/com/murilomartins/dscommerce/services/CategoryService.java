package com.murilomartins.dscommerce.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.murilomartins.dscommerce.dto.CategoryDTO;
import com.murilomartins.dscommerce.entities.Category;
import com.murilomartins.dscommerce.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> result = repository.findAll();
		return result.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	}

}
