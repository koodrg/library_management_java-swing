import java.awt.BorderLayout;
import java.awt.EventQueue;
import controllers.UserController;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPasswordField;

public class ManHinhDangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField txtTnngNhp;
	private JPasswordField txtMatKhau;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManHinhDangNhap frame = new ManHinhDangNhap();
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
	public ManHinhDangNhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(134, 10, 538, 382);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtTnngNhp = new JTextField();
		txtTnngNhp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTnngNhp.setBounds(244, 112, 200, 30);
		panel.add(txtTnngNhp);
		txtTnngNhp.setColumns(10);
		
		JButton btnNewButton = new JButton("\u0110\u0103ng nh\u1EADp");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtTnngNhp.getText();
				String password = String.valueOf(txtMatKhau.getPassword());
				UserController loginControl = new UserController();
				if(loginControl.checkUserToLogin(username, password)) {
					int id = loginControl.findLoginUserId(username);
					int typeUser = loginControl.findLoginUserType(username);
					if(id!=-1) {
						if (typeUser == 1) {
							TrangChu_QuanLy main = new TrangChu_QuanLy(username);
							main.setVisible(true);
						}
						else {
							TrangChu_ThuThu main = new TrangChu_ThuThu(id);
							main.setVisible(true);
						}
						showMessageDialog(null, "Đăng nhập thành công!");
						setVisible(false);
					}
				}
				else {
					showMessageDialog(null, "Đăng nhập không thành công!");
				}
				
			}
		});
		btnNewButton.setBounds(244, 220, 200, 35);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u0110\u0103ng k\u00FD");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ManHinhDangKy signup = new ManHinhDangKy();
				signup.setVisible(true);
				signup.setLocationRelativeTo(null);
			}
		});
		btnNewButton_1.setForeground(new Color(153, 153, 153));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(244, 317, 200, 35);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Ch\u01B0a c\u00F3 t\u00E0i kho\u1EA3n?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(274, 272, 171, 35);
		panel.add(lblNewLabel);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(244, 169, 200, 30);
		panel.add(txtMatKhau);
		
		JLabel lblTnTiKhon = new JLabel("Tên tài khoản:");
		lblTnTiKhon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTnTiKhon.setBounds(85, 110, 118, 35);
		panel.add(lblTnTiKhon);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMtKhu.setBounds(85, 163, 108, 35);
		panel.add(lblMtKhu);
	}
}
