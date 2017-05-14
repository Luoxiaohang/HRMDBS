package com.hrmdbs.salary.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.hrmdbs.archive.bean.ThirdOrganization;
import com.hrmdbs.constant.Constant;
import com.hrmdbs.salary.bean.Bonus;
import com.hrmdbs.service.OrganizationService;

public class PayrollWindow {

	private JFrame frame;
	private JButton jb_recheck;
	private JButton jb_regist;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayrollWindow window = new PayrollWindow();
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
	public PayrollWindow() {
		initialize();
		iniListener();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u85AA\u916C\u53D1\u653E\u7BA1\u7406");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		jb_recheck = new JButton("\u85AA\u916C\u53D1\u653E\u590D\u6838");
		jb_recheck.setBounds(152, 149, 127, 23);
		frame.getContentPane().add(jb_recheck);

		jb_regist = new JButton("\u85AA\u916C\u53D1\u653E\u767B\u8BB0");
		jb_regist.setBounds(152, 79, 127, 23);
		frame.getContentPane().add(jb_regist);
		frame.setVisible(true);
	}

	private void iniListener() {
		jb_recheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Constant.getCURRENTROLE() == Constant.SALARYMANAGER) {
					HashMap<ThirdOrganization, ArrayList<Bonus>> employees = OrganizationService
							.findSalaryUnCheckedEmployees();
					if (null != employees && employees.size() != 0) {
						new PayrollReCheckWindow(employees);
					} else {
						JOptionPane.showMessageDialog(null, "暂无待复核的记录哦！！",
								null, JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "对不起，您没有权限进行此操作！！",
							null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		jb_regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Constant.getCURRENTROLE() == Constant.SALARYSPECIALIST) {
					new PayrollRegistWindow();
				} else {
					JOptionPane.showMessageDialog(null, "对不起，您没有权限进行此操作！！",
							null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}
}
