package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.MyMessasgeQueue.MQConfig;
import com.example.demo.Service.CarsService;
import com.example.demo.Service.ParametarsService;
import com.example.demo.model.AppUser;
import com.example.demo.model.Cars;
import com.example.demo.model.MyMessage;
import com.example.demo.model.Parametars;
import com.example.demo.security.UserService;

@Controller
public class AppController {



	@Autowired
	CarsService carsService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ParametarsService parametarsService;
	
	@Autowired
	private AmqpTemplate rabbit;


	@GetMapping("/Home")
	public String Welcome() {
		return "HomePage";
	}

	@GetMapping("/AddNewCar")
	public String GetRegister(HttpServletRequest request) {
		Parametars parametars=new Parametars();
		parametars=parametarsService.getParametarsById(1);
		request.setAttribute("parametars", parametars);
		return "AddCar";
	}
	
	@GetMapping("/AddSaleCar")
	public String SaleCar() {
		return "AddBuyCar";
	}
	
	@GetMapping("/CreatAccount")
	public String CreatAccount() {
		return "CreatAccount";
	}
	
	@PostMapping("/AddUser")
	public String AddUser(@ModelAttribute AppUser newuser, BindingResult bindingResult) {
		newuser.setActive(true);
		newuser.setCreated(new Date());
		userService.addUser(newuser);
		return "HomePage";
	}

	@GetMapping("/listCar")
	public String getAllCars(HttpServletRequest request) {
		List<Cars> cars = new ArrayList<Cars>();
		cars = carsService.getAllCars();

		request.setAttribute("cars", cars);
		return "ShowCar";
	}

	@GetMapping("/listValidCar")
	public String getNotSaleCars(HttpServletRequest request) {
		List<Cars> cars = new ArrayList<Cars>();
		cars=carsService.getCarsNotSale();
		request.setAttribute("cars", cars);
		return "BuyCar";
	}
	
	@GetMapping("/listSalesCar")
	public String getSaleCars(HttpServletRequest request) {
		List<Cars> cars = new ArrayList<Cars>();
		cars=carsService.getCarsSale();
		request.setAttribute("cars", cars);
		return "ShowSalesCar";
	}

	@RequestMapping("/addCar")
	public String addCar(@ModelAttribute Cars newcar, BindingResult bindingResult, HttpServletRequest request) {
		carsService.addCar(newcar);
		return "HomePage";
	}
	

	@RequestMapping("/updateCar")
	public String UpdateCar(@RequestParam int id, HttpServletRequest request){
		Cars car = new Cars();
		car = carsService.getCarById(id);
		request.setAttribute("mycar", car);
		return "UpdateCar";
	}
	
	@RequestMapping("/updateParamtars")
	public String UpdateParamtars(@RequestParam int id, HttpServletRequest request){
		Parametars parametars = new Parametars();
		parametars = parametarsService.getParametarsById(id);
		parametarsService.deleteEvict(id);
		request.setAttribute("parametars", parametars);
		return "UpdateParametars";
	}
	
	@RequestMapping("/saveCar")
	public String saveCar(@RequestParam long version,@ModelAttribute Cars car) {
		long v=carsService.getVersion(car.getId());
		if(v==version) {
			carsService.updateCar(car);		
			return "HomePage";
		}else
			return "ErorrPage";
		
	}
	
	@RequestMapping("/saveParametars")
	public String saveParamtars(@ModelAttribute Parametars parametars, BindingResult bindingResult, HttpServletRequest request) {
		parametarsService.UpdateParametars(parametars);		
		return "HomePage";
	}
	
	@RequestMapping("/saveBuyCar")
	public String saveBuyCar(@RequestParam long version,@ModelAttribute Cars car, BindingResult bindingResult, HttpServletRequest request) {
		long v=carsService.getVersion(car.getId());
		if(v==version) {
		car.setSale_date(new Date());
		car.setSold(true);
		carsService.updateCar(car);		
		return "HomePage";
		}else
			return "ErorrPage";
	
	}

	@RequestMapping("/deleteCar")
	public String deleteCar(@RequestParam int id, HttpServletRequest request) {
		carsService.deleteCar(id);
		String delete = getAllCars(request);
		return delete;
	}
	
	@RequestMapping("/BuyCar")
	public String BuyCar(@RequestParam int id, HttpServletRequest request) {
		Cars car = new Cars();
		car = carsService.getCarById(id);
		Parametars parametars=new Parametars();
		parametars=parametarsService.getParametarsById(1);
		request.setAttribute("parametars", parametars);
		request.setAttribute("car", car);
		return "AddBuyCar";
	}
	
	
	@GetMapping("/ChoseMessageQueue")
	public String ChoseMessageQueue(HttpServletRequest request) {
		List<Cars> cars = new ArrayList<Cars>();
		cars=carsService.getCarsSale();
		request.setAttribute("cars", cars);
		return "ChoseMessage";
	}
	
	@RequestMapping("/set-MessageQueue")
	public String SetMessage(@RequestParam int id, HttpServletRequest request) {
		Cars car = new Cars();
		car = carsService.getCarById(id);
		MyMessage message=new MyMessage();
		message.setData(car);
		request.setAttribute("car", car);
		request.setAttribute("message", message);
		return "SetMessage";
	}
	
	@RequestMapping("/SendQueue")
	public String SendQueue(@RequestParam int id,@ModelAttribute MyMessage message, BindingResult bindingResult, HttpServletRequest request) {
		message.setDateMessage(new Date());
		Cars car = new Cars();
		car = carsService.getCarById(id);
		message.setData(car);
		rabbit.convertAndSend(MQConfig.Exchange, MQConfig.Routing_Key, message);
		return "HomePage";
	}
	
	
	@RequestMapping("/Paramtars")
	public String TestParamtars(){
		 parametarsService.getParametarsById(1);
		return "HomePage";
	}
	
	
	@RequestMapping("/NoParamtars")
	public String TestNoParamtars(){
		parametarsService.deleteEvict(1);
		parametarsService.getParametarsById(1);
		return "HomePage";
	}
	

@Value("${server.port:no port}")
	private String address;

	

    @GetMapping("/address")
    @ResponseBody
    public String getDeseaseServiceLocation(){
        return "the port is :"+address;
    }
	


}
