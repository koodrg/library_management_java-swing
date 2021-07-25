import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controllers.ParametersController;
import models.Book;
import models.BookCategory;
import models.Parameters;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CaiDat extends JPanel {
	private JTextField txtGiaTri;
	
	private int parameterId;
	
	private ParametersController parametersController = new ParametersController();
	/**
	 * Create the panel.
	 */
	public CaiDat() {
		setBorder(null);
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(100, 100, 714, 521);
		
		JLabel lblNewLabel = new JLabel("Cài đặt");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(315, 47, 84, 35);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên tham số:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(210, 153, 100, 25);
		add(lblNewLabel_1);
		
		txtGiaTri = new JTextField();
		txtGiaTri.setColumns(10);
		txtGiaTri.setBounds(333, 203, 171, 25);
		add(txtGiaTri);
		
		JLabel lblNewLabel_1_1 = new JLabel("Giá trị:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(210, 203, 100, 25);
		add(lblNewLabel_1_1);
		
		JButton btnSua = new JButton("Cài đặt");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSua.setBounds(315, 277, 90, 25);
		add(btnSua);
		
		
		List<Parameters> parameters = parametersController.findAll();
		JComboBox<Parameters> cbTen = new JComboBox<Parameters>();
		String[] param = new String[2];
		for(int i = 0; i <parameters.size(); i++) {
			param[i] = parameters.get(i).getName();
		}
		cbTen.setModel(new DefaultComboBoxModel(param));
		cbTen.setBounds(333, 153, 171, 25);
		add(cbTen);
		cbTen.setSelectedIndex(-1);
		
		cbTen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JComboBox<Parameters> cmbCombo = (JComboBox<Parameters>) e.getSource();
				 	System.out.println(cbTen.getSelectedIndex());
				 	parameterId = cbTen.getSelectedIndex()+1;
				 	System.out.println(parameterId);
				 	if(parameterId>0) {
				 		List<Parameters> parameters = parametersController.findById(parameterId);
		                txtGiaTri.setText(String.valueOf(parameters.get(0).getValue()));
				 	}
	                
			}
		});
		
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean success = parametersController.editParameter(parameterId, txtGiaTri.getText());
				if(success)
				{
					JOptionPane.showMessageDialog(null, "Cập nhật tham số thành công.");
					cbTen.setSelectedIndex(-1);
					txtGiaTri.setText("");
				}
			}
		});
	}
}
