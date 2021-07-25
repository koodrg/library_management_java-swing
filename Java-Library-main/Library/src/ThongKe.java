import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controllers.RentingBookController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import models.Parameters;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ThongKe extends JPanel {
	private JTextField txtMuon;
	private JTextField txtTra;
	private int thang;
	
	public RentingBookController rentingBookController = new RentingBookController();

	/**
	 * Create the panel.
	 */
	public ThongKe() {
		setBorder(null);
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(100, 100, 714, 521);
		
		JLabel lblThngK = new JLabel("Thống kê");
		lblThngK.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblThngK.setBounds(300, 47, 114, 35);
		add(lblThngK);
		
		JLabel lblNewLabel_1 = new JLabel("Tháng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(210, 129, 100, 25);
		add(lblNewLabel_1);
		
		
		JComboBox cbThang = new JComboBox();
		cbThang.setSelectedIndex(-1);
		cbThang.setBounds(333, 129, 171, 25);
		add(cbThang);
		String[] month = {"01","02","03","04","05","06","07","08","10","11","12"};
		cbThang.setModel(new DefaultComboBoxModel(month));
		
		JButton btnThongKe = new JButton("Thống kê");
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnThongKe.setBounds(414, 185, 90, 25);
		add(btnThongKe);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số sách được mượn:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(186, 300, 148, 25);
		add(lblNewLabel_1_1);
		
		txtMuon = new JTextField();
		txtMuon.setColumns(10);
		txtMuon.setBounds(357, 300, 171, 25);
		add(txtMuon);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Số sách đã trả:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(186, 356, 148, 25);
		add(lblNewLabel_1_1_1);
		
		txtTra = new JTextField();
		txtTra.setColumns(10);
		txtTra.setBounds(357, 356, 171, 25);
		add(txtTra);
		
		cbThang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thang = cbThang.getSelectedIndex()+1;
				
				
			}
		});
		
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(thang>0) {
			 		int rent = rentingBookController.rentInMonth(thang);
			 		int pay = rentingBookController.payInMonth(thang);
			 		txtMuon.setText(String.valueOf(rent));
			 		txtTra.setText(String.valueOf(pay));
			 	}
			}
		});
	}
}
