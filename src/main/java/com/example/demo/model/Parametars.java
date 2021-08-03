package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Parametars")
public class Parametars {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	 int count_seat;

	 float earning;

	public Parametars() {

	}

	public Parametars(int count_seat, float earning) {

		this.count_seat = count_seat;
		this.earning = earning;
	}
	
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getEarning() {
		return earning;
	}

	public void setEarning(float earning) {
		this.earning = earning;
	}

	public int getCount_seat() {
		return count_seat;
	}

	public void setCount_seat(int count_seat) {
		this.count_seat = count_seat;
	}



}
