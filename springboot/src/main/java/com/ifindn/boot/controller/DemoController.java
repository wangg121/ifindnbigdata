package com.ifindn.boot.controller;


import com.ifindn.boot.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    Car car;

    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello World!";
    }

    @RequestMapping("/car")
    public Car car(){
        return car;
    }
}
