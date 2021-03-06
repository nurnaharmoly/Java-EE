package com.coderbd.mongodbjavaobjembeded.repositories;


import com.coderbd.mongodbjavaobjembeded.documents.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {

  List<Person> findByFirstName(final String firstName);

  @Query("{'address.country': ?0}")
  List<Person> findByCountry(final String country);

  @Query("{'department.departmentName': ?0}")
  List<Person> findByDepartmentName(final String departmentName);
}
