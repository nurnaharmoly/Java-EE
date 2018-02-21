package com.coderbd.thymeleafmongodbboot.repository;

import com.coderbd.thymeleafmongodbboot.model.Car;
import org.springframework.data.repository.CrudRepository;


public interface CarMongoRepository extends CrudRepository<Car, String> {}