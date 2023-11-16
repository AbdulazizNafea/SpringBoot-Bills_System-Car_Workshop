package com.azdev.amrocenter.controller;

import com.azdev.amrocenter.model.Car;
import com.azdev.amrocenter.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/get")
    public ResponseEntity getAllCar() {
        List<Car> customers = carService.getAllCar();
        return ResponseEntity.status(200).body(customers);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getCar(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(carService.getCar(id));
    }

    @PostMapping("/add")
    public ResponseEntity addCar(@RequestBody Car car) {
        carService.addCar(car);
        return ResponseEntity.status(200).body("Car Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCar(@RequestBody Car car, @PathVariable Integer id) {
        carService.updateCar(car, id);
        return ResponseEntity.status(200).body("Car updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCar(@PathVariable Integer id) {
        return ResponseEntity.status(200).body("deleted");
    }
}


