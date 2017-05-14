package com.hrmdbs.archive.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.hrmdbs.constant.Constant;
import com.hrmdbs.salary.view.PayrollWindow;
import com.hrmdbs.salary.view.SalaryStandWindow;

public class AppWindow {

	private JFrame frame;
	private JButton jb_HRManager;
	private JButton jb_Setting;
	private JButton jb_salaryStand;
	private JButton jb_payroll;
	private JButton jb_finance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWindow window = new AppWindow();
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
	public AppWindow() {
		initialize();
		iniListener();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		jb_HRManager = new JButton(
				"\u4EBA\u529B\u8D44\u6E90\u6863\u6848\u7BA1\u7406");
		jb_HRManager.setBounds(42, 104, 147, 23);
		frame.getContentPane().add(jb_HRManager);

		jb_Setting = new JButton("\u7CFB\u7EDF\u8BBE\u7F6E");
		jb_Setting.setBounds(145, 35, 147, 23);
		frame.getContentPane().add(jb_Setting);

		jb_salaryStand = new JButton("\u85AA\u916C\u6807\u51C6\u7BA1\u7406");
		jb_salaryStand.setBounds(244, 104, 147, 23);
		frame.getContentPane().add(jb_salaryStand);

		jb_payroll = new JButton("\u85AA\u916C\u53D1\u653E\u7BA1\u7406");
		jb_payroll.setBounds(42, 170, 147, 23);
		frame.getContentPane().add(jb_payroll);

		jb_finance = new JButton("\u8D22\u52A1\u7CFB\u7EDF");
		jb_finance.setBounds(244, 170, 147, 23);
		frame.getContentPane().add(jb_finance);
		frame.setVisible(true);
	}

	private void iniListener() {
		jb_finance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "对不起，此功能暂不能使用！", null,
						JOptionPane.ERROR_MESSAGE);
			}
		});
		jb_HRManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (Constant.getCURRENTROLE()) {
				case Constant.HRMANAGER:
				case Constant.HRSPECIALIST:
					new HRManageWindow();
					break;
				default:
					JOptionPane.showMessageDialog(null, "对不起，您没有相应的权限！", null,
							JOptionPane.ERROR_MESSAGE);
					break;
				}
			}
		});
		jb_payroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (Constant.getCURRENTROLE()) {
				case Constant.SALARYMANAGER:
				case Constant.SALARYSPECIALIST:
					new PayrollWindow();
					break;
				default:
					JOptionPane.showMessageDialog(null, "对不起，您没有相应的权限！", null,
							JOptionPane.ERROR_MESSAGE);
					break;
				}
			}
		});
		jb_Setting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (Constant.getCURRENTROLE()) {
				case Constant.SALARYMANAGER:
				case Constant.HRMANAGER:
					new SettingWindow();
					break;
				default:
					JOptionPane.showMessageDialog(null, "对不起，您没有相应的权限！", null,
							JOptionPane.ERROR_MESSAGE);
					break;
				}
			}
		});
		jb_salaryStand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (Constant.getCURRENTROLE()) {
				case Constant.SALARYMANAGER:
				case Constant.SALARYSPECIALIST:
					new SalaryStandWindow();
					break;
				default:
					JOptionPane.showMessageDialog(null, "对不起，您没有相应的权限！", null,
							JOptionPane.ERROR_MESSAGE);
					break;
				}
			}
		});

	}
}
