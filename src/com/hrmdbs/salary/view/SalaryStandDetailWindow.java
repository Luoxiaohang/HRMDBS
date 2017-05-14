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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.hrmdbs.salary.bean.SalaryStand;

public class SalaryStandDetailWindow {

	private JFrame frame;
	private JTextField jtf_salarySatndId;
	private JTextField jtf_salaryStandName;
	private JTextField jtf_totalMoney;
	private JTextField jtf_formulater;
	private JTextField jtf_registor;
	private JTextField jtf_registTime;
	private JTable jt_salaryItem;
	private Object[][] salaryItem = new Object[8][3];
	private TableModel tableModel;
	private JButton jb_commit;
	private ArrayList<SalaryStand> sss;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalaryStandDetailWindow window = new SalaryStandDetailWindow(
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
	public SalaryStandDetailWindow(ArrayList<SalaryStand> sss) {
		this.sss = sss;
		initData();
		initialize();
		iniListener();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 547, 325);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 93, 54, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel jl_location = new JLabel("\u5F53\u524D\u4F4D\u7F6E\uFF1A");
		GridBagConstraints gbc_jl_location = new GridBagConstraints();
		gbc_jl_location.anchor = GridBagConstraints.WEST;
		gbc_jl_location.gridwidth = 5;
		gbc_jl_location.insets = new Insets(0, 0, 5, 5);
		gbc_jl_location.gridx = 0;
		gbc_jl_location.gridy = 0;
		panel.add(jl_location, gbc_jl_location);

		jb_commit = new JButton("\u8FD4\u56DE");
		GridBagConstraints gbc_jb_commit = new GridBagConstraints();
		gbc_jb_commit.gridx = 14;
		gbc_jb_commit.gridy = 1;
		panel.add(jb_commit, gbc_jb_commit);

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

		jtf_salarySatndId = new JTextField(String.valueOf(sss.get(0).getId()));
		jtf_salarySatndId.setBounds(85, 7, 89, 21);
		panel_1.add(jtf_salarySatndId);
		jtf_salarySatndId.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("\u85AA\u916C\u603B\u989D");
		lblNewLabel_4.setBounds(380, 10, 54, 15);
		panel_1.add(lblNewLabel_4);

		jtf_salaryStandName = new JTextField(sss.get(0).getSalaryRegistInfo()
				.getSalaryStandName());
		jtf_salaryStandName.setBounds(264, 7, 89, 21);
		panel_1.add(jtf_salaryStandName);
		jtf_salaryStandName.setColumns(10);

		jtf_totalMoney = new JTextField(String.valueOf(sss.get(0)
				.getSalaryRegistInfo().getTotalMoney()));
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

		jtf_formulater = new JTextField(sss.get(0).getSalaryRegistInfo()
				.getSalaryFormulater());
		jtf_formulater.setColumns(10);
		jtf_formulater.setBounds(85, 34, 89, 21);
		panel_1.add(jtf_formulater);

		jtf_registor = new JTextField(sss.get(0).getSalaryRegistInfo()
				.getSalaryRegistor());
		jtf_registor.setColumns(10);
		jtf_registor.setBounds(264, 34, 89, 21);
		panel_1.add(jtf_registor);

		jtf_registTime = new JTextField(sss.get(0).getSalaryRegistInfo()
				.getSalaryRegistTime());
		jtf_registTime.setColumns(10);
		jtf_registTime.setBounds(432, 34, 90, 21);
		panel_1.add(jtf_registTime);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 512, 176);
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
		frame.setVisible(true);

	}

	private void iniListener() {
		jb_commit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
	}

	private void initData() {
		for (int i = 0; i < sss.size(); i++) {
			salaryItem[i][0] = i;
			salaryItem[i][1] = sss.get(i).getSalaryItem().getSalaryItemName();
			salaryItem[i][2] = sss.get(i).getMoney();
		}
	}

	// private void getRegistInfo(String salaryStandName) {
	// sri = SalaryService.getSlaryStand(salaryStandName);
	// }
}
