package ru.job4j.cars.servise;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Car;
import ru.job4j.cars.repository.CarRepository;

import java.util.List;

@ThreadSafe
@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void create(Car car) {
        carRepository.create(car);
    }

    public Car update(Car car) {
        return carRepository.update(car);
    }

    public void delete(int id) {
        carRepository.delete(id);
    }

    public Car findById(int id) {
        return carRepository.findById(id);
    }

    public List findByAll() {
        return carRepository.findByAll();
    }
}