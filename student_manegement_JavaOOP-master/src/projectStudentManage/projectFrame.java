package projectStudentManage;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import projectStudentManage.Students;
import projectStudentManage.StudentsModify;
import projectStudentManage.Students;

import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class projectFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textIDLop;
	private JTextField textTenLop;
	private JTextField textKhoaHoc;
	private JTextField textEmail;
	private JTable tableStudents;
	private JTextField txtNhpMssv;
	DefaultTableModel tableModel;
	private JTextField textDiem1;
	private JTextField textDiem2;
	private JTextField textDiem3;
	
	List<Students> studentList = new ArrayList<>();

	
	/**
	 * Launch the application.
	 */
	
	public projectFrame() {
		initComponents();
		
		tableModel = (DefaultTableModel) tableStudents.getModel();
        
        showStudents();
	}
	
	private void showStudents() {
		List<Students> studentList = StudentsModify.findAll();
		
		tableModel.setRowCount(0);
		
		studentList.forEach((student) -> {
            tableModel.addRow(new Object[] {tableModel.getRowCount() + 1, 
            		student.getIDLop(), 
            		student.getTenLop(), 
            		student.getKhoaHoc(),	
            });
        });
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {
		setBackground(new Color(255, 255, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 768);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelBy = new JLabel("Nhóm 8");
		labelBy.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		labelBy.setBounds(1092, 65, 62, 23);
		contentPane.add(labelBy);
		
		JLabel labelLogin = new JLabel("QUẢN LÝ SINH VIÊN");
		labelLogin.setBackground(new Color(0, 255, 0));
		labelLogin.setVerifyInputWhenFocusTarget(false);
		labelLogin.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		labelLogin.setBounds(10, 11, 1164, 88);
		labelLogin.setHorizontalAlignment(SwingConstants.CENTER); // set text alignment to center
		labelLogin.setFont(new Font("Arial", Font.BOLD, 50)); // set a new font with larger size
		labelLogin.setForeground(new Color(0, 0, 0)); // set text color to blue
		contentPane.add(labelLogin);
		
		JPanel panelPriView = new JPanel();
		panelPriView.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelPriView.setBounds(10, 128, 1164, 590);
		contentPane.add(panelPriView);
		panelPriView.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1164, 579);
		panelPriView.add(tabbedPane);
		tabbedPane.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JPanel panelStudents = new JPanel();
		panelStudents.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panelStudents.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.addTab("Sinh viên", null, panelStudents, null);
		panelStudents.setLayout(null);
		
		JPanel panelStudentsInfor = new JPanel();
		panelStudentsInfor.setBackground(new Color(0, 255, 0));
		panelStudentsInfor.setBounds(0, 0, 339, 545);
		panelStudentsInfor.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelStudents.add(panelStudentsInfor);
		panelStudentsInfor.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Lớp");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 21, 65, 26);
		panelStudentsInfor.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Lớp");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 71, 58, 26);
		panelStudentsInfor.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Khóa học");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 121, 65, 26);
		panelStudentsInfor.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Giới tính");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 171, 58, 26);
		panelStudentsInfor.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Lớp");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(10, 221, 58, 26);
		panelStudentsInfor.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Email");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4_1.setBounds(10, 271, 58, 26);
		panelStudentsInfor.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Môn học 1");
		lblNewLabel_4_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4_1_1.setBounds(10, 321, 80, 26);
		panelStudentsInfor.add(lblNewLabel_4_1_1);
		
		textIDLop = new JTextField();
		textIDLop.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textIDLop.setBounds(85, 21, 229, 26);
		panelStudentsInfor.add(textIDLop);
		textIDLop.setColumns(10);
		
		textTenLop = new JTextField();
		textTenLop.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textTenLop.setColumns(10);
		textTenLop.setBounds(85, 71, 229, 26);
		panelStudentsInfor.add(textTenLop);
		
		textKhoaHoc = new JTextField();
		textKhoaHoc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textKhoaHoc.setColumns(10);
		textKhoaHoc.setBounds(85, 121, 120, 26);
		textKhoaHoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String namsinhText = textKhoaHoc.getText();
		        int namsinh = 0;
		        
		        try {
		            namsinh = Integer.parseInt(namsinhText);
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(contentPane, "Năm sinh không hợp lệ! Vui lòng nhập lại năm sinh từ 1920 đến 2020.");
		            textKhoaHoc.setText("");
		            return;
		        }
		        
		        if (namsinh < 1920 || namsinh > 2020) {
		            JOptionPane.showMessageDialog(contentPane, "Năm sinh không hợp lệ! Vui lòng nhập lại năm sinh từ 1920 đến 2020.");
		            textKhoaHoc.setText("");
		        }
		    }
		});
		panelStudentsInfor.add(textKhoaHoc);
		
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textEmail.setColumns(10);
		textEmail.setBounds(85, 271, 229, 26);
		panelStudentsInfor.add(textEmail);
		textIDLop.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JComboBox comboGioitinh = new JComboBox();
		comboGioitinh.setModel(new DefaultComboBoxModel(new String[] {"", "Nam", "Nữ"}));
		comboGioitinh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboGioitinh.setBounds(85, 171, 120, 26);
		panelStudentsInfor.add(comboGioitinh);
		
		JComboBox comboLop = new JComboBox();
		comboLop.setModel(new DefaultComboBoxModel(new String[] {"", "D19CQVTMD01-N", "D19CQVTVT01-N", "D19CQVTIO01-N", "D20CQVT01-N", "D21CQVT01-N", "D22CQVT01-N"}));
		comboLop.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboLop.setBounds(85, 221, 229, 26);
		panelStudentsInfor.add(comboLop);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("Điểm");
		lblNewLabel_4_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4_1_2.setBounds(235, 321, 38, 26);
		panelStudentsInfor.add(lblNewLabel_4_1_2);
		
		textDiem1 = new JTextField();
		textDiem1.setColumns(10);
		textDiem1.setBounds(276, 321, 38, 26);
		textDiem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int diem1 = Integer.parseInt(textDiem1.getText());
				
				if (diem1 < 0 || diem1 > 10) {
					JOptionPane.showMessageDialog(contentPane, "Nhập lại điểm theo hệ 10");
					textKhoaHoc.setText(null);
				}
			}
		});
		panelStudentsInfor.add(textDiem1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Môn học 2");
		lblNewLabel_4_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4_1_1_1.setBounds(10, 371, 80, 26);
		panelStudentsInfor.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_4_1_2_1 = new JLabel("Điểm");
		lblNewLabel_4_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4_1_2_1.setBounds(235, 371, 38, 26);
		panelStudentsInfor.add(lblNewLabel_4_1_2_1);
		
		textDiem2 = new JTextField();
		textDiem2.setColumns(10);
		textDiem2.setBounds(276, 371, 38, 26);
		textDiem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int diem2 = Integer.parseInt(textDiem2.getText());
				
				if (diem2 < 0 || diem2 > 10) {
					JOptionPane.showMessageDialog(contentPane, "Nhập lại điểm theo hệ 10");
					textKhoaHoc.setText(null);
				}
			}
		});
		panelStudentsInfor.add(textDiem2);
		
		JLabel lblNewLabel_4_1_1_2 = new JLabel("Môn học 3");
		lblNewLabel_4_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4_1_1_2.setBounds(10, 421, 80, 26);
		panelStudentsInfor.add(lblNewLabel_4_1_1_2);
		
		JLabel lblNewLabel_4_1_2_2 = new JLabel("Điểm");
		lblNewLabel_4_1_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4_1_2_2.setBounds(235, 421, 38, 26);
		panelStudentsInfor.add(lblNewLabel_4_1_2_2);
		
		textDiem3 = new JTextField();
		textDiem3.setColumns(10);
		textDiem3.setBounds(276, 421, 38, 26);
		textDiem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int diem3 = Integer.parseInt(textDiem3.getText());
				
				if (diem3 < 0 || diem3 > 10) {
					JOptionPane.showMessageDialog(contentPane, "Nhập lại điểm theo hệ 10");
					textKhoaHoc.setText(null);
				}
			}
		});
		panelStudentsInfor.add(textDiem3);
		
		JComboBox comboMon1 = new JComboBox();
		comboMon1.setModel(new DefaultComboBoxModel(new String[] {"", "Lập trình hướng đối tượng", "Cơ sở dữ liệu", "Quản trị mạng", "Điện toán đám mây", "Thực tập cơ sở", "Xử lý âm thanh", "Hệ điều hành", "Công nghệ phần mềm", "Kỹ thuật vi xử lý"}));
		comboMon1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboMon1.setBounds(85, 321, 140, 26);
		panelStudentsInfor.add(comboMon1);
		
		JComboBox comboMon2 = new JComboBox();
		comboMon2.setModel(new DefaultComboBoxModel(new String[] {"", "Lập trình hướng đối tượng", "Cơ sở dữ liệu", "Quản trị mạng", "Điện toán đám mây", "Thực tập cơ sở", "Xử lý âm thanh", "Hệ điều hành", "Công nghệ phần mềm", "Kỹ thuật vi xử lý"}));
		comboMon2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboMon2.setBounds(85, 371, 140, 26);
		panelStudentsInfor.add(comboMon2);
		
		JComboBox comboMon3 = new JComboBox();
		comboMon3.setModel(new DefaultComboBoxModel(new String[] {"", "Lập trình hướng đối tượng", "Cơ sở dữ liệu", "Quản trị mạng", "Điện toán đám mây", "Thực tập cơ sở", "Xử lý âm thanh", "Hệ điều hành", "Công nghệ phần mềm", "Kỹ thuật vi xử lý"}));
		comboMon3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboMon3.setBounds(85, 421, 140, 26);
		panelStudentsInfor.add(comboMon3);
		
		JScrollPane scrollPaneStudents = new JScrollPane();
		scrollPaneStudents.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPaneStudents.setBounds(349, 38, 810, 507);
		panelStudents.add(scrollPaneStudents);
		
		tableStudents = new JTable();
		tableStudents.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "ID Lớp", "Tên Lớp", "Khóa Học"
			}
		));
		tableStudents.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableStudents.getColumnModel().getColumn(2).setPreferredWidth(78);
		tableStudents.getColumnModel().getColumn(3).setPreferredWidth(61);
		tableStudents.getColumnModel().getColumn(4).setPreferredWidth(52);
		tableStudents.getColumnModel().getColumn(5).setPreferredWidth(80);
		tableStudents.getColumnModel().getColumn(6).setPreferredWidth(101);
		tableStudents.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		scrollPaneStudents.setViewportView(tableStudents);
		
		JButton btnThemStudents = new JButton("Thêm");
		btnThemStudents.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnThemStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IDLop = textIDLop.getText();
				String TenLop = textTenLop.getText();
				String KhoaHoc = textKhoaHoc.getText();
				
				
				Students std = new Students( IDLop, TenLop, KhoaHoc);
				
				StudentsModify.insert(std);
				
				showStudents();
			}
		});
		btnThemStudents.setBounds(10, 499, 89, 35);
		panelStudentsInfor.add(btnThemStudents);
		
		JButton btnCpNhpStudents = new JButton("Cập nhập");
		btnCpNhpStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IDLop = textIDLop.getText();
				String TenLop = textTenLop.getText();
				String KhoaHoc = textKhoaHoc.getText();
				
				
				Students std = new Students( IDLop, TenLop, KhoaHoc);
				
				
				StudentsModify.update(std);
				
				showStudents();
			}
		});
		btnCpNhpStudents.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnCpNhpStudents.setBounds(115, 499, 108, 35);
		panelStudentsInfor.add(btnCpNhpStudents);
		
		JButton btnXoaStudents = new JButton("Xóa");
		btnXoaStudents.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	List<Students> studentList = StudentsModify.findAll();
		        int selectedIndex = tableStudents.getSelectedRow();
		        if (selectedIndex >= 0) {
		            Students student = studentList.get(selectedIndex); //Fix
		            int index = student.getStt();
		            int optionType = JOptionPane.OK_CANCEL_OPTION;
		            int messageType = JOptionPane.QUESTION_MESSAGE;

		            int option = JOptionPane.showConfirmDialog(panelPriView, "Bạn có muốn xóa không?", "Xác nhận xóa", optionType, messageType, null);
		            if (option == JOptionPane.OK_OPTION) {
		                StudentsModify.delete(index); //Fix
		                showStudents();
		            }
		        }
		    }
		});
		btnXoaStudents.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnXoaStudents.setBounds(240, 499, 89, 35);
		panelStudentsInfor.add(btnXoaStudents);
		
		JButton btnLammoi = new JButton("");
		btnLammoi.setBounds(157, 468, 25, 25);
		btnLammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textIDLop.setText("");
				textTenLop.setText("");
				textKhoaHoc.setText("");
				comboGioitinh.setSelectedIndex(0);
				comboLop.setSelectedIndex(0);
				textEmail.setText("");
				comboMon1.setSelectedIndex(0);
				textDiem1.setText("");
				comboMon2.setSelectedIndex(0);
				textDiem2.setText("");
				comboMon3.setSelectedIndex(0);
				textDiem3.setText("");
			}
		});
		panelStudentsInfor.add(btnLammoi);
		
		JLabel lblNhapMssv = new JLabel("Nhập MSSV");
		lblNhapMssv.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNhapMssv.setBounds(495, 5, 121, 26);
		panelStudents.add(lblNhapMssv);
		
		txtNhpMssv = new JTextField();
		txtNhpMssv.setToolTipText("Nhập MSSV để tìm kiếm");
		txtNhpMssv.setBounds(626, 5, 256, 26);
		panelStudents.add(txtNhpMssv);
		txtNhpMssv.setColumns(10);
		
		JButton btnFindStudents = new JButton("Tìm");
		btnFindStudents.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnFindStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String input = txtNhpMssv.getText();
			        if(input != null && input.length() > 0) {
			            studentList = StudentsModify.findIDLop(input);
			            
			            tableModel.setRowCount(0);
			        
			            studentList.forEach((student) -> {
			                tableModel.addRow(new Object[] {tableModel.getRowCount() + 1, 
			                		student.getIDLop(), 
			                		student.getTenLop(), 
			                		student.getKhoaHoc(),			                		
			                	});
			            });
			        } else {
			            showStudents();
			        }
			}
		});
		btnFindStudents.setBounds(901, 5, 99, 27);
		panelStudents.add(btnFindStudents);
		
		
	}
	
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					projectFrame frame = new projectFrame();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
