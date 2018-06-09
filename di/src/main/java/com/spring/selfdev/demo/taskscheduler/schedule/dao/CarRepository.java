package com.spring.selfdev.demo.taskscheduler.schedule.dao;

import com.spring.selfdev.demo.taskscheduler.schedule.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}
