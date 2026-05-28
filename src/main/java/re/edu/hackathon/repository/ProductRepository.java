package re.edu.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.edu.hackathon.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
