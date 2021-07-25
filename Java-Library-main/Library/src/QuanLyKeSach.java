import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controllers.ShelfController;
import models.Shelves;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuanLyKeSach extends JPanel {
	private JTextField txtSoKe;
	private JTextField txtTang;
	private JTable tbl_data;
	private String shelfId;
	public int totalAttributeOfClass = 3;
	
	public ShelfController shelfController;
	
	void loadShelf() {
		DefaultTableModel modelTableShelf = (DefaultTableModel) tbl_data.getModel();
		
		modelTableShelf.getDataVector().removeAllElements();
		modelTableShelf.fireTableDataChanged();
		
		List<Shelves> listShelf = shelfController.findAll();
		
		
		for (int i = 0; i < listShelf.size(); i++) {
			Object rowData[] = new Object[this.totalAttributeOfClass];
			rowData[0] = listShelf.get(i).getId();
			rowData[1] = listShelf.get(i).getShelf();
			rowData[2] = listShelf.get(i).getFloor();
			
			modelTableShelf.addRow(rowData);
		}
	}

	/**
	 * Create the panel.
	 */
	public QuanLyKeSach() {
		setBorder(null);
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(100, 100, 714, 521);
		
		JLabel lblNewLabel = new JLabel("Kệ sách");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(318, 38, 78, 31);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Số kệ:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(230, 95, 100, 25);
		add(lblNewLabel_1);
		
		txtSoKe = new JTextField();
		txtSoKe.setBounds(353, 95, 131, 25);
		add(txtSoKe);
		txtSoKe.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tầng:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(230, 152, 100, 25);
		add(lblNewLabel_1_1);
		
		txtTang = new JTextField();
		txtTang.setColumns(10);
		txtTang.setBounds(353, 152, 131, 25);
		add(txtTang);
		
		JScrollPane scrpane_view = new JScrollPane();
		scrpane_view.setFont(new Font("Tahoma", Font.BOLD, 17));
		scrpane_view.setBorder(new LineBorder(Color.BLACK));
		scrpane_view.setBounds(10, 255, 694, 240);
		add(scrpane_view);
		
		tbl_data = new JTable();
		tbl_data.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = tbl_data.getSelectedRow();
				
				txtSoKe.setText("");
				txtTang.setText("");
			
				shelfId = tbl_data.getModel().getValueAt(selectedRow, 0).toString();
				txtSoKe.setText(tbl_data.getModel().getValueAt(selectedRow, 1).toString());
				txtTang.setText(tbl_data.getModel().getValueAt(selectedRow, 2).toString());
				
			}
		});
		
		tbl_data.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tbl_data.setBorder(new LineBorder(new Color(0, 0, 0)));
		tbl_data.setBounds(10, 134, 694, 377);
		tbl_data.setRowHeight(30);
		tbl_data.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã", "Số kệ", "Tầng"
			}
		));
		scrpane_view.setViewportView(tbl_data);
		
		shelfController.loadStaffTable(tbl_data);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean success = shelfController.addShelf(txtSoKe.getText(), txtTang.getText());
				if(success){
					JOptionPane.showMessageDialog(null, "Thêm kệ sách thành công.");
					loadShelf();
					txtSoKe.setText("");
					txtTang.setText("");
				}
			}
		});
		btnThem.setBounds(212, 208, 90, 25);
		add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean success = shelfController.update(Integer.valueOf(shelfId), txtSoKe.getText(), txtTang.getText());
				if(success){
					JOptionPane.showMessageDialog(null, "Cập nhật kệ sách thành công.");
					loadShelf();
					txtSoKe.setText("");
					txtTang.setText("");
				}
			}
		});
		btnSua.setBounds(312, 209, 90, 25);
		add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean success = shelfController.delete(Integer.valueOf(shelfId));
				if(success){
					JOptionPane.showMessageDialog(null, "Xóa kệ sách thành công.");
					loadShelf();
					txtSoKe.setText("");
					txtTang.setText("");
				}
			}
		});
		btnXoa.setBounds(412, 209, 90, 25);
		add(btnXoa);
	}
}
