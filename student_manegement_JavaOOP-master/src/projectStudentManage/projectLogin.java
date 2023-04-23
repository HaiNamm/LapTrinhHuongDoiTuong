package projectStudentManage;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class projectLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textUsername;
	private JTextField textPassword;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                projectLogin frame = new projectLogin();
	                frame.setLocationRelativeTo(null);
	                frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}

	/**
	 * Create the frame.
	 */
	public projectLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBounds(0, 0, 434, 261);
		contentPane.add(panelLogin);
		panelLogin.setLayout(null);
		
		JLabel lblUsername = new JLabel("Tên tài khoản");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblUsername.setBounds(73, 70, 100, 24);
		panelLogin.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Mật khẩu");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblPassword.setBounds(73, 122, 82, 24);
		panelLogin.add(lblPassword);
		
		textUsername = new JTextField();
		textUsername.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		textUsername.setBounds(192, 70, 170, 24);
		panelLogin.add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JPasswordField();
		textPassword.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		textPassword.setColumns(10);
		textPassword.setBounds(192, 122, 170, 24);
		panelLogin.add(textPassword);
		
		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textUsername.getText();
				String pass = textPassword.getText();
				
				if (user.equals("admin") && pass.equals("nhom8")) {
					dispose();
					
					projectFrame info = new projectFrame();
					info.main(null);
					
				} else {
					JOptionPane.showMessageDialog(panelLogin, "Đăng nhập thất bại! Vui lòng kiểm tra lại thông tin tài khoản");
					textPassword.setText(null);
				}
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnLogin.setBounds(167, 187, 100, 27);
		panelLogin.add(btnLogin);
		
		//JPanel panelIcon = new JPanel();
		//panelIcon.setBounds(177, 10, 80, 80);
		//panelLogin.add(panelIcon);
		//ImageIcon icon = new ImageIcon("C:\\Users\\buile\\eclipse-workspace\\studentManagement\\src\\projectStudentManage\\logo.jpg");
		//panelLogin.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
		//JLabel labelIcon = new JLabel(icon);
		//panelLogin.add(labelIcon);

	}
}
