import javax.swing.JPanel;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat; 
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;


import javax.swing.JComboBox;

import controllers.StudentController;
import models.Student;

import models.Book;
import controllers.BookController;

import models.BookCategory;
import controllers.CategoryController;
import controllers.RentingBookController;

import javax.swing.JScrollPane;
//import 

public class MuonSach extends JPanel {
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTable table_1;
	
	private int cateId;
	private int bookId;
	
	public StudentController studentController = new StudentController();
	public BookController bookController = new BookController();
	public CategoryController categoryController = new CategoryController();
	public RentingBookController rentingBookController = new RentingBookController();
	/**
	 * Create the panel.
	 */
	public MuonSach(int staffId) {
		System.out.print(staffId);
		setBorder(null);
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(100, 100, 714, 521);
		
		JLabel lblNewLabel = new JLabel("L\u00E2\u0323p phi\u00EA\u0301u m\u01B0\u01A1\u0323n sa\u0301ch");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(242, 10, 230, 42);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn \u0111\u1ED9c gia\u0309:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 94, 153, 34);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Khoa:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 139, 153, 34);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Ha\u0323n tra\u0309:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(10, 183, 153, 34);
		add(lblNewLabel_1_1_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(137, 103, 176, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(137, 148, 176, 20);
		add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(137, 192, 176, 20);
		add(textField_3);
		
		JButton btnNewButton_1 = new JButton("Th\u00EAm");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBackground(new Color(61, 157, 245));
		btnNewButton_1.setBounds(513, 157, 96, 34);
		add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Danh sách sách mượn");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(10, 248, 186, 42);
		add(lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 291, 694, 134);
		add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"STT","Mã mượn sách", "Tên sách", "Ngày hạn trả"
			}
		));
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(200);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(150);
		
		
		JLabel lblNewLabel_1_3 = new JLabel("M\u00E3 \u0111\u1ED9c gia\u0309:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(10, 50, 153, 34);
		add(lblNewLabel_1_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected_item = Integer.parseInt(comboBox.getSelectedItem().toString());
				//System.out.print(selected_item);
				Student st = StudentController.findById(selected_item);
				textField.setText(st.getStudentName());
				textField_1.setText(st.getMajor());
				//textField_2.setText(st.getContactNumber());
				rentingBookController.loadRentingBooksByStudentTable(table_1, selected_item);
			}
		});
		comboBox.setBounds(137, 58, 59, 21);
		add(comboBox);
		
		
		List<BookCategory> categories = categoryController.findAll();
		JComboBox<BookCategory> comboBox_1 = new JComboBox<BookCategory>();
		comboBox_1.setModel(new DefaultComboBoxModel<BookCategory>(categories.toArray(new BookCategory[0])));
		comboBox_1.setBounds(494, 59, 176, 21);
		add(comboBox_1);
		comboBox_1.setSelectedIndex(-1);
		
		
		
		JComboBox<Book> comboBox_1_1 = new JComboBox<Book>();
		
		//comboBox_1_1.setSelectedIndex(-1);
		comboBox_1_1.setBounds(494, 103, 176, 21);
		add(comboBox_1_1);
		
		// event handler Category comboBox 
		comboBox_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<BookCategory> cmbCombo = (JComboBox<BookCategory>) e.getSource();

                // The selected element is a "Test" instance, just cast it to the correct type
                BookCategory cate = (BookCategory) cmbCombo.getSelectedItem();

                // Manipulate the selected object at will
                cateId = cate.getId();
                List<Book> books = bookController.findByCate(cateId);
        		comboBox_1_1.setModel(new DefaultComboBoxModel<Book>(books.toArray(new Book[0])));
        		bookId = books.size() !=0 ? books.get(0).getId() : -1;
        		System.out.println(bookId);
            }
        });
		//end event
		
		//event handler Book comboBox
		comboBox_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<Book> cmbCombo = (JComboBox<Book>) e.getSource();

                // The selected element is a "Test" instance, just cast it to the correct type
                Book book = (Book) cmbCombo.getSelectedItem();

                // Manipulate the selected object at will
                bookId = book.getId();
                System.out.println(bookId);
           
            }
        });
		//end event
		//event button Them
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Date ngaytra = Date.valueOf(textField_3.getText());
					int studentId = (int)comboBox.getSelectedItem();
					System.out.println(staffId);
					if(rentingBookController.checkNumberRetingBook(studentId)) {
						if(rentingBookController.add(studentId,staffId,bookId, ngaytra) == 1)
							JOptionPane.showMessageDialog(null, "Thành công");
						else {
							JOptionPane.showMessageDialog(null, "Không thành công");
					}}
					else {
						JOptionPane.showMessageDialog(null, "Không thể cho mượn thêm sách");
					}
					
				} catch (Exception ex){
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "Không thành công");
				}
				int selected_item = Integer.parseInt(comboBox.getSelectedItem().toString());
				rentingBookController.loadRentingBooksByStudentTable(table_1, selected_item);
				
			}
		});
		
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Danh mục:");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_1.setBounds(395, 50, 77, 34);
		add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Tên sách:");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_1_1.setBounds(395, 94, 77, 34);
		add(lblNewLabel_1_3_1_1);
		
//		int studentId = Integer.parseInt(comboBox.getSelectedItem().toString());
//		if(studentId
		//rentingBookController.loadRentingBooksByStudentTable(table_1, Integer.parseInt(comboBox.getSelectedItem().toString()));
		
		List<Student> listStudents = studentController.findAll();
		for(int i=0;i<listStudents.size();i++) {
			comboBox.addItem(listStudents.get(i).getId());
		}
		//comboBox.
		
		//List<Book> listBooks = bookController.findAll();
	
		
	}
}
