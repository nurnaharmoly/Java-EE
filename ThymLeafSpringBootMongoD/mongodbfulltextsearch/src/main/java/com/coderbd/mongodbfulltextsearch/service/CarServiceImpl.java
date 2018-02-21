package com.coderbd.mongodbfulltextsearch.service;

import com.coderbd.mongodbfulltextsearch.dao.CarDao;
import com.coderbd.mongodbfulltextsearch.doc.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("carService")
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public void create(Car car) {
        carDao.create(car);
    }

    @Override
    public void update(Car car) {
        carDao.update(car);
    }

    @Override
    public void delete(Car car) {
        carDao.delete(car);
    }

    @Override
    public void deleteAll() {
        carDao.deleteAll();
    }

    @Override
    public Car find(Car car) {
        return carDao.find(car);
    }

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public List<Car> searchByText(String str) {
        return carDao.searchByText(str);
    }
}
