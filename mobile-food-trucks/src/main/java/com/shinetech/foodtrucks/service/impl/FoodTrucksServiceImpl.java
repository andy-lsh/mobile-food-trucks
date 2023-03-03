package com.shinetech.foodtrucks.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shinetech.foodtrucks.constant.CommonConstant;
import com.shinetech.foodtrucks.service.FoodTrucksService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Andy
 */

@Service
@Slf4j
public class FoodTrucksServiceImpl<T> implements FoodTrucksService {

    @Override
    public List<T>  queryFoodTrucks() {
        List<T> list = new ArrayList<T>();
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("https://data.sfgov.org/api/id/rqzj-sfat.json?$query=select%20*,%20:id%20limit%201000");
        // execute the request and process the response data
        try {
            CloseableHttpResponse response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();
            if (entity != null){
                JSONArray jsonArray = JSON.parseArray(EntityUtils.toString(entity));
                //traverse the json array and get the required data
                for(int i=0;i<jsonArray.size();i++){
                   JSONObject jsonObject= jsonArray.getJSONObject(i);
                   String applicant = (String)jsonObject.get("applicant");
                   String status = (String)jsonObject.get("status");
                   if(CommonConstant.APPROVED.equals(status)&&CommonConstant.NATANFOOD.equals(applicant)){
                       list.add((T)jsonObject);
                   }
                }
            }
            response.close();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

}



