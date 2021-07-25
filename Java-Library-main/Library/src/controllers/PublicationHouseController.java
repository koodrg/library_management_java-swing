package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.DBConnection;

public class PublicationHouseController {
	static Connection conn = DBConnection.connect();
	
	public static String getHouseNameById(String id) {
		String sql = "SELECT house_name FROM publication_house WHERE id = " + id;
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				String name = rs.getString(1);
				System.out.println(" ten nxb: "+ name);
				return name;
			}
			rs.close();
			//return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public static int getPublicationHouseId(String houseName) {
		String sql = "SELECT id FROM publication_house WHERE house_name = '"+ houseName + "'";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int id = rs.getInt(1);
				System.out.println("id nxb: "+ id);
				return id;
			}
			rs.close();
			//return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public static int addPublicationHouse(String houseName) {
		String sql = "INSERT INTO publication_house(house_name, address, email, representative_name) values ('" + houseName + "','', '','' )";
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			int generatedKey = 0;
			if (rs.next()) {
			    generatedKey = rs.getInt(1);
			}
			return generatedKey;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
	}
}
