package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Cars;

public interface CarsRepository extends JpaRepository<Cars, Integer>{
	
	public List<Cars> findBysoldFalse();
	
	public List<Cars> findBysoldTrue();
	
	public Cars findCarsByid(int id);
	
	@Query("select version from Cars car where car.id = :id")
	public long getVersionCar(@Param("id") int id);
	
	
}
