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
import models.Shelves;

public class ShelfController {
	static Connection conn = DBConnection.connect();
	public static String tableName = "shelves";
	
	public static void loadStaffTable(JTable UITable)
	{
		String sql = "SELECT * FROM shelves";
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
               model.addRow(row);
            }
            
           UITable.setModel(model);
           model.fireTableDataChanged();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<Shelves> findAll()
	{
		List<Shelves> staffs =  new ArrayList<Shelves>();
		
		String sql = "SELECT * FROM shelves";
		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next())
			{	
				Shelves staff = new Shelves(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3)
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
	
	public static boolean addShelf(String shelf, String floor) {
		String sql = "INSERT INTO shelves (shelf, floor) values (" + shelf + " , "+ floor + ")";
		
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
	
	public static boolean delete(int id) 
	{
		String sql = "DELETE FROM shelves WHERE id = " + id;
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return false;
		
		
	}
	
	public static boolean update(int id, String shelf, String floor)
	{
		String sql = "UPDATE shelves SET shelf = '" + shelf + "' ,floor = '" + floor + "' WHERE id = " + id;
		
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
