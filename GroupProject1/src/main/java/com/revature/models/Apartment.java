package com.revature.models;

import java.util.List;

public class Apartment {
	//instance variables
	private int id;
	private char buildingLetter;
	private int roomNumber;
	private Float monthly_rent;
	private List<Resident> residents;
	private List<Pet> pets;
	
	public Apartment() {}
	public Apartment(int id, char buildingLetter, int roomNumber, Float monthly_rent) {
		this.id = id;
		this.buildingLetter= buildingLetter;
		this.roomNumber= roomNumber;
		this.monthly_rent= monthly_rent;
		this.residents = null;
		this.pets = null;
	}
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getBuildingLetter() {
		return buildingLetter;
	}
	public void setBuildingLetter(char buildingLetter) {
		this.buildingLetter = buildingLetter;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Float getMonthly_rent() {
		return monthly_rent;
	}
	public void setMonthly_rent(Float monthly_rent) {
		this.monthly_rent = monthly_rent;
	}
	public List<Resident> getResidents() {
		return residents;
	}
	public void addResident(Resident resident) {
		this.residents.add(resident);
	}
	public List<Pet> getPets() {
		return pets;
	}
	public void addPet(Pet pet) {
		this.pets.add(pet);
	}
	public void dropPets() {
		this.pets = null;
	}
	public void dropResidents() {
		this.residents = null;
	}
}
