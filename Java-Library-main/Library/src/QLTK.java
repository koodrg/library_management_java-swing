import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controllers.StaffController;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import models.Staff;
import controllers.StaffController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class QLTK extends JPanel {
	private JTable tbl_data;
	//JFrame children;
	private List<String> staff;
	private JTextField txtMk;
	private JTextField txtEmail;
	private JTextField txtGhiChu;
	private JTextField txtName;
	
	private int id=-1;
	private int isadmin;
	
	public int totalAttributeOfClass = 10;
	public StaffController staffController;

	final boolean VIEW_ACION_TYPE = true;
	final boolean UPDATE_ACTION_TYPE = false;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public QLTK() {
		setLayout(null);
		setBounds(100, 100, 714, 521);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(10, 25, 694, 486);
		add(panel_4);
		
		JButton btnNewButton = new JButton("S\u1EEDa");
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(392, 196, 100, 30);
		panel_4.add(btnNewButton);
		
		JButton btnXoa = new JButton("X\u00F3a");
		
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnXoa.setBounds(536, 196, 100, 30);
		panel_4.add(btnXoa);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(146, 180, 136, 21);
		panel_4.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Quản lý", "Nhân viên"}));
		comboBox.setSelectedIndex(-1);
		
		JScrollPane scrpane_view = new JScrollPane();
		scrpane_view.setFont(new Font("Tahoma", Font.BOLD, 17));
		scrpane_view.setBorder(new LineBorder(Color.BLACK));
		scrpane_view.setBounds(10, 236, 674, 240);
		panel_4.add(scrpane_view);
		
		tbl_data = new JTable();
		tbl_data.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedRow = tbl_data.getSelectedRow();

				id = (Integer) tbl_data.getModel().getValueAt(selectedRow, 0);
				textField.setText((String) tbl_data.getModel().getValueAt(selectedRow, 1));
				textField_1.setText((String) tbl_data.getModel().getValueAt(selectedRow, 2));
				textField_2.setText((String) tbl_data.getModel().getValueAt(selectedRow, 3));
				
				String chucVu = (String) tbl_data.getModel().getValueAt(selectedRow, 4);
				//description = (String) tbl_data.getModel().getValueAt(selectedRow, 5);
				if(chucVu == "Quản lý") {
					isadmin = 0;
				}else {
					isadmin = 1;
				}	
				comboBox.setSelectedIndex(isadmin);
			}
		});
		// scrollPane.setColumnHeaderView(table);
		tbl_data.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tbl_data.setBorder(new LineBorder(new Color(0, 0, 0)));
		tbl_data.setBounds(10, 134, 694, 377);
		tbl_data.setRowHeight(50);
		tbl_data.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã", "Tên", "Email", "Mô tả", "Chức vụ"
			}
		));
		scrpane_view.setViewportView(tbl_data);
		tbl_data.getColumnModel().getColumn(0).setPreferredWidth(20);
		tbl_data.getColumnModel().getColumn(1).setPreferredWidth(200);
		tbl_data.getColumnModel().getColumn(2).setPreferredWidth(150);
		tbl_data.getColumnModel().getColumn(3).setPreferredWidth(100);
		tbl_data.getColumnModel().getColumn(4).setPreferredWidth(100);
		
		
		staffController.loadStaffTable(tbl_data);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(146, 73, 200, 25);
		panel_4.add(textField_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(146, 26, 200, 25);
		panel_4.add(textField);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(146, 125, 200, 25);
		panel_4.add(textField_2);
		
		JLabel lblNewLabel = new JLabel("Tên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(28, 26, 67, 19);
		panel_4.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(28, 75, 67, 19);
		panel_4.add(lblEmail);
		
		JLabel lblMT = new JLabel("Mô tả");
		lblMT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMT.setBounds(28, 131, 67, 19);
		panel_4.add(lblMT);
		
		JLabel lblChcV = new JLabel("Chức vụ");
		lblChcV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblChcV.setBounds(28, 180, 67, 19);
		panel_4.add(lblChcV);
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()==0)
				{
					isadmin = 1;
				}else {
					isadmin = 0;
				}
				if(id != -1) {
					//Staff staffs = new Staff(id,textField_1.getText(),textField.getText(),textField.getText(), isadmin ,textField.getText());
					//System.out.println(staffsController.update(staffs));
					if (staffController.update(id, textField.getText(), textField_1.getText(), textField_2.getText(), isadmin))
					{
						
						showMessageDialog(null, "Sửa tài khoản thành công");
						staffController.loadStaffTable(tbl_data);
					}
					else 
					{
						showMessageDialog(null, "Bạn chưa chọn tài khoản để xóa");
					}}
				else showMessageDialog(null, "Đã xảy ra lỗi");
			}
		});
		
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//staffController = new StaffController();
				if(staffController.delete(id)) {
					showMessageDialog(null, "Xóa tài khoản thành công");
					staffController.loadStaffTable(tbl_data);
				}
				else showMessageDialog(null, "Đã xảy ra lỗi");
			}
		});

	}
}