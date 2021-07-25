import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import controllers.StudentController;

public class themDG extends JFrame {

	private JPanel contentPane;
	private JTextField txt_name;
	private JTextField txt_gender;
	private JTextField txt_dob;
	private JTextField txt_className;
	private JTextField txt_major;
	private JTextField txt_cellPhone;
	private JButton btn_update;
	private StudentController studentController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					themDG frame = new themDG();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public themDG(JTable table) {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
		
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
		
		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBounds(236, 41, 208, 32);
		panel.add(txt_name);
		
		txt_gender = new JTextField();
		txt_gender.setColumns(10);
		txt_gender.setBounds(236, 91, 208, 32);
		panel.add(txt_gender);
		
		txt_dob = new JTextField();
		txt_dob.setColumns(10);
		txt_dob.setBounds(236, 141, 208, 32);
		panel.add(txt_dob);
		
		txt_className = new JTextField();
		txt_className.setColumns(10);
		txt_className.setBounds(236, 191, 208, 32);
		panel.add(txt_className);
		
		txt_major = new JTextField();
		txt_major.setColumns(10);
		txt_major.setBounds(236, 241, 208, 32);
		panel.add(txt_major);
		
		txt_cellPhone = new JTextField();
		txt_cellPhone.setColumns(10);
		txt_cellPhone.setBounds(236, 291, 208, 32);
		panel.add(txt_cellPhone);
		
		btn_update = new JButton("Th\u00EAm");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date ngaysinh = Date.valueOf(txt_dob.getText());
				int gender = (txt_gender.getText()).equals("Nam") ? 1: 0;
				if(studentController.add( txt_name.getText(), gender , ngaysinh, txt_major.getText(),txt_className.getText(), txt_cellPhone.getText())) {
					JOptionPane.showMessageDialog(panel, "Thành công");
					studentController.loadStudentTable(table);
				} else JOptionPane.showMessageDialog(null,"Không thành công");
			}
		});
		btn_update.setForeground(Color.WHITE);
		btn_update.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_update.setBounds(309, 374, 124, 32);
		panel.add(btn_update);
		btn_update.setBackground(new Color(61, 157, 245));
		
		JLabel lblHTn = new JLabel("H\u1ECD t\u00EAn");
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHTn.setBounds(67, 41, 106, 24);
		panel.add(lblHTn);
		
		JLabel lblGiiTnh = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGiiTnh.setBounds(67, 99, 106, 24);
		panel.add(lblGiiTnh);
		
		JLabel lblNgySinh = new JLabel("Ng\u00E0y sinh");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNgySinh.setBounds(67, 149, 106, 24);
		panel.add(lblNgySinh);
		
		JLabel lblLp = new JLabel("L\u1EDBp");
		lblLp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLp.setBounds(67, 199, 106, 24);
		panel.add(lblLp);
		
		JLabel lblKhoa = new JLabel("Khoa");
		lblKhoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblKhoa.setBounds(67, 249, 106, 24);
		panel.add(lblKhoa);
		
		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSinThoi.setBounds(69, 299, 124, 24);
		panel.add(lblSinThoi);
		
	}

}
