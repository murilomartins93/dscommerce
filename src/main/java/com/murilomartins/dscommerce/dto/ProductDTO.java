package com.murilomartins.dscommerce.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.murilomartins.dscommerce.entities.Category;
import com.murilomartins.dscommerce.entities.Product;

public class ProductDTO {

	private Long id;
	@Size(min = 3, max = 80, message = "Name must be between 6 and 20 characters long")
	@NotBlank(message = "Required field")
	private String name;
	@Size(min = 10, message = "Minimum of 10 characters required")
	@NotBlank(message = "Required field")
	private String description;
	@Positive(message = "The price must be positive")
	private Double price;
	private String imgUrl;
	
	@NotEmpty(message = "Deve ter pelo menos um categoria")
	private List<CategoryDTO> categories = new ArrayList<>();
	
	public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}

	public ProductDTO(Product entity) {
		id = entity.getId();
		name = entity.getName();
		description = entity.getDescription();
		price = entity.getPrice();
		imgUrl = entity.getImgUrl();
		for (Category cat : entity.getCategories()) {
			categories.add(new CategoryDTO(cat));
		}
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}

	public String getImgUrl() {
		return imgUrl;
	}
		
	public List<CategoryDTO> getCategories() {
		return categories;
	}
}
