import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controllers.UserController;

public class DangKy extends JPanel {
	private JTextField txtUsername;
	private JTextField txtEmail;
	private JTextField txtDescription;
	private JPasswordField txtPassword;

	/**
	 * Create the panel.
	 */
	public DangKy() {
		setBorder(null);
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(100, 100, 714, 521);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(313, 60, 309, 31);
		txtUsername.setColumns(10);
		add(txtUsername);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(313, 116, 309, 31);
		add(txtEmail);
		
		txtDescription = new JTextField();
		txtDescription.setColumns(10);
		txtDescription.setBounds(313, 241, 309, 31);
		add(txtDescription);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(313, 178, 309, 32);
		add(txtPassword);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn t\u00E0i kho\u1EA3n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(123, 58, 124, 31);
		add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(123, 114, 124, 31);
		add(lblEmail);
		
		JLabel lblMtKhu = new JLabel("M\u1EADt kh\u1EA9u");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMtKhu.setBounds(123, 176, 124, 31);
		add(lblMtKhu);
		
		JLabel lblThngTinThm = new JLabel("Th\u00F4ng tin th\u00EAm");
		lblThngTinThm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThngTinThm.setBounds(123, 239, 152, 31);
		add(lblThngTinThm);
		
		JButton btnNewButton = new JButton("\u0110\u0103ng k\u00FD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText();
				String email = txtEmail.getText();
				String password = String.valueOf(txtPassword.getPassword());
				String description = txtDescription.getText();
				
				UserController userControl = new UserController();
				if(userControl.checkUserToSignUp(username, email, password, description) == "EMPTY FIELD") {
					showMessageDialog(null, "Vui l??ng ??i???n c??c tr?????ng c??n tr???ng");
				} 
				else if(userControl.checkUserToSignUp(username, email, password, description) == "INVALID OR EXISTED EMAIL")
					showMessageDialog(null, "Email kh??ng h???p l???");
				else if(userControl.checkUserToSignUp(username, email, password, description) == "EXISTED EMAIL OR EXISTED USERNAME") {
					showMessageDialog(null, "Email ho???c t??n t??i kho???n ???? ???????c s??? d???ng");
				}
				else if (userControl.addUser(username, email, password, description)) {
					showMessageDialog(null, "????ng k?? th??nh c??ng");
				}
				//System.out.println(password);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(389, 328, 160, 31);
		add(btnNewButton);

	}
}
