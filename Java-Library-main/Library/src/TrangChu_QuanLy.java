import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TrangChu_QuanLy extends JFrame {
	//logo
	private Image img_logo = new ImageIcon(TrangChu_QuanLy.class.getResource("icon/018-library-1.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	//thong ke
	private Image img_book = new ImageIcon(TrangChu_QuanLy.class.getResource("icon/analytics.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	//quan ly sach
	private Image img_course = new ImageIcon(TrangChu_QuanLy.class.getResource("icon/008-book-4.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	//quan ly doc gia
	private Image img_user_account = new ImageIcon(TrangChu_QuanLy.class.getResource("icon/reader.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	//quan ly ke sach
	private Image img_borrow_book = new ImageIcon(TrangChu_QuanLy.class.getResource("icon/kesach.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	//quan ly nhan su
	private Image img_change_user = new ImageIcon(TrangChu_QuanLy.class.getResource("icon/id-card.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	//quan ly thu thu
	private Image img_add_user = new ImageIcon(TrangChu_QuanLy.class.getResource("icon/users.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	//
	private Image img_user = new ImageIcon(TrangChu_QuanLy.class.getResource("icon/account.png")).getImage().getScaledInstance(32,32,Image.SCALE_SMOOTH);
	private Image img_sign_out = new ImageIcon(TrangChu_QuanLy.class.getResource("icon/logout.png")).getImage().getScaledInstance(32,32,Image.SCALE_SMOOTH);
	private Image img_setting = new ImageIcon(TrangChu_QuanLy.class.getResource("icon/wrench.png")).getImage().getScaledInstance(32,32,Image.SCALE_SMOOTH);

	private JPanel contentPane;
	private JTextField txtTenNv;
	private JPanel children1;

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
	public TrangChu_QuanLy(String name) {
		
		setUndecorated(true);
		setTitle("Thư viện");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trang ch\u1EE7");
		lblNewLabel.setBounds(40, 10, 67, 22);
		contentPane.add(lblNewLabel);
		
		JPanel panelMain = new JPanel();
		panelMain.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMain.setBounds(200, 38, 718, 521);
		contentPane.add(panelMain);
		panelMain.setLayout(new BorderLayout(0, 0));
		
		JLabel lblIonLogo = new JLabel("");
		lblIonLogo.setBounds(10, 5, 32, 32);
		contentPane.add(lblIonLogo);
		lblIonLogo.setIcon(new ImageIcon(img_logo));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(61, 157, 245));
		panel_1.setBounds(0, 38, 200, 521);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(61, 157, 245));
		panel_2.setBounds(10, 10, 180, 49);
		panel_1.add(panel_2);
		
		JLabel lblUser = new JLabel("");
		lblUser.setBounds(10, 10, 32, 32);
		panel_2.add(lblUser);
		lblUser.setIcon(new ImageIcon(img_user));
		
		JLabel lblSignOut = new JLabel("");
		lblSignOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame login = new ManHinhDangNhap();
				login.setVisible(true);
				setVisible(false);
				login.setLocationRelativeTo(null);
			}
		});
		lblSignOut.setBounds(140, 10, 32, 32);
		panel_2.add(lblSignOut);
		lblSignOut.setIcon(new ImageIcon(img_sign_out));
		
		txtTenNv = new JTextField();
		txtTenNv.setText(name);
		txtTenNv.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTenNv.setColumns(10);
		txtTenNv.setBorder(null);
		txtTenNv.setBackground(new Color(61, 157, 245));
		txtTenNv.setBounds(52, 0, 96, 49);
		panel_2.add(txtTenNv);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(61, 157, 245));
		panel_8.setBounds(10, 303, 180, 49);
		panel_1.add(panel_8);
		
		JButton btnDangKi = new JButton("Đăng kí thủ thư");
		btnDangKi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				children1 = new DangKy();
				panelMain.removeAll();
				panelMain.add(children1);
				panelMain.validate();
			}
		});
		btnDangKi.setHorizontalAlignment(SwingConstants.LEFT);
		btnDangKi.setForeground(Color.WHITE);
		btnDangKi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDangKi.setBorder(null);
		btnDangKi.setBackground(new Color(61, 157, 245));
		btnDangKi.setBounds(51, 0, 129, 49);
		panel_8.add(btnDangKi);
		
		JLabel lblDK = new JLabel("");
		lblDK.setBounds(10, 10, 32, 32);
		panel_8.add(lblDK);
		lblDK.setIcon(new ImageIcon(img_add_user));
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(61, 157, 245));
		panel_7.setBounds(10, 244, 180, 49);
		panel_1.add(panel_7);
		
		JButton btnQLNS = new JButton("Quản lý nhân sự");
		btnQLNS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				children1 = new QLTK();
				panelMain.removeAll();
				panelMain.add(children1);
				panelMain.validate();
			}
		});
		btnQLNS.setHorizontalAlignment(SwingConstants.LEFT);
		btnQLNS.setForeground(Color.WHITE);
		btnQLNS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnQLNS.setBorder(null);
		btnQLNS.setBackground(new Color(61, 157, 245));
		btnQLNS.setBounds(51, 0, 129, 49);
		panel_7.add(btnQLNS);
		
		JLabel lblQLTK = new JLabel("");
		lblQLTK.setBounds(9, 10, 32, 32);
		panel_7.add(lblQLTK);
		lblQLTK.setIcon(new ImageIcon(img_change_user));
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(61, 157, 245));
		panel_6.setBounds(10, 129, 180, 49);
		panel_1.add(panel_6);
		
		JButton btnQLKe = new JButton("Quản lý kệ sách");
		btnQLKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				children1 = new QuanLyKeSach();
				panelMain.removeAll();
				panelMain.add(children1)
				;
				panelMain.validate();
			}
		});
		btnQLKe.setHorizontalAlignment(SwingConstants.LEFT);
		btnQLKe.setForeground(Color.WHITE);
		btnQLKe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnQLKe.setBorder(null);
		btnQLKe.setBackground(new Color(61, 157, 245));
		btnQLKe.setBounds(51, 0, 129, 49);
		panel_6.add(btnQLKe);
		
		JLabel lblQLMuonTra = new JLabel("");
		lblQLMuonTra.setBounds(9, 10, 32, 32);
		panel_6.add(lblQLMuonTra);
		lblQLMuonTra.setIcon(new ImageIcon(img_borrow_book));
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(61, 157, 245));
		panel_5.setBounds(10, 185, 180, 49);
		panel_1.add(panel_5);
		
		JButton btnNewButton_1_1_1 = new JButton("Qu\u1EA3n l\u00FD \u0111\u1ED9c gi\u1EA3");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				children1 = new QLDG();
				panelMain.removeAll();
				panelMain.add(children1);
				panelMain.validate();
			}
		});
		btnNewButton_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1_1.setBorder(null);
		btnNewButton_1_1_1.setBackground(new Color(61, 157, 245));
		btnNewButton_1_1_1.setBounds(51, 0, 129, 49);
		panel_5.add(btnNewButton_1_1_1);
		
		JLabel lblUserAccount = new JLabel("");
		lblUserAccount.setBounds(10, 10, 32, 32);
		panel_5.add(lblUserAccount);
		lblUserAccount.setIcon(new ImageIcon(img_user_account));
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(61, 157, 245));
		panel_4.setBounds(10, 69, 180, 49);
		panel_1.add(panel_4);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Qu\u1EA3n l\u00FD s\u00E1ch");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				children1 = new QuanLiSach();
				panelMain.removeAll();
				panelMain.add(children1);
				panelMain.validate();
			}
		});
		btnNewButton_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1_1_1.setBorder(null);
		btnNewButton_1_1_1_1.setBackground(new Color(61, 157, 245));
		btnNewButton_1_1_1_1.setBounds(51, 0, 129, 49);
		panel_4.add(btnNewButton_1_1_1_1);
		
		JLabel lblQLSach = new JLabel("");
		lblQLSach.setBounds(10, 10, 32, 32);
		panel_4.add(lblQLSach);
		lblQLSach.setIcon(new ImageIcon(img_course));
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setForeground(Color.WHITE);
		panel_3.setBackground(new Color(61, 157, 245));
		panel_3.setBounds(10, 362, 180, 49);
		panel_1.add(panel_3);
		
		JButton btnThongKe = new JButton("Thống kê");
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				children1 = new ThongKe();
				panelMain.removeAll();
				panelMain.add(children1);
				panelMain.validate();
			}
		});
		btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongKe.setForeground(Color.WHITE);
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThongKe.setBorder(null);
		btnThongKe.setBackground(new Color(61, 157, 245));
		btnThongKe.setBounds(51, 0, 129, 49);
		panel_3.add(btnThongKe);
		
		JLabel lblBook = new JLabel("");
		lblBook.setBounds(10, 10, 32, 32);
		panel_3.add(lblBook);
		setLocationRelativeTo(null);
		lblBook.setIcon(new ImageIcon(img_book));
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setForeground(Color.WHITE);
		panel_3_1.setBackground(new Color(61, 157, 245));
		panel_3_1.setBounds(10, 421, 180, 49);
		panel_1.add(panel_3_1);
		
		JButton btnCaiDat = new JButton("Cài đặt");
		btnCaiDat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				children1 = new CaiDat();
				panelMain.removeAll();
				panelMain.add(children1);
				panelMain.validate();
			}
		});
		btnCaiDat.setHorizontalAlignment(SwingConstants.LEFT);
		btnCaiDat.setForeground(Color.WHITE);
		btnCaiDat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCaiDat.setBorder(null);
		btnCaiDat.setBackground(new Color(61, 157, 245));
		btnCaiDat.setBounds(51, 0, 129, 49);
		panel_3_1.add(btnCaiDat);
		
		JLabel lblSetting = new JLabel("");
		lblSetting.setBounds(10, 10, 32, 32);
		setLocationRelativeTo(null);
		lblSetting.setIcon(new ImageIcon(img_setting));
		panel_3_1.add(lblSetting);
	}
}
