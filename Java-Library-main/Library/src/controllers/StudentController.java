package controllers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.DBConnection;
import models.Student;

public class StudentController {
	static Connection conn = DBConnection.connect();
	public static String tableName = "students";
	
	public List<Student> findAll()
	{
		List<Student> students =  new ArrayList<Student>();
		
		String sql = "SELECT * FROM students";
		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next())
			{
				Student student = new Student(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getDate(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10)
						);
				
				students.add(student);
				
			}
			
			stmt.close();
			return students;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static void loadStudentTable(JTable UITable) {
		String sql ="SELECT * FROM students";
		try {
			Statement stmt = conn.createStatement();
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();

			int columnCount = md.getColumnCount();
			
            String[] cols = new String[columnCount];
            DefaultTableModel model = (DefaultTableModel) UITable.getModel();
            int index = 0;
            model.setRowCount(0);
            while (rs.next())
            {
               index++;
               Object[] row = new Object[columnCount];
               row[0] = index;
               row[1] = rs.getInt(1); //id
               row[2] = rs.getString(2); // name
               row[3] = rs.getInt(5) ==1 ? "Nam" : "Nữ";
               row[4] = rs.getDate(6); // birthday
               row[5] = rs.getString(7); //major
               row[6] = rs.getString(8); //class_name
               row[7] = rs.getString(9);  // contact_number
            	
               model.addRow(row);
            }
           UITable.setModel(model);
           model.fireTableDataChanged();
           //return true;
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean add(String name, int gender, Date bday, String major, String class_name, String contact_number)
	{
		String sql = "INSERT INTO students(student_name, user_name, password, gender, dob, major, class_name, contact_number, createdAt, updatedAt) VALUES(?,?,?,?,?,?,?,?,?,?)" ;
		
         
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
	        
			stmt.setString(1, name);
	        stmt.setString(2, "");
	        stmt.setString(3, "");
	        stmt.setInt(4, gender);
	        stmt.setDate(5, bday);
	        stmt.setString(6, major);
	        stmt.setString(7, class_name);
	        stmt.setString(8, contact_number);
	        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			stmt.setTimestamp(9, date);
			stmt.setTimestamp(10, date);
			
			
	        
			return stmt.executeUpdate() > 0;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public boolean delete(int id) 
	{
		String sql = "DELETE FROM " + tableName + " WHERE id = ?";
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			System.out.println();
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return false;
		
		
	}
	
	public boolean update(Student student)
	{
		String sql = "UPDATE students SET dob = '" + student.getDob() + "', student_name = '" + student.getStudentName() + "' ,gender = " + student.getGender()
				+ ",class_name = '" + student.getClassName() + 
				"' ,contact_number = '" + student.getContactNumber() + 
				"' ,major = '" + student.getMajor() + "' WHERE id = " + student.getId();
		
		System.out.println(sql);
		
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
	
	public static Student findOne(int id)
	{
		String sql = "SELECT S.* FROM renting_books R, students S WHERE R.student_id = S.id AND S.id = " + id;
		
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next())
			{
				
				Student student = new Student(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getDate(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10)
						);
				
				return student;
			}
			rs.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Student findById(int id)
	{
		String sql = "SELECT * FROM  students  WHERE id=" + id;
		//System.out.print();
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next())
			{
				
				Student student = new Student(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getDate(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10)
						);
				
				return student;
			}
			rs.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	

	
	public static boolean findBySearch(JTable UITable,String textSearch)
	{
		List<Student> students =  new ArrayList<Student>();
		
		String sql = "SELECT * FROM students WHERE student_name LIKE '%"  + textSearch + "%'";
		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			ResultSetMetaData md = rs.getMetaData();

			int columnCount = md.getColumnCount();
			
            String[] cols = new String[columnCount];
            DefaultTableModel model = (DefaultTableModel) UITable.getModel();
            int index = 0;
            model.setRowCount(0);
            while (rs.next())
            {
               index++;
               Object[] row = new Object[columnCount];
               row[0] = index;
               row[1] = rs.getInt(1); //id
               row[2] = rs.getString(2); // name
               row[3] = rs.getInt(5) ==1 ? "Nam" : "Nữ";
               row[4] = rs.getDate(6); // birthday
               row[5] = rs.getString(7); //major
               row[6] = rs.getString(8); //class_name
               row[7] = rs.getString(9);  // contact_number
            	
               model.addRow(row);
            }
           UITable.setModel(model);
           model.fireTableDataChanged();
           return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		System.out.println(RentingBookController.findOne(145));
	}
}

