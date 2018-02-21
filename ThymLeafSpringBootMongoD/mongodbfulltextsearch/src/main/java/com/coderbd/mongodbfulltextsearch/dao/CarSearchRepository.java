package com.coderbd.mongodbfulltextsearch.dao;

import java.util.Collection;
import java.util.function.Predicate;


import com.coderbd.mongodbfulltextsearch.doc.Car;
import com.mongodb.client.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;



@Repository
public class CarSearchRepository {

@Autowired
	MongoTemplate mongoTemplate;
	/*
	public Collection<Car> searchCars(String text) {
		return mongoTemplate.find(Query.query(new Criteria()
						.orOperator(Criteria.where("description").regex(text, "i"),
									Criteria.where("make").regex(text, "i"),
									Criteria.where("model").regex(text, "i"))
						), Car.class);
	}
	*/
	public Collection<Car> searchCars(String text){
		return mongoTemplate.find(Query.query(new Criteria()
				.orOperator(Criteria.where("brand").regex(text,"i"),
						Criteria.where("model").regex(text,"i"))),Car.class);
	}


}
