package lv.dudonz.simplewebapp.repositories;

import lv.dudonz.simplewebapp.domain.Store;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepository extends CrudRepository<Store, Long> { }