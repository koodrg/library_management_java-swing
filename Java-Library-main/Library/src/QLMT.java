import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import controllers.RentingBookController;
import controllers.StudentController;
import models.Student;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QLMT extends JPanel {
	private Image img_search = new ImageIcon(QLMT.class.getResource("icon/search.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	private Image img_edit_property = new ImageIcon(QLMT.class.getResource("icon/edit-property.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	private Image img_trash = new ImageIcon(QLMT.class.getResource("icon/trash.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	private JTextField txtFrom;
	private JTextField txtTo;
	private JTable table;
	private int idMuon = -1;
	private int idDocGia = 1;
	private StudentController studentController = new StudentController();
	private RentingBookController rentingBookController = new RentingBookController();

	/**
	 * Create the panel.
	 */
	public QLMT() {
		
		
		setBorder(null);
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(100, 100, 714, 521);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setBounds(93, 29, 97, 32);
		add(comboBox);
		
		
		txtFrom = new JTextField();
		txtFrom.setBorder(new LineBorder(Color.BLACK));
		txtFrom.setForeground(Color.GRAY);
		txtFrom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtFrom.setText("T\u1EEB ng\u00E0y");
		txtFrom.setHorizontalAlignment(SwingConstants.LEFT);
		txtFrom.setBounds(200, 29, 130, 32);
		add(txtFrom);
		txtFrom.setColumns(10);
		txtFrom.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseClicked(java.awt.event.MouseEvent evt) {
	        	if(txtFrom.getText().equals("Từ ngày")) {
	        		txtFrom.setText("");
	        	}
	        }
	 });
		
		txtTo = new JTextField();
		txtTo.setBorder(new LineBorder(Color.BLACK));
		txtTo.setForeground(Color.GRAY);
		txtTo.setText("\u0110\u1EBFn ng\u00E0y");
		txtTo.setHorizontalAlignment(SwingConstants.LEFT);
		txtTo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTo.setColumns(10);
		txtTo.setBounds(340, 29, 129, 32);
		add(txtTo);
		txtTo.addMouseListener(new java.awt.event.MouseAdapter() {
		        public void mouseClicked(java.awt.event.MouseEvent evt) {
		        	if(txtTo.getText().equals("Đến ngày") ) {
		        		txtTo.setText("");
		        	}
		 
		        }
		 });
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBackground(new Color(61, 157, 245));
		panel1.setBounds(536, 29, 94, 32);
		add(panel1);
		
		JLabel lblIconSearch = new JLabel("");
		lblIconSearch.setBounds(0, 1, 26, 30);
		panel1.add(lblIconSearch);
		lblIconSearch.setIcon(new ImageIcon(img_search));
		
		JButton btnTmKim = new JButton("Tìm kiếm");
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dateMin = txtFrom.getText();
				String dateMax = txtTo.getText();
				System.out.print(dateMin + "  " +  dateMax);
				if(rentingBookController.loadSearchResultTable(table, idDocGia, dateMax, dateMin)) {
			
				} else showMessageDialog(null, "Kiểm tra lại ngày nhập");
			}
		});
		btnTmKim.setForeground(Color.WHITE);
		btnTmKim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTmKim.setBorder(null);
		btnTmKim.setBackground(new Color(61, 157, 245));
		btnTmKim.setBounds(26, 1, 68, 30);
		panel1.add(btnTmKim);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setBounds(10, 110, 694, 187);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Tên độc giả", "Mã mượn sách", "SDT", "Ngày mượn", "Ngày hạn trả", "Tên nhân viên", "Ngày trả", "Tên sách" 
			}
		));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				idMuon =  Integer.parseInt(table.getModel().getValueAt(selectedRow, 2).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(61, 157, 245));
		panel_1_1.setBounds(469, 371, 94, 30);
		add(panel_1_1);
		
		JLabel lblIconSearch_1_1 = new JLabel("");
		lblIconSearch_1_1.setBounds(0, 1, 26, 30);
		panel_1_1.add(lblIconSearch_1_1);
		lblIconSearch_1_1.setIcon(new ImageIcon(img_edit_property));
		
		JButton btnSa = new JButton("Trả sách");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(
                        null, 
                        "Bạn có chắc muốn sửa không?", 
                        "Alert", 
                        JOptionPane.YES_NO_OPTION);
	            if(n == JOptionPane.YES_OPTION) {
					if(rentingBookController.updateActualReturnDate(idMuon)) {
						if(rentingBookController.getPriceToPay(idMuon) > 0)
							JOptionPane.showMessageDialog(null,"Trả quá hạn, số tiền nộp phạt là: "+ rentingBookController.getPriceToPay(idMuon));
						else 
							JOptionPane.showMessageDialog(null,"Trả sách thành công");
						rentingBookController.loadUITable(table); 
					} else {
						JOptionPane.showMessageDialog(null,"Trả sách không thành công");
					}
	            }
			}
		});
		btnSa.setForeground(Color.WHITE);
		btnSa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSa.setBorder(null);
		btnSa.setBackground(new Color(61, 157, 245));
		btnSa.setBounds(26, 1, 68, 30);
		panel_1_1.add(btnSa);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(61, 157, 245));
		panel_1_1_1.setBounds(575, 371, 94, 30);
		add(panel_1_1_1);
		
		JLabel lblIconSearch_1_1_1 = new JLabel("");
		lblIconSearch_1_1_1.setBounds(0, 1, 26, 30);
		panel_1_1_1.add(lblIconSearch_1_1_1);
		lblIconSearch_1_1_1.setIcon(new ImageIcon(img_trash));
		
		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rentingBookController.delete(idMuon)) {
					showMessageDialog(null, "Xóa sách mượn thành công");
					rentingBookController.loadUITable(table);
				}
				else showMessageDialog(null, "Xóa sách mượn không thành công");
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(new Color(61, 157, 245));
		btnNewButton_2.setBounds(26, 1, 68, 30);
		panel_1_1_1.add(btnNewButton_2);
		
		rentingBookController.loadUITable(table);
		
		JLabel lblNewLabel = new JLabel("Mã độc giả");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(0, 29, 83, 32);
		add(lblNewLabel);
		
		
		comboBox.setModel(new DefaultComboBoxModel(getIdReaders()));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idDocGia = Integer.parseInt(comboBox.getSelectedItem().toString());
				System.out.print(idDocGia);
				//rentingBookController.loadRentingBooksByStudentTable(table_1, selected_item);
			}
		});
		//comboBox.setSelectedIndex();
	}
	
	
	private Object[] getIdReaders() {
		// TODO Auto-generated method stub
		List<Student> listReaders = studentController.findAll();
		Object[] idArr = new Object[listReaders.size()];

		for (int i = 0; i < listReaders.size(); i++) {
			idArr[i] = listReaders.get(i).getId();

		}

		return idArr;
	}
}
