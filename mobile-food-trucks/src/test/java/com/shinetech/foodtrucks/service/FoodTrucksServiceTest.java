package com.shinetech.foodtrucks.service;

import com.alibaba.fastjson.JSONObject;
import com.shinetech.foodtrucks.MobileFoodTrucksApplication;
import com.shinetech.foodtrucks.constant.CommonConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
    @SpringBootTest(classes = MobileFoodTrucksApplication.class)
    public class FoodTrucksServiceTest {

        @Autowired
        FoodTrucksService foodTrucksService;

        @Test
        public void queryFoodTrucks(){
           List list = foodTrucksService.queryFoodTrucks();
           for(int i=0;i<list.size();++i){
               assertEquals(CommonConstant.APPROVED,((JSONObject)list.get(i)).get("status"));
               assertEquals(CommonConstant.NATANFOOD,((JSONObject)list.get(i)).get("applicant"));
           }
        }



    }




