package lv.dudonz.simplewebapp.repositories;

import lv.dudonz.simplewebapp.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> { }
