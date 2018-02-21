package com.coderbd.mongodbfulltextsearch.service;



import com.coderbd.mongodbfulltextsearch.doc.Car;


import java.util.List;


public interface CarService {

    public void create(Car car);

    public void update(Car car);

    public void delete(Car car);

    public void deleteAll();

    public Car find(Car car);

    public List < Car > findAll();
    public List<Car> searchByText(String str);
}