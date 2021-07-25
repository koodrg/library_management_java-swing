package controllers;

import java.sql.Connection;
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
import models.Staff;

public class StaffController {
	static Connection conn = DBConnection.connect();
	public static String tableName = "staffs";
	
	public static void loadStaffTable(JTable UITable)
	{
		String sql = "SELECT * FROM staffs";
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();

			int columnCount = md.getColumnCount();
			
            String[] cols = new String[columnCount];
            DefaultTableModel model = (DefaultTableModel) UITable.getModel();

            model.setRowCount(0);
            while (rs.next())
            {
               
               Object[] row = new Object[columnCount];
               row[0]=  rs.getInt(1);
               row[1] = rs.getString(2);
               row[2] = rs.getString(3);
               row[3] = rs.getString(6);
               row[4] = rs.getInt(5) ==1 ? "Quản lý" : "Nhân viên";
               model.addRow(row);
            }
            
           UITable.setModel(model);
           model.fireTableDataChanged();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<Staff> findAll()
	{
		List<Staff> staffs =  new ArrayList<Staff>();
		
		String sql = "SELECT * FROM staffs";
		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next())
			{	
				Staff staff = new Staff(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getString(6)
						);
				
				staffs.add(staff);
				
			}
			
			stmt.close();

			System.out.println(staffs.get(1));
			return staffs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static boolean delete(int id) 
	{
		String sql = "DELETE FROM staffs WHERE id = " + id;
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//			System.out.println();
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return false;
		
		
	}
	
	public static boolean update(int id, String name, String email, String description, int isadmin)
	{
		String sql = "UPDATE staffs SET staff_name = '" + name + "' ,email = '" + email+ 
				"' ,is_admin = " +isadmin + ",description = '" + description + "' WHERE id = " + id;
		
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
	
	public static void main(String[] args)
	{
		System.out.println(findAll());
	}
}
