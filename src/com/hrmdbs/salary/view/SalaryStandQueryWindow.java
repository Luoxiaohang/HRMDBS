package com.hrmdbs.salary.view;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.hrmdbs.salary.bean.SalaryStand;
import com.hrmdbs.salary.bean.SalaryStandQueryBean;
import com.hrmdbs.service.SalaryService;

public class SalaryStandQueryWindow {

	private JFrame frame;
	private JTextField jtf_key;
	private JTextField jtf_salartStandId;
	private JTextField jtf_timeFrom;
	private JTextField jtf_timeTo;
	private JButton jb_query;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalaryStandQueryWindow window = new SalaryStandQueryWindow();
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
	public SalaryStandQueryWindow() {
		initialize();
		initListener();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 539, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 1.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JLabel lblNewLabel_1 = new JLabel(
				"\u5F53\u524D\u4F4D\u7F6E\uFF1A\u85AA\u916C\u6807\u51C6\u67E5\u8BE2");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.gridwidth = 8;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

		jb_query = new JButton("\u67E5\u8BE2");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 11;
		gbc_btnNewButton.gridy = 1;
		frame.getContentPane().add(jb_query, gbc_btnNewButton);

		JLabel lblNewLabel = new JLabel(
				"\u8BF7\u8F93\u5165\u85AA\u916C\u6807\u51C6\u7F16\u53F7");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		jtf_salartStandId = new JTextField();
		GridBagConstraints gbc_jtf_salartStandId = new GridBagConstraints();
		gbc_jtf_salartStandId.insets = new Insets(0, 0, 5, 5);
		gbc_jtf_salartStandId.gridwidth = 5;
		gbc_jtf_salartStandId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_salartStandId.gridx = 4;
		gbc_jtf_salartStandId.gridy = 2;
		frame.getContentPane().add(jtf_salartStandId, gbc_jtf_salartStandId);
		jtf_salartStandId.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel(
				"\u8BF7\u8F93\u5165\u5173\u952E\u5B57");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.gridwidth = 3;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtf_key = new JTextField();
		GridBagConstraints gbc_jtf_key = new GridBagConstraints();
		gbc_jtf_key.gridwidth = 5;
		gbc_jtf_key.insets = new Insets(0, 0, 5, 5);
		gbc_jtf_key.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_key.gridx = 4;
		gbc_jtf_key.gridy = 3;
		frame.getContentPane().add(jtf_key, gbc_jtf_key);
		jtf_key.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel(
				"\u8BF7\u8F93\u5165\u767B\u8BB0\u65F6\u95F4");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.gridwidth = 3;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		frame.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtf_timeFrom = new JTextField();
		GridBagConstraints gbc_jtf_timeFrom = new GridBagConstraints();
		gbc_jtf_timeFrom.gridwidth = 4;
		gbc_jtf_timeFrom.insets = new Insets(0, 0, 5, 5);
		gbc_jtf_timeFrom.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_timeFrom.gridx = 4;
		gbc_jtf_timeFrom.gridy = 4;
		frame.getContentPane().add(jtf_timeFrom, gbc_jtf_timeFrom);
		jtf_timeFrom.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("\u81F3");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 8;
		gbc_lblNewLabel_4.gridy = 4;
		frame.getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);

		jtf_timeTo = new JTextField();
		GridBagConstraints gbc_jtf_timeTo = new GridBagConstraints();
		gbc_jtf_timeTo.gridwidth = 2;
		gbc_jtf_timeTo.insets = new Insets(0, 0, 5, 5);
		gbc_jtf_timeTo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_timeTo.gridx = 9;
		gbc_jtf_timeTo.gridy = 4;
		frame.getContentPane().add(jtf_timeTo, gbc_jtf_timeTo);
		jtf_timeTo.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("(YYYY-MM-DD)");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 11;
		gbc_lblNewLabel_5.gridy = 4;
		frame.getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
	}

	private void initListener() {
		jb_query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SalaryStandQueryBean ssqb = new SalaryStandQueryBean();
				ssqb.setSalaryStandId(Integer.valueOf(jtf_salartStandId
						.getText().trim()));
				ssqb.setKey(jtf_key.getText().trim());
				ssqb.setTimeFrom(jtf_timeFrom.getText().trim());
				ssqb.setTimeTo(jtf_timeTo.getText().trim());
				HashMap<Integer, ArrayList<SalaryStand>> sss = SalaryService
						.querySalaryStand(ssqb);
				if (null == sss || sss.size() == 0) {
					JOptionPane.showMessageDialog(null, "没有查询到符合条件的薪酬标准！！",
							null, JOptionPane.ERROR_MESSAGE);
				} else {
					new QueryResultWindow(sss);
				}
			}
		});
	}
}
