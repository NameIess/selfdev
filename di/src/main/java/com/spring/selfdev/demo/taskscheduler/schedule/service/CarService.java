package com.spring.selfdev.demo.taskscheduler.schedule.service;

import com.spring.selfdev.demo.taskscheduler.schedule.entity.Car;

import java.util.List;

public interface CarService {

    List<Car> findAll();

    Car save(Car car);

    void updateCarAgeJob();
}
