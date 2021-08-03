package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

import com.example.demo.Repository.CarsRepository;
import com.example.demo.Service.CarsService;
import com.example.demo.model.Cars;
import com.fasterxml.jackson.databind.ObjectMapper;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CarWebApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	CarsRepository carRepository;
	
	@Autowired
	CarsService carService;
	
	@Autowired
    private WebApplicationContext context;
	
    @Before
    public void setup(){
        mockMvc = MockMvcBuilders
          .webAppContextSetup(context)
          .build();
    }
    
    
	@Test
	public void TestAddCar() throws Exception{
		
		Cars car=new Cars();
		car.setId(50);
		car.setName_car("Audi");
		car.setPrice(13000);
		car.setCount_seat(4);
		
		
		ObjectMapper mapper=new ObjectMapper();
		
		MvcResult result = mockMvc.perform(post("/addCar")
				.with(SecurityMockMvcRequestPostProcessors.user("admin").password("admin"))
				.content(mapper.writeValueAsString(car))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andReturn();
		
		
		System.out.println("Header is:" + result.getHandler());
		System.out.println("The Response is : " + result.getModelAndView().getViewName());
		System.out.println("The Status Add is : " + result.getResponse().getStatus());
		
	}
	
	
	
	@Test
	public void TestSaveCar() throws Exception{
		
		Cars car=new Cars(40,"Honda",11000,false,new Date(),15000,"Sami",4,1.5f,0l);
		
		
		ObjectMapper mapper=new ObjectMapper();
		
		MvcResult result = mockMvc.perform(post("/saveCar?version=0")
				.with(SecurityMockMvcRequestPostProcessors.user("admin").password("admin"))
				.content(mapper.writeValueAsString(car))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andReturn();
		
		
		System.out.println("Header is:" + result.getHandler());
		System.out.println("The Response is : " + result.getModelAndView().getViewName());
		System.out.println("The Status Sale is : " + result.getResponse().getStatus());
		
	}
	
	
	@Test
	@WithUserDetails("admin")
	public void TestUpdateCar() throws Exception {
		Cars car=new Cars(40,"Honda",11000,false,new Date(),15000,"Sami",4,1.5f,0l);
		
		given(carRepository.findCarsByid(40)).willReturn(car);
		
		
		
		Cars res=carService.getCarById(40);
		
		assertThat(res.getName_car()).isEqualTo(car.getName_car());
		
		res.setCount_seat(6);
		
		carService.updateCar(car);
		
		assertThat(res.getCount_seat()).isEqualTo(6);
		
		
		MvcResult result = mockMvc.perform(post("/updateCar")
				.with(SecurityMockMvcRequestPostProcessors.user("admin").password("admin"))
				.param("id", "40")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andReturn();
		
		
		System.out.println("Header is:" + result.getHandler());
		System.out.println("The Response is : " + result.getModelAndView().getViewName());
		System.out.println("The Status update is : " + result.getResponse().getStatus());
		
	}
	
	
	@Test
	@WithUserDetails("admin")
	public void TestDeleteCar() throws Exception {
		Cars car1=new Cars(40,"Honda",11000,false,new Date(),15000,"Sami",4,1.5f,0l);
		Cars car2=new Cars(41,"Audi",12000,false,new Date(),16000,"Tamer",4,1.5f,0l);
		
		List<Cars> list=new ArrayList<Cars>();
		//list.add(car1);
		list.add(car2); 	
		
		given(carRepository.findCarsByid(40)).willReturn(car1);
		
		Cars res=carService.getCarById(40);
		
		assertThat(res.getName_car()).isEqualTo(car1.getName_car());
		
		carService.deleteCar(40);
		
		given(carRepository.findAll()).willReturn(list);
		
		assertThat(carService.getAllCars())
		.hasSize(1)
		.contains(car2);
		
		
		MvcResult result = mockMvc.perform(post("/deleteCar")
				.with(SecurityMockMvcRequestPostProcessors.user("admin").password("admin"))
				.param("id", "40")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andReturn();
		
		
		System.out.println("Header is:" + result.getHandler());
		System.out.println("The Response is : " + result.getModelAndView().getViewName());
		System.out.println("The Status delete is : " + result.getResponse().getStatus());
	}
	

}
