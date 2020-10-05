package com.revature.models;

import java.util.List;

public class Resident {
	//instance variables
	private int id;
	private String firstName, LastName;
	private Apartment apartment;
	private List<Car> cars;
	
	
	
	public Resident(int id, String firstName, String lastName, Apartment apartment) {
		super();
		this.id = id;
		this.firstName = firstName;
		LastName = lastName;
		this.apartment = apartment;
		this.cars = null;
	}
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public Apartment getApartment() {
		return apartment;
	}
	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}
	public List<Car> getCars() {
		return cars;
	}
	public void addCar(Car car) {
		this.cars.add(car);
	}
	public void dropCars() {
		this.cars = null;
	}
}
