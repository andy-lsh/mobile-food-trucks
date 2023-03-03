package com.shinetech.foodtrucks;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class MobileFoodTrucksApplication {

    public static void main(String[] args) {

        SpringApplication.run(MobileFoodTrucksApplication.class, args);

    }

}
