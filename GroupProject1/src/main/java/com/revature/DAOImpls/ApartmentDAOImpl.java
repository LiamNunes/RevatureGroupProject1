package com.revature.DAOImpls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.interfaces.GenericDAO;
import com.revature.models.Apartment;
import com.revature.services.ConnectionService;

public class ApartmentDAOImpl implements GenericDAO<Apartment> {
	Connection connection;
	
	
	public void ApartmentDAOImpl() {
		this.connection = ConnectionService.getConnection();
		
	}
	
	public void creat(Apartment t) {
		// TODO Auto-generated method stub
		
	}

	public Apartment get(int id) {
		// TODO Auto-generated method stub
		Apartment apt = null;
		try {
			PreparedStatement apartmentStatement = connection.prepareStatement("SELECT * FROM apartments WHERE id = ?;");
			apartmentStatement.setInt(1, id);
			
			ResultSet apartmentRs = apartmentStatement.executeQuery();
			
			if (apartmentRs.next()) {
				apt = new Apartment();
				apt.setId(apartmentRs.getInt("id"));
				apt.setBuildingLetter((char) apartmentRs.getInt("building_letter"));
				apt.setRoomNumber(apartmentRs.getInt("room_number"));
				apt.setMonthly_rent(apartmentRs.getFloat("moonthly_rent"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return apt;
	}

	public void update(Apartment t) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Apartment t) {
		// TODO Auto-generated method stub
		
	}
}
