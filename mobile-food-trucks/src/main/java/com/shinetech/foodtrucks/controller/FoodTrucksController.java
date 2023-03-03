package com.shinetech.foodtrucks.controller;


import com.shinetech.foodtrucks.common.ServerResponse;
import com.shinetech.foodtrucks.service.FoodTrucksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by Andy
 */


@Slf4j
@RestController
@RequestMapping("/foodtruck")
public class FoodTrucksController<T> {

    @Autowired
    FoodTrucksService queryService;

    @RequestMapping("/query")
    public ServerResponse<List<T>> queryFoodTrucks( )   {
        List<T> list = queryService.queryFoodTrucks();
        return ServerResponse.createBySuccess(list);
    }

}
