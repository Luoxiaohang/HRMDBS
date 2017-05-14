package com.hrmdbs.archive.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.hrmdbs.archive.bean.Employee;
import com.hrmdbs.constant.Constant;
import com.hrmdbs.service.EmployeeService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class HRManageWindow {

	private JFrame frame;
	private JButton jb_recover;
	private JButton jb_query;
	private JButton jb_reCheck;
	private JButton jb_delete;
	private JButton jb_regist;
	private JButton jb_update;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HRManageWindow window = new HRManageWindow();
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
	public HRManageWindow() {
		initialize();
		initLisntener();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u4EBA\u529B\u8D44\u6E90\u6863\u6848\u7BA1\u7406");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		jb_reCheck = new JButton(
				"\u4EBA\u529B\u8D44\u6E90\u6863\u6848\u590D\u6838");

		jb_reCheck.setBounds(61, 175, 140, 23);
		frame.getContentPane().add(jb_reCheck);

		jb_delete = new JButton(
				"\u4EBA\u529B\u8D44\u6E90\u6863\u6848\u5220\u9664");

		jb_delete.setBounds(61, 109, 140, 23);
		frame.getContentPane().add(jb_delete);

		jb_query = new JButton(
				"\u4EBA\u529B\u8D44\u6E90\u6863\u6848\u67E5\u8BE2");
		jb_query.setBounds(61, 48, 140, 23);
		frame.getContentPane().add(jb_query);

		jb_recover = new JButton(
				"\u6062\u590D\u5220\u9664\u6863\u6848\u8BB0\u5F55");
		jb_recover.setBounds(238, 175, 140, 23);

		frame.getContentPane().add(jb_recover);

		jb_regist = new JButton(
				"\u4EBA\u529B\u8D44\u6E90\u6863\u6848\u767B\u8BB0");
		jb_regist.setBounds(238, 48, 140, 23);
		frame.getContentPane().add(jb_regist);

		jb_update = new JButton(
				"\u4EBA\u529B\u8D44\u6E90\u6863\u6848\u53D8\u66F4");
		jb_update.setBounds(238, 109, 140, 23);
		frame.getContentPane().add(jb_update);
		frame.setVisible(true);
	}

	private void initLisntener() {
		jb_reCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Constant.getCURRENTROLE() == Constant.HRMANAGER) {
					List<Employee> es = EmployeeService.findUnCheckedEmployee();
					if (null != es && es.size() != 0) {
						new ReCheckChooseWindow(es);
					} else {
						JOptionPane.showMessageDialog(null, "没有待复核记录！", null,
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "对不起,您没有权限！", null,
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		jb_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Constant.getCURRENTROLE() == Constant.HRMANAGER) {
					if (Constant.getCURRENTROLE() == Constant.HRMANAGER) {
						new QueryWindow(Constant.DELETE_EMPLOYEE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "对不起,您没有权限！", null,
							JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		jb_query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new QueryWindow(Constant.QUERY_EMPLOYEE);
			}
		});
		jb_recover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Constant.getCURRENTROLE() == Constant.HRMANAGER) {
					ArrayList<Employee> es = EmployeeService
							.getDeletedEmployee();
					if (null != es && es.size() != 0) {
						new ShowDeletedEmployeeWindow(es);
					} else {
						JOptionPane.showMessageDialog(null, "对不起，没有记录！！", null,
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "对不起,您没有权限！", null,
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		jb_regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Constant.getCURRENTROLE() == Constant.HRSPECIALIST) {
					new RegistWindow();
				}
			}
		});
		jb_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new QueryWindow(Constant.UPDATE_EMPLOYEE);
			}
		});
	}
}
