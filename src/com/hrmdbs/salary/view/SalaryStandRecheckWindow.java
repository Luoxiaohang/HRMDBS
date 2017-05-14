package com.hrmdbs.salary.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.hrmdbs.salary.bean.SalaryRegistInfo;
import com.hrmdbs.salary.bean.SalaryStand;
import com.hrmdbs.service.SalaryService;

import javax.swing.JTextArea;

public class SalaryStandRecheckWindow {

	private JFrame frame;
	private JTextField jtf_salarySatndId;
	private JTextField jtf_salaryStandName;
	private JTextField jtf_totalMoney;
	private JTextField jtf_formulater;
	private JTextField jtf_registor;
	private JTextField jtf_registTime;
	private JTable jt_salaryItem;
	ArrayList<SalaryStand> salaryStands = null;
	private Object[][] salaryItem = new Object[8][3];
	private TableModel tableModel;
	private JButton jb_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalaryStandRecheckWindow window = new SalaryStandRecheckWindow(
							null);
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
	public SalaryStandRecheckWindow(ArrayList<SalaryStand> salaryStands) {
		this.salaryStands = salaryStands;
		initialize();
		initData();
		iniListener();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u85AA\u916C\u6807\u51C6\u590D\u6838");
		frame.setBounds(100, 100, 549, 385);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel jl_location = new JLabel(
				"\u5F53\u524D\u4F4D\u7F6E\uFF1A\u85AA\u916C\u6807\u51C6\u590D\u6838");
		panel.add(jl_location, BorderLayout.NORTH);

		jb_pass = new JButton("\u590D\u6838\u901A\u8FC7");
		panel.add(jb_pass, BorderLayout.EAST);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u85AA\u916C\u6807\u51C6\u7F16\u53F7");
		lblNewLabel.setBounds(10, 10, 78, 15);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel(
				"\u85AA\u916C\u6807\u51C6\u540D\u79F0");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(184, 10, 78, 15);
		panel_1.add(lblNewLabel_2);

		jtf_salarySatndId = new JTextField();
		jtf_salarySatndId.setBounds(85, 7, 89, 21);
		panel_1.add(jtf_salarySatndId);
		jtf_salarySatndId.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("\u85AA\u916C\u603B\u989D");
		lblNewLabel_4.setBounds(380, 10, 54, 15);
		panel_1.add(lblNewLabel_4);

		jtf_salaryStandName = new JTextField();
		jtf_salaryStandName.setBounds(264, 7, 89, 21);
		panel_1.add(jtf_salaryStandName);
		jtf_salaryStandName.setColumns(10);

		jtf_totalMoney = new JTextField();
		jtf_totalMoney.setBounds(432, 7, 90, 21);
		panel_1.add(jtf_totalMoney);
		jtf_totalMoney.setColumns(10);

		JLabel label = new JLabel("\u5236\u5B9A\u4EBA");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 37, 78, 15);
		panel_1.add(label);

		JLabel label_1 = new JLabel("\u767B\u8BB0\u4EBA");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(184, 37, 78, 15);
		panel_1.add(label_1);

		JLabel label_2 = new JLabel("\u767B\u8BB0\u65F6\u95F4");
		label_2.setBounds(380, 37, 54, 15);
		panel_1.add(label_2);

		jtf_formulater = new JTextField();
		jtf_formulater.setColumns(10);
		jtf_formulater.setBounds(85, 34, 89, 21);
		panel_1.add(jtf_formulater);

		jtf_registor = new JTextField();
		jtf_registor.setColumns(10);
		jtf_registor.setBounds(264, 34, 89, 21);
		panel_1.add(jtf_registor);

		jtf_registTime = new JTextField();
		jtf_registTime.setColumns(10);
		jtf_registTime.setBounds(432, 34, 90, 21);
		panel_1.add(jtf_registTime);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 118, 512, 176);
		panel_1.add(scrollPane);

		jt_salaryItem = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scrollPane.setViewportView(jt_salaryItem);
		tableModel = new DefaultTableModel(salaryItem, new String[] { "序号",
				"薪酬项目名称", "金额" });
		jt_salaryItem.setModel(tableModel);
		jt_salaryItem.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		JLabel lblNewLabel_1 = new JLabel("\u590D\u6838\u610F\u89C1");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 62, 68, 46);
		panel_1.add(lblNewLabel_1);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(85, 65, 437, 43);
		panel_1.add(textArea);
		frame.setVisible(true);
	}

	private void iniListener() {
		jb_pass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (SalaryService.updateSalaryStand(salaryStands)) {
					JOptionPane.showMessageDialog(null, "复核成功", null,
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}

	private void initData() {
		for (int i = 0; null != salaryStands && i < salaryStands.size(); i++) {
			jtf_salarySatndId.setText(String.valueOf(salaryStands.get(i)
					.getSalaryRegistInfo().getId()));
			jtf_salaryStandName.setText(String.valueOf(salaryStands.get(i)
					.getSalaryRegistInfo().getSalaryStandName()));
			jtf_totalMoney.setText(String.valueOf(salaryStands.get(i)
					.getSalaryRegistInfo().getTotalMoney()));
			jtf_formulater.setText(String.valueOf(salaryStands.get(i)
					.getSalaryRegistInfo().getSalaryFormulater()));
			jtf_registor.setText(String.valueOf(salaryStands.get(i)
					.getSalaryRegistInfo().getSalaryRegistor()));
			jtf_registTime.setText(String.valueOf(salaryStands.get(i)
					.getSalaryRegistInfo().getSalaryRegistTime()));

			salaryItem[i][0] = i;
			salaryItem[i][1] = salaryStands.get(i).getSalaryItem()
					.getSalaryItemName();
			salaryItem[i][2] = salaryStands.get(i).getMoney();
		}
		tableModel = new DefaultTableModel(salaryItem, new String[] { "序号",
				"薪酬项目名称", "金额" });
		jt_salaryItem.setModel(tableModel);
	}

	private void getSlaryStand(String salaryStandName) {
		salaryStands = SalaryService.getSlaryStand(salaryStandName);
	}
}
