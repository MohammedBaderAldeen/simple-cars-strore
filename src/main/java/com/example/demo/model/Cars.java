package com.example.demo.model;



import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;






@Entity
@Table(name = "Cars")
public class Cars {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name_car;
	private int price;
	private boolean sold;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date sale_date;
	private float sale_price;
	private String buyer_name;
	private int count_seat;
	private float earning;
	private long version;
	
	
	public Cars() {
		super();
		this.version=0;
	}
	

	public Cars(int id, String name_car, int price, boolean sold, Date sale_date, float sale_price, String buyer_name,
			int count_seat, float earning,long version) {
		super();
		this.id = id;
		this.name_car = name_car;
		this.price = price;
		this.sold = sold;
		this.sale_date = sale_date;
		this.sale_price = sale_price;
		this.buyer_name = buyer_name;
		this.count_seat = count_seat;
		this.earning = earning;
		this.version=version;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName_car() {
		return name_car;
	}

	public void setName_car(String name_car) {
		this.name_car = name_car;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	public boolean isSold() {
		return sold;
	}

	public void setSold(boolean sold) {
		this.sold = sold;
	}


	public Date getSale_date() {
		return sale_date;
	}




	public void setSale_date(Date sale_date) {
		this.sale_date = sale_date;
	}




	public float getSale_price() {
		return sale_price;
	}




	public void setSale_price(float sale_price) {
		this.sale_price = sale_price;
	}




	public String getBuyer_name() {
		return buyer_name;
	}




	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}




	public int getCount_seat() {
		return count_seat;
	}



	public void setCount_seat(int count_seat) {
		this.count_seat = count_seat;
	}




	public float getEarning() {
		return earning;
	}




	public void setEarning(float earning) {
		this.earning = earning;
	}

	public long getVersion() {
		return version;
	}


	public void setVersion(long version) {
		this.version = version;
	}
	
	
	
	
	


}
