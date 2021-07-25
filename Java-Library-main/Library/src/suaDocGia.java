import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controllers.StudentController;
import models.Student;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;

public class suaDocGia extends JFrame {

	private JPanel contentPane;
	private JTextField txt_id;
	private JTextField txt_name;
	private JTextField txt_gender;
	private JTextField txt_dob;
	private JTextField txt_className;
	private JTextField txt_major;
	private JTextField txt_cellPhone;
	private JButton btn_update;
	
	public StudentController studentController;
	
	public void setDisableAll()
	{
		txt_id.disable();
		txt_name.disable();
		txt_gender.disable();
		txt_dob.disable();
		txt_major.disable();
		txt_className.disable();
		txt_cellPhone.disable();
	}
	
	public void setEnalble()
	{
		txt_name.enable();
		txt_gender.enable();
		txt_dob.enable();
		txt_major.enable();
		txt_className.enable();
		txt_cellPhone.enable();
	}
	
	public void pourDataToFields(int id, String name, String gender, String className, String cellPhone, Date dob, String major)
	{
		txt_id.setText(id +"");
		txt_name.setText(name);
		txt_gender.setText(gender);
		txt_dob.setText(dob.toString());
		txt_major.setText(major);
		txt_className.setText(className);
		txt_cellPhone.setText(cellPhone);
		
		btn_update.setText(actionType?"Ok":"Chỉnh sửa");
		studentController = new StudentController();
		
		if (actionType)
		{
			setDisableAll();
		}
		else {
			txt_id.disable();
		}
	}
	
	public boolean actionType;
	
	public void isViewAction(boolean isView) 
	{
		this.actionType = isView;
	}
	// 1 is view
	// 0 is update
	
	public void setUpBtn_update(JTable table) 
	{
		if (actionType)
		{
			this.dispose();
		}
		else 
		{
			Date date= Date.valueOf(txt_dob.getText());
			String gioitinh = txt_gender.getText();
			String gender = "Nam";
			int id = 0;
			if(gioitinh.equals(gender))
			{
				id = 1;
			}
	
			// exute update query
			Student student = new Student(
					Integer.parseInt(txt_id.getText()),
					txt_name.getText(),
					"",
					"",
					id,
					date,
					txt_major.getText(),
					txt_className.getText(),
					"",
					txt_cellPhone.getText()
					);
		
			if (
					studentController.update(student)
				)
			{
				JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
				this.dispose();
				studentController.loadStudentTable(table);
			}
			else 
			{
				JOptionPane.showMessageDialog(this, "Cập nhật không thành công!");
			}
		}
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public suaDocGia(JTable table) {
		setTitle("Th\u00EAm \u0111\u1ED9c gi\u1EA3");
		setBounds(100, 100, 550, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 516, 419);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txt_id = new JTextField();
		txt_id.setBounds(225, 21, 208, 32);
		panel.add(txt_id);
		txt_id.setColumns(10);
		
		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBounds(225, 71, 208, 32);
		panel.add(txt_name);
		
		txt_gender = new JTextField();
		txt_gender.setColumns(10);
		txt_gender.setBounds(225, 121, 208, 32);
		panel.add(txt_gender);
		
		txt_dob = new JTextField();
		txt_dob.setColumns(10);
		txt_dob.setBounds(225, 171, 208, 32);
		panel.add(txt_dob);
		
		txt_className = new JTextField();
		txt_className.setColumns(10);
		txt_className.setBounds(225, 221, 208, 32);
		panel.add(txt_className);
		
		txt_major = new JTextField();
		txt_major.setColumns(10);
		txt_major.setBounds(225, 271, 208, 32);
		panel.add(txt_major);
		
		txt_cellPhone = new JTextField();
		txt_cellPhone.setColumns(10);
		txt_cellPhone.setBounds(225, 321, 208, 32);
		panel.add(txt_cellPhone);
		
		btn_update = new JButton("Ch\u1EC9nh s\u1EEDa");
		btn_update.setForeground(Color.WHITE);
		btn_update.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_update.setBounds(309, 374, 124, 32);
		panel.add(btn_update);
		btn_update.setBackground(new Color(61, 157, 245));
		
		JLabel lblNewLabel = new JLabel("M\u00E3 \u0111\u1ED9c gi\u1EA3");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(56, 21, 106, 24);
		panel.add(lblNewLabel);
		
		JLabel lblHTn = new JLabel("H\u1ECD t\u00EAn");
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHTn.setBounds(56, 71, 106, 24);
		panel.add(lblHTn);
		
		JLabel lblGiiTnh = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGiiTnh.setBounds(56, 129, 106, 24);
		panel.add(lblGiiTnh);
		
		JLabel lblNgySinh = new JLabel("Ng\u00E0y sinh");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNgySinh.setBounds(56, 171, 106, 24);
		panel.add(lblNgySinh);
		
		JLabel lblLp = new JLabel("L\u1EDBp");
		lblLp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLp.setBounds(56, 229, 106, 24);
		panel.add(lblLp);
		
		JLabel lblKhoa = new JLabel("Khoa");
		lblKhoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblKhoa.setBounds(56, 279, 106, 24);
		panel.add(lblKhoa);
		
		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSinThoi.setBounds(58, 329, 124, 24);
		panel.add(lblSinThoi);
		
		btn_update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				setUpBtn_update(table);
				
			}
		});
	}
}
