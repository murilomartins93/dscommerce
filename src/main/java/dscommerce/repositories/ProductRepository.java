package dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dscommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{	

}
