package com.hrmdbs.salary.view;

import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hrmdbs.salary.bean.Bonus;
import com.hrmdbs.salary.bean.SalaryStand;
import com.hrmdbs.service.SalaryService;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PayrollRecheckDetailWindow extends JFrame {
	ArrayList<Bonus> sris = null;
	String[][] info = new String[10][12];
	private JTextField textField;
	private JTable jt;
	private JButton jb_commit;

	public PayrollRecheckDetailWindow(ArrayList<Bonus> arrayList) {
		this.sris = arrayList;
		initDate();
		initWindow();
		initListener();
	}

	/**
	 * @param args
	 */

	private void initWindow() {
		Container c = getContentPane();
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 10, 54, 15);
		getContentPane().add(lblNewLabel);

		jb_commit = new JButton("\u63D0\u4EA4");
		jb_commit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jb_commit.setBounds(716, 33, 75, 23);
		getContentPane().add(jb_commit);

		JLabel lblNewLabel_1 = new JLabel(
				"\u85AA\u916C\u53D1\u653E\u5355\u53F7\uFF1A");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 62, 93, 15);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u673A\u6784\uFF1A");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(186, 62, 41, 15);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u603B\u4EBA\u6570\uFF1A");
		lblNewLabel_3.setBounds(10, 87, 54, 15);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u767B\u8BB0\u4EBA\uFF1A");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 112, 54, 15);
		getContentPane().add(lblNewLabel_4);

		textField = new JTextField();
		textField.setBounds(75, 109, 83, 21);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel jl_number = new JLabel("5");
		jl_number.setBounds(52, 87, 12, 15);
		getContentPane().add(jl_number);

		JLabel lblNewLabel_6 = new JLabel("\u4EBA");
		lblNewLabel_6.setBounds(65, 87, 18, 15);
		getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_5 = new JLabel(
				"\uFF0C\u57FA\u672C\u85AA\u916C\u603B\u989D\uFF1A");
		lblNewLabel_5.setBounds(84, 87, 103, 15);
		getContentPane().add(lblNewLabel_5);

		JLabel jl_totalMoney = new JLabel("170745.00");
		jl_totalMoney.setBounds(186, 87, 54, 15);
		getContentPane().add(jl_totalMoney);

		JLabel lblNewLabel_7 = new JLabel("\u5B9E\u53D1\u603B\u989D\uFF1A");
		lblNewLabel_7.setBounds(260, 87, 66, 15);
		getContentPane().add(lblNewLabel_7);

		JLabel jl_factTotalMoney = new JLabel("");
		jl_factTotalMoney.setBounds(322, 87, 54, 15);
		getContentPane().add(jl_factTotalMoney);

		JLabel lblNewLabel_8 = new JLabel("SG1000000002");
		lblNewLabel_8.setBounds(96, 62, 103, 15);
		getContentPane().add(lblNewLabel_8);

		JLabel jl_organization = new JLabel(
				"\u96C6\u56E2/\u8F6F\u4EF6\u516C\u53F8/\u6D4B\u8BD5\u7EC4");
		jl_organization.setBounds(225, 62, 138, 15);
		getContentPane().add(jl_organization);
		String[] columnNames = new String[] { "档案编号", "姓名", "基本工资", "交通补助",
				"午餐补助", "通信补助", "养老保险", "失业保险", "医疗保险", "住房公积金", "奖励奖金", "应扣奖金" };

		final DefaultTableModel m_data = new DefaultTableModel(info,
				columnNames);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 137, 793, 191);
		getContentPane().add(scrollPane);

		jt = new JTable() {
			boolean[] columnEditables = new boolean[] { false, false, false,
					false, false, false, false, false, false, false, true, true };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};

		scrollPane.setViewportView(jt);

		jt.setModel(m_data);

		JLabel lblNewLabel_9 = new JLabel("\u767B\u8BB0\u65E5\u671F\uFF1A");
		lblNewLabel_9.setBounds(643, 100, 66, 15);
		getContentPane().add(lblNewLabel_9);

		JLabel jl_date = new JLabel("2016-01-02");
		jl_date.setBounds(716, 100, 86, 15);
		getContentPane().add(jl_date);
		jt.getColumnModel().getColumn(0).setPreferredWidth(100);
		jt.getColumnModel().getColumn(0).setMinWidth(100);
		jt.getColumnModel().getColumn(9).setMinWidth(50);

		setSize(819, 366);
		setResizable(false);
		setLocation(500, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new PayrollRecheckDetailWindow(null);
	}

	private void initDate() {
		for (int i = 0; i < sris.size(); i++) {
			info[i][0] = sris.get(i).getEmployee().getHrid();
			info[i][1] = sris.get(i).getEmployee().getName();
			ArrayList<SalaryStand> sss = SalaryService
					.getSlaryStand(sris.get(i).getEmployee().getSalaryStand()
							.getSalaryStandName());
			for (int k = 0; null != sss && k < sss.size(); k++) {
				info[i][k + 2] = String.valueOf(sss.get(k).getMoney());
			}
			info[i][10] = "" + sris.get(i).getBonus();
			info[i][11] = "" + sris.get(i).getDeductedBonus();
		}
	}

	private void initListener() {
		jb_commit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < sris.size(); i++) {
					sris.get(i).setRechecked(true);
				}
				if (SalaryService.updateBonus(sris)) {
					JOptionPane.showMessageDialog(null, "复核成功！", null,
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "复核失败！", null,
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});

	}
}
