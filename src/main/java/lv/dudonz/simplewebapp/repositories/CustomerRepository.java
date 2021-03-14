package lv.dudonz.simplewebapp.repositories;

import lv.dudonz.simplewebapp.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
