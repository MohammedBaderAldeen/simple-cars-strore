package com.example.demo.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ParametarsRepository;
import com.example.demo.model.Parametars;;

@Service
public class ParametarsService {
	@Autowired
	ParametarsRepository parametarsRepository;
	
	@Cacheable(value = "parametars-cache", key = "'parametarscache'+#id")
	@Transactional
	public Parametars getParametarsById(int id) {
		
		return parametarsRepository.findParametarsByid(id);
	}
	
	@CacheEvict(value = "parametars-cache", key = "'parametarscache'+#id")
	@Transactional
	public void deleteEvict(int id) {
		System.out.println("Deleted .....");
	}
	
	@Transactional
	public void UpdateParametars(Parametars newparametars) {
		Parametars parametars=new Parametars();
		parametars=parametarsRepository.findParametarsByid(newparametars.getId());
		parametars=newparametars;
		parametarsRepository.save(parametars);
	}

}
