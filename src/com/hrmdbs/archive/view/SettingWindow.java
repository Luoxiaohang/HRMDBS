package com.hrmdbs.archive.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.hrmdbs.constant.Constant;
import com.hrmdbs.salary.view.AddSalaryStandItemWindow;

public class SettingWindow {

	private JFrame frame;
	private JButton jb_salaryStand;
	private JButton jb_archive;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SettingWindow window = new SettingWindow();
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
	public SettingWindow() {
		initialize();
		iniListener();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u7CFB\u7EDF\u8BBE\u7F6E\u754C\u9762");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		jb_salaryStand = new JButton(
				"\u85AA\u916C\u6807\u51C6\u9879\u76EE\u8BBE\u7F6E");
		jb_salaryStand.setBounds(139, 80, 142, 23);
		frame.getContentPane().add(jb_salaryStand);

		jb_archive = new JButton("\u6863\u6848\u7BA1\u7406\u8BBE\u7F6E");
		jb_archive.setBounds(139, 143, 142, 23);
		frame.getContentPane().add(jb_archive);
		frame.setVisible(true);
	}

	private void iniListener() {
		jb_archive.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (Constant.getCURRENTROLE() == Constant.HRMANAGER) {
					new AddPositionWindow();
				} else {
					JOptionPane.showMessageDialog(frame, "对不起，您没有相应的权限！", null,
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		jb_salaryStand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (Constant.getCURRENTROLE() == Constant.SALARYMANAGER) {
					new AddSalaryStandItemWindow();
				} else {
					JOptionPane.showMessageDialog(frame, "对不起，您没有相应的权限！", null,
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
