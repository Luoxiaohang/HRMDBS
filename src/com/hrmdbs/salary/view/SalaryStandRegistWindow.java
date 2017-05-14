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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.hrmdbs.constant.Constant;
import com.hrmdbs.salary.bean.SalaryItem;
import com.hrmdbs.salary.bean.SalaryRegistInfo;
import com.hrmdbs.salary.bean.SalaryStand;
import com.hrmdbs.service.SalaryService;
import com.hrmdbs.utils.DateUtils;
import javax.swing.BoxLayout;

public class SalaryStandRegistWindow {

	private JFrame frame;
	private JTextField jtf_salarySatndId;
	private JTextField jtf_salaryStandName;
	private JTextField jtf_totalMoney;
	private JTextField jtf_formulater;
	private JTextField jtf_registor;
	private JTextField jtf_registTime;
	private JTable jt_salaryItem;
	ArrayList<SalaryItem> salaryItems = null;
	private Object[][] salaryItem = new Object[15][3];
	private TableModel tableModel;
	private JButton jb_commit;
	private ArrayList<SalaryStand> sri;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalaryStandRegistWindow window = new SalaryStandRegistWindow();
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
	public SalaryStandRegistWindow() {
		initData();
		initialize();
		iniListener();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u85AA\u916C\u6807\u51C6\u6CE8\u518C");
		frame.setBounds(100, 100, 544, 328);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel jl_location = new JLabel(
				"\u5F53\u524D\u4F4D\u7F6E\uFF1A\u85AA\u916C\u6807\u51C6\u6CE8\u518C");
		panel.add(jl_location, BorderLayout.NORTH);

		jb_commit = new JButton("\u63D0\u4EA4");
		panel.add(jb_commit, BorderLayout.EAST);

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
		jtf_totalMoney.setEditable(false);
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

		jtf_registTime = new JTextField(DateUtils.getDate(Constant.Date_YMD));
		jtf_registTime.setEditable(false);
		jtf_registTime.setColumns(10);
		jtf_registTime.setBounds(432, 34, 90, 21);
		panel_1.add(jtf_registTime);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 512, 161);
		panel_1.add(scrollPane);

		jt_salaryItem = new JTable() {
			public boolean isCellEditable(int row, int column) {
				if (column != 2) {
					return false;
				} else {
					if (null != salaryItems && salaryItems.size() != 0
							&& !salaryItems.get(row).isScaleAble()) {
						return true;
					} else {
						return false;
					}
					// return true;
				}
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
		tableModel.addTableModelListener(new TableModelListener() {
			public void tableChanged(TableModelEvent e) {
				// 得到修改单元格的行和列
				int col = e.getColumn();
				int row = e.getFirstRow();
				String changedContent = salaryItems.get(row)
						.getSalaryItemName();
				// 如果修改的是基本工资,则修改其他相应的值
				float totalMoney = 0;
				for (int k = 0; k < salaryItems.size(); k++) {
					String money = jt_salaryItem.getValueAt(k, 2).toString()
							.trim();
					if (null != money && money.length() != 0) {
						totalMoney = totalMoney
								+ Float.valueOf(jt_salaryItem.getValueAt(k, 2)
										.toString().trim());
					}
				}
				jtf_totalMoney.setText("" + totalMoney);
				if (changedContent.equals("基本工资")) {
					float number = Float.valueOf(jt_salaryItem
							.getValueAt(row, col).toString().trim());
					for (int i = 0; i < salaryItems.size(); i++) {
						if (salaryItems.get(i).isScaleAble()) {
							float scale = salaryItems.get(i).getScaleOnSalary();
							float result = number * scale;
							jt_salaryItem.setValueAt(result, i, 2);
						}
					}
				}
			}
		});
		jb_commit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SalaryRegistInfo sritemp = new SalaryRegistInfo();
				sritemp.setReChecked(false);
				sritemp.setSalaryFormulater(jtf_formulater.getText().trim());
				sritemp.setSalaryRegistor(jtf_registor.getText().trim());
				sritemp.setSalaryStandName(jtf_salaryStandName.getText().trim());
				sritemp.setSalaryRegistTime(DateUtils
						.getDate(Constant.Date_YMD));
				sritemp.setTotalMoney(Float.valueOf(jtf_totalMoney.getText()
						.trim()));
				ArrayList<SalaryStand> sss = new ArrayList<SalaryStand>();
				for (int i = 0; i < salaryItems.size(); i++) {
					SalaryStand ss = new SalaryStand();
					ss.setSalaryRegistInfo(sritemp);
					ss.setSalaryItem(salaryItems.get(i));
					ss.setMoney(Float.valueOf(jt_salaryItem.getValueAt(i, 2)
							.toString().trim()));
					sss.add(ss);
				}
				if (SalaryService.addSalaryStand(sss)) {
					JOptionPane.showMessageDialog(null, "提交成功", null,
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "提交失败！！", null,
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	private void initData() {

		salaryItems = SalaryService.getAllSalaryItem();
		for (int i = 0; i < salaryItems.size(); i++) {
			salaryItem[i][0] = i;
			salaryItem[i][1] = salaryItems.get(i).getSalaryItemName();
			salaryItem[i][2] = " ";
		}
	}

	private void getRegistInfo(String salaryStandName) {
		sri = SalaryService.getSlaryStand(salaryStandName);
	}
}
