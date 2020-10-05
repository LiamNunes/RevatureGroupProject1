package com.revature.models;

public class Car {
	//instance variables
	private int id;
	private String make, model;
	private int year;
	private String plate;
	private Resident owner;
	
	public Car (int id, String make, String model, int year, String plate, Resident owner) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.plate = plate;
		this.owner = owner;
	}
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public Resident getOwner() {
		return owner;
	}
	public void setOwner(Resident owner) {
		this.owner = owner;
	}
	
}
