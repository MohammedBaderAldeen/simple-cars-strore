package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CarsRepository;
import com.example.demo.model.Cars;

@Service
public class CarsService {

	@Autowired
	CarsRepository carsRepository;

	@Transactional
	public List<Cars> getAllCars() {
		List<Cars> cars = new ArrayList<>();
		cars = carsRepository.findAll();
		return cars;
	}

	
	@Transactional
	public Cars getCarById(int id) {
		
		return carsRepository.findCarsByid(id);
	}

	@Transactional
	public List<Cars> getCarsNotSale() {
		return carsRepository.findBysoldFalse();
	}
	
	@Transactional
	public List<Cars> getCarsSale() {
		return carsRepository.findBysoldTrue();
	}

	@Transactional
	public void addCar(Cars newCar) {
		carsRepository.save(newCar);
	}

	@Transactional
	public void updateCar(Cars newCar) {		
		Cars car = new Cars();
		car = carsRepository.findCarsByid(newCar.getId());
		car = newCar;
		car.setVersion(car.getVersion()+1);
		carsRepository.save(car);
	}

	@Transactional
	public void deleteCar(int id) {
		carsRepository.deleteById(id);
	}
	
	@Transactional
	public long getVersion(int id) {
		return carsRepository.getVersionCar(id);
	}
	
}
