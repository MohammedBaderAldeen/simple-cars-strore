package com.example.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Parametars;;

public interface ParametarsRepository extends JpaRepository<Parametars,Integer>{
	
	public Parametars findParametarsByid(int id);

}
