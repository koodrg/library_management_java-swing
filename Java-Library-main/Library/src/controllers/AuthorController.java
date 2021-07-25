package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import models.DBConnection;
import models.Book;


public class AuthorController {
	static Connection conn = DBConnection.connect();
	
	public static int getAuthorId(String author_name) {
		String sql = "SELECT id FROM authors WHERE author_name = '"+ author_name +"'";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int id = rs.getInt(1);
				return id;
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public static int addAuthor(String authorName) {
		String sql = "INSERT INTO authors (author_name, personal_website, description) values ('" + authorName + "','','')";
		
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
		
//		System.out.println(getAuthorId(authorName));
//		return getAuthorId(authorName);
	}
	
	public static String getAuthorNameById(String id) {
		String sql = "SELECT author_name FROM authors WHERE id = "+ id ;
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				String name = rs.getString(1);
				System.out.println("ten tac gia: "+ name);
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
}
