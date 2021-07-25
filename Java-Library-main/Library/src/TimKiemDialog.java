import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controllers.BookController;
import models.Book;
import models.DBConnection;

public class TimKiemDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTable table;
	public BookController bookController;
	DefaultTableModel defaultTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TimKiemDialog dialog = new TimKiemDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	void searchBook(String keyword) {
		String sql = "SELECT authors.author_name, book_categories.book_cate_name, "
				+ "shelves.shelf,shelves.floor,book_name, books.number "
				+ "FROM books "
				+ "INNER JOIN authors ON books.author_id = authors.id "
				+ "INNER JOIN book_categories ON books.book_cate_id = book_categories.id "
				+ "INNER JOIN shelves ON books.shelf_id = shelves.id "
				+ "WHERE book_name LIKE '%" + keyword + "%'" ;
		
//		HashMap<String, String> results = new HashMap<String, String>();
		
		
		defaultTable.getDataVector().removeAllElements();
		defaultTable.fireTableDataChanged();
		
		Connection conn = DBConnection.connect();
		ArrayList<String[]> results = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		
	    while(rs.next()){         
	    	String[] result = new String[6];
	    	result[0] = rs.getString(1);
	    	result[1] = rs.getString(2);
	    	result[2] = rs.getString(3);
	    	result[3] = rs.getString(4);
	    	result[4] = rs.getString(5);
	    	result[5] = rs.getString(6);
	    	results.add(result);
	    }
	    }
	    catch(Exception e)
	    {
	        System.out.println("Error"+e);
	    }    
		
		
		Object rowData[] = new Object[7];
		for (int i = 0; i < results.size(); i++) {
		    
		    rowData[0] = results.get(i)[4];
			rowData[1] = results.get(i)[0];
			rowData[2] = results.get(i)[1];
			rowData[3] = results.get(i)[2];
			rowData[4] = results.get(i)[3];
			rowData[5] = results.get(i)[5];
			
			defaultTable.addRow(rowData);
			
		}
	}
	
	
	public TimKiemDialog() {
		setTitle("Ti\u0300m ki\u00EA\u0301m sa\u0301ch");
		setBounds(100, 100, 612, 457);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Từ khóa:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(133, 26, 68, 17);
		contentPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(222, 26, 163, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 123, 578, 287);
		contentPanel.add(scrollPane);
		
		String column[]={"Tên sách","Tác giả","Danh mục","Kệ","Tầng","Trạng thái"};
		defaultTable = new DefaultTableModel(null, column);
		JTable table =new JTable(defaultTable);table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(160);
		table.getColumnModel().getColumn(1).setPreferredWidth(112);
		table.getColumnModel().getColumn(2).setPreferredWidth(122);
		table.getColumnModel().getColumn(3).setPreferredWidth(55);
		table.getColumnModel().getColumn(4).setPreferredWidth(55);
		table.getColumnModel().getColumn(5).setPreferredWidth(70);
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_3 = new JLabel("Kết quả tìm kiếm:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 99, 133, 17);
		contentPanel.add(lblNewLabel_3);
		
		JButton btnTim = new JButton("Ti\u0300m");
		btnTim.setBounds(298, 57, 87, 23);
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchBook(textField.getText());
			}
		});
		contentPanel.add(btnTim);
	}
}
