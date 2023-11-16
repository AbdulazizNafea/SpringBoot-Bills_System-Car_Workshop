package com.azdev.amrocenter.service;


import com.azdev.amrocenter.apiException.ApiException;
import com.azdev.amrocenter.model.Car;
import com.azdev.amrocenter.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {


    private final CarRepository carRepository;

    public List<Car> getAllCar() {
        return carRepository.findAll();
    }

    public Car getCar(Integer id) {
        Car car = carRepository.findCarById(id);
        if (car == null) {
            throw new ApiException("car not found");
        }
        return carRepository.findCarById(id);
    }

    public void addCar(Car car) {
        carRepository.save(car);
    }

    public boolean updateCar(Car carRes, Integer id) {
        Car car = carRepository.findCarById(id);
        if (car == null) {
            return false;
        }
        car.setCarName(carRes.getCarName());
        car.setModel(carRes.getModel());
        car.setPlateNumber(carRes.getPlateNumber());
        car.setCarNumber(carRes.getCarNumber());
        carRepository.save(car);
        return true;
    }


    public void deleteCar(Integer id) {
        Car car = carRepository.findCarById(id);
        if (car == null) {
            throw new ApiException("car not found");
        }
        carRepository.delete(car);
    }
}
