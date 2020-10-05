package com.revature.DAOImpls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.interfaces.GenericDAO;
import com.revature.models.*;
import com.revature.services.ConnectionService;

public class PetsDAOImpl implements GenericDAO<Pet> {
	Connection connection;
	public PetsDAOImpl() {
		connection = ConnectionService.getConnection();
	}
	
	public void creat(Pet t) {
		// TODO Auto-generated method stub
		
	}

	public Pet get(int id) {
		// TODO Auto-generated method stub
		Pet p = null;
		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM pets WHERE apartment_id = ?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				p = new Pet();
				p.setBreed(rs.getString("breed"));
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setServiceAnimal(rs.getBoolean("is_service_animal"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}

	public void update(Pet t) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Pet t) {
		// TODO Auto-generated method stub
		
	}
	

}
