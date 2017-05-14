package com.hrmdbs.salary.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hrmdbs.archive.bean.Employee;
import com.hrmdbs.archive.bean.ThirdOrganization;
import com.hrmdbs.salary.bean.SalaryStand;
import com.hrmdbs.service.OrganizationService;

public class PayrollRegistWindow extends JFrame implements MouseListener {
	HashMap<Integer, ArrayList<SalaryStand>> sris = null;
	String[][] info = new String[20][7];
	JPanel jp_up;
	JPanel jp_content;
	JLabel jl_tip;
	private JTable jt;
	private HashMap<ThirdOrganization, ArrayList<Employee>> employees;

	public PayrollRegistWindow() {
		setTitle("\u85AA\u916C\u53D1\u653E\u767B\u8BB0");
		initDate();
		initWindow();
	}

	/**
	 * @param args
	 */

	private void initWindow() {
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		// 处理上部
		jp_up = new JPanel(new BorderLayout());
		jl_tip = new JLabel("当前等待复核的人力资源档案总数：");
		jp_up.add(jl_tip, BorderLayout.SOUTH);
		c.add(jp_up, BorderLayout.NORTH);

		jp_content = new JPanel();
		String[] columnNames = new String[] { "薪酬发放单编号", "I级结构", "II级结构",
				"III级结构", "人数", "基本薪酬总额", "登记" };

		final DefaultTableModel m_data = new DefaultTableModel(info,
				columnNames);
		// 设置不可编辑
		jt = new JTable(m_data) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		jt.addMouseListener(this);
		jt.setPreferredScrollableViewportSize(new Dimension(580, 350));
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane sPane = new JScrollPane(jt);
		jp_content.add(sPane);

		c.add(jp_content, BorderLayout.CENTER);

		setSize(600, 450);
		setResizable(false);
		setLocation(500, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new PayrollRegistWindow();
	}

	private void initDate() {
		employees = OrganizationService.findEmployees();
		int i = 0;
		for (Entry<ThirdOrganization, ArrayList<Employee>> sss : employees
				.entrySet()) {
			info[i][0] = "SG100000000" + i;
			info[i][1] = sss.getKey().getSecondOrganization()
					.getTopOrganization().getTopOrganizationName();
			info[i][2] = sss.getKey().getSecondOrganization()
					.getSecondOrganizationName();
			info[i][3] = sss.getKey().getThirdOrganizationName();
			info[i][4] = String.valueOf(sss.getValue().size());
			float money = 0;
			for (Employee em : sss.getValue()) {
				money = money + em.getSalaryStand().getTotalMoney();
			}
			info[i][5] = "" + money;
			info[i][6] = "登记";
			i++;
		}
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			int selectRow = jt.getSelectedRow();
			if (null != info[selectRow][4].trim()
					&& !info[selectRow][4].trim().equals("0")) {
				int i = 0;
				for (Entry<ThirdOrganization, ArrayList<Employee>> organization : employees
						.entrySet()) {
					if (i == selectRow) {
						new PayrollRegistDetailWindow(organization.getValue());
						break;
					} else {
						i++;
					}
				}
			}
		}
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
