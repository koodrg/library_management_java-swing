package controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.DBConnection;
import models.RentingBook;
import models.Student;

public class RentingBookController {
	static Connection conn = DBConnection.connect();
	public static String tableName = "renting_books";
	
	public static int getMaxNumberRentingBooks() {
		String sql ="SELECT value FROM parameters WHERE id = 1";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int result =-1; 
			if(rs.next()) {
				result = rs.getInt(1);
				System.out.print( " value: " + result );
			}
			return result;

		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return -1;
	}
	
	public static int getPricePerDay() {
		String sql ="SELECT value FROM parameters WHERE id =2";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int result =-1; 
			if(rs.next()) {
				result = rs.getInt(1);
				//System.out.print( " value: " + result );
			}
			return result;

		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return -1;
	}
	
	public static int getPriceToPay(int rentingID) {
		String sql ="SELECT datediff(actual_return_date, return_date) from renting_books where id = " + rentingID;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int result = 0; 
			if(rs.next()) {
				result = rs.getInt(1);
			}
			//System.out.print();
			return result*getPricePerDay();

		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return -1;
	}
	
	public static boolean checkNumberRetingBook(int studentID) {
		String sql = "select COUNT(id) from renting_books where student_id = "+ studentID + " AND actual_return_date IS NULL";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int number =-1;
			if(rs.next()) {
				number = rs.getInt(1);
				System.out.print(" so sach duoc muon: " + number);
			}
			
			rs.close();
			return number < getMaxNumberRentingBooks() ; //true: allow insert;

		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}	
	public static boolean updateActualReturnDate(int id) {
		

		String sql = "{call updateReturnRentingBook(?,?)}";
		try {
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setInt(1, id);
			stmt.registerOutParameter(2, java.sql.Types.INTEGER);
			stmt.execute();
            int result = stmt.getInt(2);
            System.out.println( " result udpate : " + result);
			stmt.close();
            if(result == 1) return true;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public static boolean loadSearchResultTable(JTable UITable, int studentId, String dateMax, String dateMin )
	{
		
		String sql = "SELECT S.student_name, R.id, S.contact_number,R.createdAt, R.return_date, St.staff_name, R.actual_return_date, B.book_name "
				+ "FROM renting_books R, students S, staffs St, books B "
				+ "WHERE B.id = R.book_id AND  R.student_id = S.id AND St.id = R.staff_id";
			
		if( checkRegexDate(dateMax) ) {
			sql = sql + " AND R.return_date <='" + dateMax + "' ";
		}
		if(checkRegexDate(dateMin)) {
			sql = sql + " AND R.return_date >='" + dateMin + "' "; 
		}
		if(studentId !=-1) {
			sql = sql + " AND S.id = "+ studentId;
		}
			
		try {
			Statement stmt = conn.createStatement();
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();

			int columnCount = md.getColumnCount() + 1;
			
            String[] cols = new String[columnCount];
            DefaultTableModel model = (DefaultTableModel) UITable.getModel();
            int index = 0;
            model.setRowCount(0);
            while (rs.next())
            {
               index++;
               Object[] row = new Object[columnCount];
               row[0] = index;
               row[1] = rs.getString(1);
               row[2] = rs.getInt(2);
               row[3] = rs.getString(3);
               row[4] = rs.getDate(4);
               row[5] = rs.getDate(5);
               row[6] = rs.getString(6);
               if(rs.getDate(7) == null) {
            	   row[7] = "Chưa trả sách";
               } else {
            	   row[7] = rs.getDate(5).compareTo(rs.getDate(7)) > 0?"Đã trả sách":"Trả quá hạn";
               }
               row[8] = rs.getString(8);
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
	
	public int add(int studentId, int staffId, int bookId, Date returnDay) { 
		String sql ="{call insertRentingBook(?,?,?,?,?)}";
		try {
//			PreparedStatement stmt = conn.prepareStatement("INSERT INTO renting_books (book_id,staff_id,student_id, return_date,createdAt,updatedAt) VALUES(?,?,?,?,?,?)");
//			stmt.setInt(1, bookId);
//			stmt.setInt(2, staffId);
//			stmt.setInt(3, studentId);
//			stmt.setDate(4, returnDay );
//			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
//			stmt.setTimestamp(5, date);
//			stmt.setTimestamp(6, date);
//			int row = stmt.executeUpdate();
			//System.out.print(row);
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setInt(1, bookId);
			stmt.setInt(2, staffId);
			stmt.setInt(3, studentId);
			stmt.setDate(4, returnDay);
			stmt.registerOutParameter(5, java.sql.Types.INTEGER);
			stmt.execute();
            int result = stmt.getInt(5);
            System.out.println( " result: " + result);
			stmt.close();
            return result;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}
	
	public void loadRentingBooksByStudentTable(JTable RBTable, int studentId ) {
		//System.out.println(studentId);
		String sql = "SELECT  rb.id,b.book_name, rb.return_date from books as b, students as s, renting_books as rb where b.id=rb.book_id and rb.student_id=s.id and s.id=" + studentId + " AND rb.actual_return_date IS NULL";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();

			int columnCount = md.getColumnCount();
			
            String[] cols = new String[columnCount];
            DefaultTableModel model = (DefaultTableModel) RBTable.getModel();
            model.setRowCount(0);
            int index = 0;
            while (rs.next())
            {
               index++;
               Object[] row = new Object[4];
               row[0]=index;
               row[1]=rs.getInt(1);
               //System.out.println(rs.getInt(1));
               row[2]=rs.getString(2);
               //System.out.println(rs.getString(2));
               row[3]=rs.getDate(3);
               model.addRow(row);
            }
            
           RBTable.setModel(model);
           model.fireTableDataChanged();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void loadUITable(JTable UITable)
	{
		String sql = "SELECT S.student_name, R.id, S.contact_number,R.createdAt, R.return_date, St.staff_name, R.actual_return_date, B.book_name FROM renting_books R, students S, staffs St, books B WHERE B.id = R.book_id AND  R.student_id = S.id AND St.id = R.staff_id";
		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();

			int columnCount = md.getColumnCount()+1;
			
            String[] cols = new String[columnCount];
            DefaultTableModel model = (DefaultTableModel) UITable.getModel();
            model.setRowCount(0);
            int index = 0;
            while (rs.next())
            {
               index++;
               Object[] row = new Object[columnCount];
               row[0] = index;
               row[1] = rs.getString(1);
               row[2] = rs.getInt(2);
               row[3] = rs.getString(3);
               row[4] = rs.getDate(4);
               row[5] = rs.getDate(5);
               row[6] = rs.getString(6);
               if(rs.getDate(7) == null) {
            	   row[7] = "Chưa trả sách";
               } else {
            	   row[7] = rs.getDate(5).compareTo(rs.getDate(7)) > 0?"Đã trả sách":"Trả quá hạn";
               }
               row[8] = rs.getString(8);
               model.addRow(row);
            }
            
           UITable.setModel(model);
           model.fireTableDataChanged();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean delete(int id) 
	{
		String sql ="{call deleteRentingBook(?)}";
		try {
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}
	
	public static boolean update(RentingBook rentingbook)
	{
		String sql = "UPDATE SET book_id = ? , staff_id = ?, student_id = ?"
				+ "actual_return_date = ?, return_date = ?";
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(2, rentingbook.getBookId());
			ps.setInt(3,rentingbook.getStaffId());
			ps.setInt(3, rentingbook.getStudentId());
			ps.setDate(4, rentingbook.getActualReturnDate());
			ps.setDate(5, rentingbook.getReturnDate());
			
			return true;
		
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
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static boolean checkRegexDate(String date) {
		Pattern pattern = Pattern.compile("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$");
		Matcher matcher = pattern.matcher(date);
		return matcher.find();
	}
	
	public static int rentInMonth(int month) {
		String sql = "SELECT COUNT(id) FROM renting_books WHERE createdAt LIKE '%"+month+"____________'";
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next())
			{
				int count = rs.getInt(1);
				return count;
			}
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public static int payInMonth(int month) {
		String sql = "SELECT COUNT(id) FROM renting_books WHERE actual_return_date LIKE '%"+month+"____________'";
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next())
			{
				System.out.println(rs.getInt(1));
				int count = rs.getInt(1);
				return count;
			}
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void main(String[] args)
	{
		System.out.println(RentingBookController.findOne(145));
	}
}

