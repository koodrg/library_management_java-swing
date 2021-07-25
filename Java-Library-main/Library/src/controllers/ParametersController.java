package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Parameters;
import models.Book;
import models.DBConnection;

public class ParametersController {
static Connection conn = DBConnection.connect();
	
	public List<Parameters> findAll() {
		List<Parameters> parameters = new ArrayList<Parameters>();
		String sql = "SELECT *  FROM  parameters;" ;
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next())
			{
				Parameters parameter = new Parameters(
					rs.getInt(1),
					rs.getString(2),
					rs.getInt(3));
				parameters.add(parameter);
			}
			rs.close();
			System.out.println(parameters);
			return parameters;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Parameters> findById(int id) {
		List<Parameters> parameters = new ArrayList<Parameters>();
		String sql = "SELECT *  FROM parameters WHERE id =" + id ;
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next())
			{
				Parameters parameter = new Parameters(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3));
					parameters.add(parameter);
			}
			rs.close();
			return parameters;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static boolean editParameter(int id, String value ) {
		String sql = "UPDATE parameters SET value = '" + value + "' WHERE id = " + id;
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			
			return ps.executeUpdate() > 0;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
