import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controllers.UserController;

import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;

public class ManHinhDangKy extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JTextField txtEmail;
	private JTextField txtDescription;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManHinhDangKy frame = new ManHinhDangKy();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManHinhDangKy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(124, 50, 574, 403);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnNewButton = new JButton("T\u1EA1o t\u00E0i kho\u1EA3n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText();
				String email = txtEmail.getText();
				String password = String.valueOf(txtPassword.getPassword());
				String description = txtDescription.getText();
				
				UserController userControl = new UserController();
				if(userControl.checkUserToSignUp(username, email, password, description) == "EMPTY FIELD") {
					showMessageDialog(null, "Vui lÃ²ng Ä‘iá»�n cÃ¡c trÆ°á»�ng cÃ²n trá»‘ng");
				} 
				else if(userControl.checkUserToSignUp(username, email, password, description) == "INVALID OR EXISTED EMAIL")
					showMessageDialog(null, "Email khÃ´ng há»£p lá»‡");
				else if(userControl.checkUserToSignUp(username, email, password, description) == "EXISTED EMAIL OR EXISTED USERNAME") {
					showMessageDialog(null, "Email hoáº·c tÃªn tÃ i khoáº£n Ä‘Ã£ Ä‘Æ°á»£c sá»­ dá»¥ng");
				}
				else if (userControl.addUser(username, email, password, description)) {
					showMessageDialog(null, "Ä�Äƒng kÃ½ thÃ nh cÃ´ng");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(189, 250, 200, 30);
		panel.add(btnNewButton);
		
		JButton btnTrVng = new JButton("Tr\u1EDF v\u1EC1 \u0111\u0103ng nh\u1EADp");
		btnTrVng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame login = new ManHinhDangNhap();
				login.setVisible(true);
				setVisible(false);
				login.setLocationRelativeTo(null);
			}
		});
		btnTrVng.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTrVng.setBounds(189, 312, 200, 30);
		panel.add(btnTrVng);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(189, 104, 200, 30);
		panel.add(txtEmail);
		
		txtDescription = new JTextField();
		txtDescription.setColumns(10);
		txtDescription.setBounds(189, 187, 200, 30);
		panel.add(txtDescription);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(189, 62, 200, 30);
		panel.add(txtUsername);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn t\u00E0i kho\u1EA3n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(46, 62, 121, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(46, 104, 121, 30);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("M\u1EADt kh\u1EA9u");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(46, 147, 121, 30);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Ghi ch\u00FA");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(46, 187, 121, 30);
		panel.add(lblNewLabel_1_3);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(189, 144, 200, 30);
		panel.add(txtPassword);
		
		lblNewLabel = new JLabel("T\u1EA1o t\u00E0i kho\u1EA3n m\u1EDBi");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(316, 10, 193, 30);
		contentPane.add(lblNewLabel);
	}
}
