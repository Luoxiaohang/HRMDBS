package com.hrmdbs.archive.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.hrmdbs.constant.Constant;
import com.hrmdbs.service.EmployeeService;

public class LoginWindow {

	private JFrame frame;
	private JTextField jtf_name;
	private JTextField jtf_password;
	private JButton jb_login;
	private JButton jb_regist;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
		initListener();
	}

	private void initListener() {
		jb_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = jtf_name.getText().trim();
				String password = jtf_password.getText().trim();
				if (userName.length() == 0 || password.length() == 0) {
					JOptionPane.showMessageDialog(null, "请输入用户名或者密码！", null,
							JOptionPane.ERROR_MESSAGE);
				} else {
					int state = EmployeeService.login(userName, password);
					switch (state) {
					case Constant.HRMANAGER:
					case Constant.HRSPECIALIST:
					case Constant.SALARYMANAGER:
					case Constant.SALARYSPECIALIST:
						new AppWindow();
						// 记录当前登录用户的身份
						Constant.setCURRENTROLE(state);

						LoginWindow.this.frame.dispose();
						break;
					default:
						JOptionPane.showMessageDialog(null, "用户名或者密码错误！", null,
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		jb_regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegistManagerWindow();
			}

		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u4EBA\u529B\u8D44\u6E90\u6863\u6848\u7BA1\u7406");
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(128, 80, 47, 15);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(128, 120, 47, 15);
		frame.getContentPane().add(lblNewLabel_2);

		jtf_name = new JTextField();
		jtf_name.setBounds(206, 77, 101, 21);
		frame.getContentPane().add(jtf_name);
		jtf_name.setColumns(10);

		jtf_password = new JTextField();
		jtf_password.setBounds(206, 117, 101, 21);
		frame.getContentPane().add(jtf_password);
		jtf_password.setColumns(10);

		jb_login = new JButton("\u767B\u5F55");
		jb_login.setBounds(235, 164, 66, 23);
		frame.getContentPane().add(jb_login);

		jb_regist = new JButton("\u6CE8\u518C");
		jb_regist.setBounds(136, 164, 66, 23);
		frame.getContentPane().add(jb_regist);
	}
}
