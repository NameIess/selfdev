package com.spring.selfdev.demo.xmlconf.profile.kindergarten;

import com.spring.selfdev.demo.xmlconf.profile.Food;
import com.spring.selfdev.demo.xmlconf.profile.FoodProvideService;

import java.util.ArrayList;
import java.util.List;

public class FoodProvideServiceImpl implements FoodProvideService {

    @Override
    public List<Food> getLunchList() {
        List<Food> foodList = new ArrayList<>();
        foodList.add(new Food("Milk"));
        foodList.add(new Food("Biscuits"));

        return foodList;
    }

}
