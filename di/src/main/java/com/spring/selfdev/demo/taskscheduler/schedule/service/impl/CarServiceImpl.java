package com.spring.selfdev.demo.taskscheduler.schedule.service.impl;

import com.google.common.collect.Lists;
import com.spring.selfdev.demo.taskscheduler.schedule.dao.CarRepository;
import com.spring.selfdev.demo.taskscheduler.schedule.entity.Car;
import com.spring.selfdev.demo.taskscheduler.schedule.service.CarService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("carService")
@Repository
@Transactional
public class CarServiceImpl implements CarService {
    private static final Logger Log = LogManager.getLogger(CarServiceImpl.class.getSimpleName());
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAll() {
        return Lists.newArrayList(carRepository.findAll());
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Scheduled(fixedDelay = 10000L)
    @Override
    public void updateCarAgeJob() {
        List<Car> carList = findAll();

        DateTime currentDate = DateTime.now();
        Log.info("Car age update job started.");

        for (Car car : carList) {
            int age = Years.yearsBetween(car.getManufactureDate(), currentDate).getYears();
            car.setAge(age);
            save(car);
            Log.info("Car age update --- " + car);
        }

        Log.info("Car update job completed successfully");
    }
}
