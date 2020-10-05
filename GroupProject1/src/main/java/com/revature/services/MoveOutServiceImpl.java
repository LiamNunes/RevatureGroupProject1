package com.revature.services;

import com.revature.interfaces.GenericDAO;
import com.revature.interfaces.MoveOutServiceInter;
import com.revature.models.Car;
import com.revature.models.Pet;
import com.revature.models.Resident;

public class MoveOutServiceImpl implements MoveOutServiceInter {

	GenericDAO residentDAO = new ResidentDAOImpl;
	GenericDAO petDAO = new PetDAOImpl;
	GenericDAO carDAO = new CarDAOImpl;
	
	public void deleteResident(int id) {
		Resident dr = new Resident();
		Pet dp = new Pet();
		Car dc = new Car();
		dr.setId(residentDAO.get(id));
		dp.setId(petDAO.get(id));
		dc.setId(carDAO.get(id));
		carDAO.delete(dc);
		petDAO.delete(dp);
		residentDAO.delete(dr);
		
		
		
		
	}

}
