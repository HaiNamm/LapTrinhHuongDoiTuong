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
import javax.swing.event.ListDataEvent;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

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
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class projectsFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textIDLop;
	private JTextField textKhoahoc;
	private JTable tableStudents;
	private JTextField txtNhpMssv;

	DefaultTableModel tableModel;
	
	List<Students> studentList = new ArrayList<>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					projectsFrame frame = new projectsFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public projectsFrame() {
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
            		student.getKhoaHoc()
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
		
		JLabel lblNewLabel_1 = new JLabel("Khóa học");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 71, 58, 26);
		panelStudentsInfor.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Tên lớp");
		lblNewLabel_4_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4_1_1.setBounds(10, 123, 80, 26);
		panelStudentsInfor.add(lblNewLabel_4_1_1);
		
		textIDLop = new JTextField();
		textIDLop.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textIDLop.setBounds(85, 21, 229, 26);
		panelStudentsInfor.add(textIDLop);
		textIDLop.setColumns(10);
		
		textKhoahoc = new JTextField();
		textIDLop.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textKhoahoc.setColumns(10);
		textKhoahoc.setBounds(85, 71, 229, 26);
		panelStudentsInfor.add(textKhoahoc);
		textIDLop.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textIDLop.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textIDLop.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JComboBox comboLop = new JComboBox();
		comboLop.setModel(new DefaultComboBoxModel(new String[] {"", "Lập trình hướng đối tượng", "Cơ sở dữ liệu", "Quản trị mạng", "Điện toán đám mây", "Thực tập cơ sở", "Xử lý âm thanh", "Hệ điều hành", "Công nghệ phần mềm", "Kỹ thuật vi xử lý"}));
		comboLop.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboLop.setBounds(85, 123, 140, 26);
		panelStudentsInfor.add(comboLop);
		
		JScrollPane scrollPaneStudents = new JScrollPane();
		scrollPaneStudents.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPaneStudents.setBounds(349, 38, 810, 507);
		panelStudents.add(scrollPaneStudents);
		
		tableStudents = new JTable();
		tableStudents.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "ID Lớp", "Tên Lớp", "Khóa học"
			}
		));
		tableStudents.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		scrollPaneStudents.setViewportView(tableStudents);
		
		JButton btnThemStudents = new JButton("Thêm");
		btnThemStudents.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnThemStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IDLop = textIDLop.getText();
				String KhoaHoc = textKhoahoc.getText();
				String tenlop = (String) comboLop.getSelectedItem();
				
				Students std = new Students(IDLop, tenlop, KhoaHoc);
				
				StudentsModify.insert(std);
				
				showStudents();
			}
		});
		btnThemStudents.setBounds(10, 499, 89, 35);
		panelStudentsInfor.add(btnThemStudents);
		JButton btnCpNhpStudents = new JButton("Cập nhập");
		btnCpNhpStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textIDLop.setText("");
				textKhoahoc.setText("");
				comboLop.setSelectedIndex(0);
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
		        if(selectedIndex >= 0) {
		        	Students std = studentList.get(selectedIndex);
		            
		        	int option = JOptionPane.showConfirmDialog(panelPriView, "Bạn có muốn xóa không?");
		        	
		            System.out.println("option : " + option);
		            
		            if(option == 0) {
		                StudentsModify.delete(std.getStt());
		                
		                showStudents();
		            }
		        }
			}
		});
		btnXoaStudents.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnXoaStudents.setBounds(240, 499, 89, 35);
		panelStudentsInfor.add(btnXoaStudents);
		
		JLabel lblNhapMssv = new JLabel("Nhập ID Lớp");
		lblNhapMssv.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNhapMssv.setBounds(471, 5, 145, 26);
		panelStudents.add(lblNhapMssv);
		
		txtNhpMssv = new JTextField();
		txtNhpMssv.setToolTipText("Nhập ID lớp để tìm kiếm");
		txtNhpMssv.setBounds(626, 5, 256, 26);
		panelStudents.add(txtNhpMssv);
		txtNhpMssv.setColumns(10);
		
		JButton btnFindStudents = new JButton("Tìm");
		btnFindStudents.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnFindStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String input = txtNhpMssv.getText();
			        if(input != null && input.length() > 0) {
			            studentList = StudentsModify.findLop(input);
			            
			            tableModel.setRowCount(0);
			        
			            studentList.forEach((student) -> {
			                tableModel.addRow(new Object[] {tableModel.getRowCount() + 1, 
			                		student.getIDLop(), 
			                		student.getTenLop(), 
			                		student.getKhoaHoc()});
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
}
