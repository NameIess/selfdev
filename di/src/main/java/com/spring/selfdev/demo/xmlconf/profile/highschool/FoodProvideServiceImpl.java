package com.spring.selfdev.demo.xmlconf.profile.highschool;

import com.spring.selfdev.demo.xmlconf.profile.Food;
import com.spring.selfdev.demo.xmlconf.profile.FoodProvideService;

import java.util.ArrayList;
import java.util.List;

public class FoodProvideServiceImpl implements FoodProvideService {

    @Override
    public List<Food> getLunchList() {
        List<Food> foodList = new ArrayList<>();
        foodList.add(new Food("Coke"));
        foodList.add(new Food("Hamburger"));
        foodList.add(new Food("French Fries"));

        return foodList;
    }

}
