package com.revature.DAOImpls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.interfaces.*;
import com.revature.models.*;
import com.revature.services.ConnectionService;

public class ResidentDAOImpl implements GenericDAO<Resident> {
	Connection connection; 
	
	public ResidentDAOImpl() {
		this.connection = ConnectionService.getConnection();
	}
	
	public void creat(Resident t) {
		// TODO Auto-generated method stub
		try {
			if (t.getApartment() != null) {
				PreparedStatement ps = connection.prepareStatement("SELECT * FROM apartments WHERE id = ?;");
				ps.setInt(1,  t.getApartment().getId());
				
				ResultSet rs = ps.executeQuery();
				if (!rs.next()) {
					// create apartment
				}
			}
			
			PreparedStatement ps = connection.prepareStatement("INSERT INTO residents (first_name, last_name, apartment_id) VALUES (?, ?, ?);");
			ps.setString(1, t.getFirstName());
			ps.setString(2, t.getLastName());
			ps.setInt(3, t.getApartment().getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public Resident get(int id) {
		// TODO Auto-generated method stub
		Resident r = null; 
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM residents WHERE id = ?;");
			ps.setInt(1,  id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				r = new Resident();
				r.setId(rs.getInt("id"));
				r.setFirstName(rs.getString("first_name"));
				r.setLastName(rs.getString("last_name"));
				
				// get apartment from the Apartment DAO
				GenericDAO<Apartment> apartmentDAO = new ApartmentDAOImpl();
				
				Apartment apt = apartmentDAO.get(rs.getInt("apartment_id"));
				
				// get pets from pet DAO
				GenericDAO<Pet> petDAO = new PetsDAOImpl();
				Pet p = petDAO.get(apt.getId());
				p.setApartment(apt);
				
				// get cars from car DAO
				GenericDAO<Car> carDAO = new CarsDAOImpl();
				Car c = carDAO.get(r.getId());
				c.setOwner(r);
				
				
				r.addCar(c);
				apt.addPet(p);
				r.setApartment(apt);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	public void update(Resident t) {
		// TODO Auto-generated method stub
		
		
	}

	public void delete(Resident t) {
		// TODO Auto-generated method stub
		
	}
	

}
