package com.coderbd.mongodbfulltextsearch.dao;

import com.coderbd.mongodbfulltextsearch.doc.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Qualifier("carDao")
public class CarDaoImpl implements CarDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    final String COLLECTION="cars";

    @Override
    public void create(Car car) {
        mongoTemplate.insert(car);
    }

    @Override
    public void update(Car car) {
        mongoTemplate.save(car);
    }

    @Override
    public void delete(Car car) {

        mongoTemplate.remove(car);
    }

    @Override
    public void deleteAll() {

mongoTemplate.remove(new Query(), COLLECTION);
    }

    @Override
    public Car find(Car car) {

        return mongoTemplate.findOne(new Query(Criteria.where("_id").is(car.getId())), Car.class, COLLECTION);
    }

    @Override
    public List<Car> findAll() {
        return (List < Car > ) mongoTemplate.findAll(Car.class);
    }

    @Override
    public List<Car> searchByText(String str) {
        TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingPhrase("brand").matchingPhrase(str);
        Query query = TextQuery.queryText(criteria).sortByScore();
        List<Car> cars = mongoTemplate.find(query, Car.class);

        return cars;
    }
}
