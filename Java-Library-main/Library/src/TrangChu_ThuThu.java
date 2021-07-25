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

public class TrangChu_ThuThu extends JFrame {
	
	private Image img_logo = new ImageIcon(TrangChu_ThuThu.class.getResource("icon/018-library-1.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	private Image img_book = new ImageIcon(TrangChu_ThuThu.class.getResource("icon/008-book-4.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	private Image img_course = new ImageIcon(TrangChu_ThuThu.class.getResource("icon/book_3.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	private Image img_user_account = new ImageIcon(TrangChu_ThuThu.class.getResource("icon/reader.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	private Image img_borrow_book = new ImageIcon(TrangChu_ThuThu.class.getResource("icon/007-book-3.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	//private Image img_change_user = new ImageIcon(TrangChu_ThuThu.class.getResource("icon/change-user.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	//private Image img_add_user = new ImageIcon(TrangChu_ThuThu.class.getResource("icon/add-user.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	private Image img_user = new ImageIcon(TrangChu_ThuThu.class.getResource("icon/account.png")).getImage().getScaledInstance(32,32,Image.SCALE_SMOOTH);
	private Image img_sign_out = new ImageIcon(TrangChu_ThuThu.class.getResource("icon/logout.png")).getImage().getScaledInstance(32,32,Image.SCALE_SMOOTH);
	
	private JPanel contentPane;
	private JTextField txtThTh;
	private JPanel children1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					TrangChu frame = new TrangChu();
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
	public TrangChu_ThuThu(int id) {
		
		setUndecorated(true);
		setTitle("Trang ch\u1EE7");
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
		
		txtThTh = new JTextField();
		txtThTh.setText("Thủ thư");
		txtThTh.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtThTh.setColumns(10);
		txtThTh.setBorder(null);
		txtThTh.setBackground(new Color(61, 157, 245));
		txtThTh.setBounds(52, 0, 96, 49);
		panel_2.add(txtThTh);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(61, 157, 245));
		panel_6.setBounds(10, 171, 180, 49);
		panel_1.add(panel_6);
		
		JButton btnNewButton_1_1 = new JButton("Qu\u1EA3n l\u00FD m\u01B0\u1EE3n tr\u1EA3");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				children1 = new QLMT();
				panelMain.removeAll();
				panelMain.add(children1);
				panelMain.validate();
			}
		});
		btnNewButton_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1.setBorder(null);
		btnNewButton_1_1.setBackground(new Color(61, 157, 245));
		btnNewButton_1_1.setBounds(51, 0, 129, 49);
		panel_6.add(btnNewButton_1_1);
		
		JLabel lblQLMuonTra = new JLabel("");
		lblQLMuonTra.setBounds(9, 10, 32, 32);
		panel_6.add(lblQLMuonTra);
		lblQLMuonTra.setIcon(new ImageIcon(img_borrow_book));
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(61, 157, 245));
		panel_5.setBounds(10, 320, 180, 49);
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
		panel_4.setBounds(10, 243, 180, 49);
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
		panel_3.setBounds(10, 97, 180, 49);
		panel_1.add(panel_3);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("M\u01B0\u1EE3n s\u00E1ch");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				children1 = new MuonSach(id);
				panelMain.removeAll();
				panelMain.add(children1);
				panelMain.validate();
			}
		});
		btnNewButton_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1_1_1_1.setBorder(null);
		btnNewButton_1_1_1_1_1.setBackground(new Color(61, 157, 245));
		btnNewButton_1_1_1_1_1.setBounds(51, 0, 129, 49);
		panel_3.add(btnNewButton_1_1_1_1_1);
		
		JLabel lblBook = new JLabel("");
		lblBook.setBounds(10, 10, 32, 32);
		panel_3.add(lblBook);
		setLocationRelativeTo(null);
		lblBook.setIcon(new ImageIcon(img_book));
	}
}
