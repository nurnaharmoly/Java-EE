package com.coderbd.mongodbfulltextsearch.test;



import com.coderbd.mongodbfulltextsearch.config.ApplicationConfig;
import com.coderbd.mongodbfulltextsearch.dao.CarSearchRepository;
import com.coderbd.mongodbfulltextsearch.doc.Car;
import com.coderbd.mongodbfulltextsearch.service.CarService;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Collection;
import java.util.List;


public class App {
    @Autowired
    static CarSearchRepository carSearchRepository;
    public static void main(String args[]) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
       CarService carService = (CarService) context.getBean("carService");
Collection<Car> list=carService.findAll();
        System.out.println("size of Cars:"+list.size());
    }


}