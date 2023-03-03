package com.shinetech.foodtrucks.service;

import java.util.List;

public interface FoodTrucksService<T> {
    public List<T> queryFoodTrucks();
}
