package com.revature.services;

import com.revature.interfaces.*;
import com.revature.interfaces.MoveOutServiceInter;
import com.revature.models.*;
import com.revature.DAOImpls.*;

public class MoveOutServiceImpl implements MoveOutServiceInter {

	GenericDAO residentDAO = new ResidentDAOImpl();
	GenericDAO petDAO = new PetsDAOImpl();
	GenericDAO carDAO = new CarsDAOImpl();
	
	public void deleteResident(int id) {
		Resident dr = new Resident();
		Pet dp = new Pet();
		Car dc = new Car();
		
		dr.setId(id);
		dp.setId(petDAO.get(id));
		dc.setId(carDAO.get(id));
		
		
		carDAO.delete(dc);
		petDAO.delete(dp);
		residentDAO.delete(dr);
		
		
		
		
	}

}
