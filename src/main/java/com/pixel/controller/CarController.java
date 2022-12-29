package com.pixel.controller;

import com.pixel.model.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @GetMapping("/car/api")
    public Car getCarDetails() {
        Car car = new Car("Swift","ZDI","Suzuki");
        return car;
    }
}
