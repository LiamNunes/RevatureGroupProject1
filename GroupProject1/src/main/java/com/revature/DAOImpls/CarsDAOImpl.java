package com.revature.DAOImpls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.interfaces.GenericDAO;
import com.revature.models.Car;
import com.revature.services.ConnectionService;

public class CarsDAOImpl implements GenericDAO<Car> {
	Connection connection;
	public CarsDAOImpl() {
		this.connection = ConnectionService.getConnection();
	}
	
	public void creat(Car t) {
		// TODO Auto-generated method stub
		
	}

	public Car get(int id) {
		// TODO Auto-generated method stub
		Car c = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM cars WHERE owner_id = ?;");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				c.setId(rs.getInt("id"));
				c.setMake(rs.getString("make"));
				c.setModel(rs.getString("model"));
				c.setPlate(rs.getString("license_plate"));
				c.setYear(rs.getInt("year"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}

	public void update(Car t) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Car t) {
		// TODO Auto-generated method stub
		PreparedStatement ps = connection.prepareStatement(arg0);
	}

}
