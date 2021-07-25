package controllers;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.*;

import models.DBConnection;

public class UserController {
	static Connection conn = DBConnection.connect();
	
	public UserController() {}
	
	public boolean checkUserToLogin(String username, String password)  {
       
    	String query = "SELECT * FROM staffs WHERE staff_name = '" + username + "' AND password = '"+ password+"'"; 
    	System.out.println(username);
    	System.out.print(password);
        try {
        	//Connection conn = DBConnect.getConnection();
        	Statement stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
              return true;
            }
            //conn.close();
        }catch(Exception e) {
            System.out.println(e);;
        }
        return false;
    }
	
	public boolean addUser (String username, String email, String password, String description) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
		String query = "INSERT INTO staffs (staff_name, email, password,is_admin, description) "
				+ "VALUES('"+username+"', '"+email+"','"+password+"', 1, '"+description+"')";
		try {
			//Connection conn = DBConnect.getConnection();
			Statement stmt = conn.createStatement();
			int count = stmt.executeUpdate(query);
			
			//conn.close();
			if(count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			 System.out.println(e);
			 //conn.close();
			 return false;
		}
	}
	
	public String checkUserToSignUp(String username, String email, String password, String description) {
		
		String querycheckExistUsername = "SELECT * FROM staffs WHERE staff_name='"+ username+"' or email='" +email + "'";
		String errType1 = "EMPTY FIELD";
		String errType2 = "INVALID OR EXISTED EMAIL";
		String errType3 = "EXISTED EMAIL OR EXISTED USERNAME";
		
		if(((username.equals("")) || (email.equals("")) ) || (password.equals(""))) {
			return errType1;
		} else {
			try {
				//Connection conn = DBConnect.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(querycheckExistUsername);
				if(rs.next()) {
					return errType3;
				} else {
					if(!checkEmailValidation(email)) {
						return errType2;
					}
				}
				
				//conn.close();
			} catch (Exception ex) {
				System.out.print(ex);
			}
		}
		
		return "VALID USER";
		
	}
	
	public int findLoginUserId(String username) {
		String query = "Select id from staffs where staff_name='" + username+ "'";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			
			ResultSet rs = stmt.executeQuery();
			int id =-1;
			if(rs.next()) {
				id = rs.getInt(1);
				System.out.println("Id user: "+ id);
			}
			rs.close();
			return id;
		} catch (Exception e) {
			 System.out.println(e);
			 //conn.close();
			 return -1;
		}
	}
	
	public int findLoginUserType(String username) {
		String query = "Select is_admin from staffs where staff_name='" + username+ "'";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			
			ResultSet rs = stmt.executeQuery();
			int type = -1;
			if(rs.next()) {
				type = rs.getInt(1);
				System.out.println(" type: "+ type);
			}
			rs.close();
			return type;
		} catch (Exception e) {
			 System.out.println(e);
			 //conn.close();
		}
		
		return -1;
	}
	
	public boolean checkEmailValidation(String email){
		Pattern VALID_EMAIL_ADDRESS_REGEX =  Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
	}
}