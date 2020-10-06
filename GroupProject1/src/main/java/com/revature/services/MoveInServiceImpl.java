package com.revature.services;

import com.revature.DAOImpls.ApartmentDAOImpl;
import com.revature.DAOImpls.ResidentDAOImpl;
import com.revature.interfaces.GenericDAO;
import com.revature.interfaces.MoveInServiceInter;
import com.revature.models.Car;
import com.revature.models.Pet;
import com.revature.models.Resident;


public class MoveInServiceImpl implements MoveInServiceInter {
	GenericDAO residentDAO = new ResidentDAOImpl();
	GenericDAO apartmentDAO = new ApartmentDAOImpl();

	
	public void addResident(String firstname, String LastName, int apartNum) {
		Resident nr = new Resident();
		nr.setFirstName(firstname);
		nr.setLastName(LastName);
		nr.setApartment(apartmentDAO.get(apartNum));
		residentDAO.creat(nr);
		

	}

	public void addPet(String breed, String name, int apartmentID, Boolean isServiceAnimal) {
		Pet np = new Pet();
		np.setBreed(breed);
		np.setName(name);
		np.setApartment(apartmentDAO.get(apartmentID));
		np.setServiceAnimal(isServiceAnimal);
		
		
	}

	public void addCar(String make, String Model, int year, String plateNumber, int ownerId) {
		Car nc = new Car();
		nc.setMake(make);
		nc.setModel(Model);
		nc.setYear(year);
		nc.setPlate(plateNumber);
		nc.setOwner(residentDAO.get(ownerId));
		
	}

}
