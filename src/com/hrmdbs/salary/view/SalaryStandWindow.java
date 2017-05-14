package com.hrmdbs.salary.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.hrmdbs.constant.Constant;
import com.hrmdbs.salary.bean.SalaryRegistInfo;
import com.hrmdbs.salary.bean.SalaryStand;
import com.hrmdbs.service.SalaryService;

public class SalaryStandWindow {

	private JFrame frame;
	private JButton jb_regist;
	private JButton jb_recheck;
	private JButton jb_update;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalaryStandWindow window = new SalaryStandWindow();
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
	public SalaryStandWindow() {
		initialize();
		iniListener();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u85AA\u916C\u6807\u51C6\u7BA1\u7406\u754C\u9762");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		jb_regist = new JButton("\u85AA\u916C\u6807\u51C6\u767B\u8BB0");
		jb_regist.setBounds(152, 55, 127, 23);
		frame.getContentPane().add(jb_regist);

		jb_recheck = new JButton("\u85AA\u916C\u6807\u51C6\u590D\u6838");
		jb_recheck.setBounds(152, 113, 127, 23);
		frame.getContentPane().add(jb_recheck);

		jb_update = new JButton("\u85AA\u916C\u6807\u51C6\u53D8\u66F4");
		jb_update.setBounds(152, 172, 127, 23);
		frame.getContentPane().add(jb_update);
		frame.setVisible(true);
	}

	private void iniListener() {
		jb_recheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Constant.getCURRENTROLE() == Constant.SALARYMANAGER) {
					HashMap<SalaryRegistInfo, ArrayList<SalaryStand>> sss = SalaryService
							.getUncheckedSlaryRegistInfo();
					if (null != sss && sss.size() != 0) {
						new ShowUncheckSalaryWindow(sss);
					} else {
						JOptionPane.showMessageDialog(null, "暂无待复核的记录哦！！",
								null, JOptionPane.INFORMATION_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(frame, "对不起，您没有相应的权限哦！！",
							null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		jb_regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Constant.getCURRENTROLE() == Constant.SALARYSPECIALIST) {
					new SalaryStandRegistWindow();
				} else {
					JOptionPane.showMessageDialog(frame, "对不起，您没有相应的权限哦！！",
							null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		jb_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SalaryStandUpdateWindow();
			}
		});
	}
}
