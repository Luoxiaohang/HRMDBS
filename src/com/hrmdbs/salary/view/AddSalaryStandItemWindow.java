package com.hrmdbs.salary.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.hrmdbs.dao.SalaryDao;
import com.hrmdbs.salary.bean.SalaryItem;
import com.hrmdbs.service.SalaryService;

public class AddSalaryStandItemWindow {

	private JFrame frame;
	private JTextField jtf_name;
	private JTextField jtf_scale;
	private JButton jb_cancle;
	private JButton jb_commit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSalaryStandItemWindow window = new AddSalaryStandItemWindow();
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
	public AddSalaryStandItemWindow() {
		initialize();
		iniListener();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u6DFB\u52A0\u85AA\u916C\u9879\u76EE");
		frame.getContentPane().setFont(new Font("宋体", Font.PLAIN, 9));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\u85AA\u916C\u9879\u76EE\u540D\u79F0");
		lblNewLabel.setBounds(98, 73, 78, 15);
		frame.getContentPane().add(lblNewLabel);

		jtf_name = new JTextField();
		jtf_name.setBounds(209, 70, 102, 21);
		frame.getContentPane().add(jtf_name);
		jtf_name.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u5360\u57FA\u672C\u6BD4\u4F8B");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(98, 112, 78, 15);
		frame.getContentPane().add(lblNewLabel_1);

		jtf_scale = new JTextField();
		jtf_scale.setBounds(209, 109, 102, 21);
		frame.getContentPane().add(jtf_scale);
		jtf_scale.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel(
				"(\u4E0D\u8BBE\u7F6E\u5219\u9700\u8981\u52A8\u6001\u8BBE\u5B9A)");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 9));
		lblNewLabel_2.setBounds(314, 113, 102, 15);
		frame.getContentPane().add(lblNewLabel_2);

		jb_commit = new JButton("\u786E\u8BA4");
		jb_commit.setBounds(98, 169, 93, 23);
		frame.getContentPane().add(jb_commit);

		jb_cancle = new JButton("\u53D6\u6D88");
		jb_cancle.setBounds(218, 169, 93, 23);
		frame.getContentPane().add(jb_cancle);
		frame.setVisible(true);
	}

	private void iniListener() {
		jb_commit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String name = jtf_name.getText().trim();
				if (null != name && name.length() != 0) {
					SalaryItem si = new SalaryItem();
					si.setSalaryItemName(name);
					String scales = jtf_scale.getText().trim();
					if (null != scales && scales.length() != 0) {
						si.setScaleOnSalary((Float.valueOf(scales)) * 0.01f);
						si.setScaleAble(true);
					} else {
						si.setScaleAble(false);
					}
					if (SalaryService.addSalaryItem(si)) {
						JOptionPane.showMessageDialog(frame, "添加成功！");
					} else {
						JOptionPane.showMessageDialog(frame, "添加失败！！", null,
								JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});

	}
}
