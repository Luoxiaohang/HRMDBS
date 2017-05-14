package com.hrmdbs.archive.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.hrmdbs.archive.bean.Employee;
import com.hrmdbs.archive.bean.Manager;
import com.hrmdbs.service.EmployeeService;

public class RegistManagerWindow {

	private JFrame frame;
	private JTextField jtf_hrid;
	private JTextField jtf_name;
	private JTextField jtf_password;
	private JButton jb_cancle;
	private JButton jb_confirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistManagerWindow window = new RegistManagerWindow();
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
	public RegistManagerWindow() {
		initialize();
		initListener();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u7BA1\u7406\u5458\u6CE8\u518C");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\u5458\u5DE5\u7F16\u53F7");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(133, 70, 54, 15);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(142, 108, 45, 15);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(133, 146, 54, 15);
		frame.getContentPane().add(lblNewLabel_2);

		jtf_hrid = new JTextField();
		jtf_hrid.setBounds(210, 67, 88, 21);
		frame.getContentPane().add(jtf_hrid);
		jtf_hrid.setColumns(10);

		jtf_name = new JTextField();
		jtf_name.setBounds(210, 105, 88, 21);
		frame.getContentPane().add(jtf_name);
		jtf_name.setColumns(10);

		jtf_password = new JTextField();
		jtf_password.setBounds(210, 143, 88, 21);
		frame.getContentPane().add(jtf_password);
		jtf_password.setColumns(10);

		jb_confirm = new JButton("\u6CE8\u518C");
		jb_confirm.setBounds(232, 190, 66, 23);
		frame.getContentPane().add(jb_confirm);

		jb_cancle = new JButton("\u53D6\u6D88");
		jb_cancle.setBounds(121, 190, 66, 23);
		frame.getContentPane().add(jb_cancle);
		frame.setVisible(true);
	}

	private void initListener() {
		jb_cancle.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		jb_confirm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Manager manager = new Manager();

				String userName = jtf_name.getText().toString().trim();
				String password = jtf_password.getText().toString().trim();
				String hrid = jtf_hrid.getText().toString().trim();
				if (userName.length() == 0 || password.length() == 0
						|| hrid.length() == 0) {
					JOptionPane.showMessageDialog(null, "信息没有填充完整哦！", null,
							JOptionPane.ERROR_MESSAGE);
				} else {
					manager.setPassword(userName);
					manager.setUserName(password);
					Employee employee = new Employee();
					employee.setHrid(hrid);
					manager.setEmployee(employee);
					if (EmployeeService.registManager(manager)) {
						JOptionPane.showMessageDialog(null, "注册成功", null,
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null,
								"您输入的用户不存在或处于未审核状态，请先注册基本信息或请求人事经理通过审核！！",
								null, JOptionPane.ERROR_MESSAGE);
					}

				}

			}
		});

	}
}
