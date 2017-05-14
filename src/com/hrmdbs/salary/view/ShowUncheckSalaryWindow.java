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

import com.hrmdbs.salary.bean.SalaryRegistInfo;
import com.hrmdbs.salary.bean.SalaryStand;

public class ShowUncheckSalaryWindow extends JFrame implements MouseListener {
	HashMap<SalaryRegistInfo, ArrayList<SalaryStand>> sris = null;
	String[][] info = new String[20][7];
	JPanel jp_up;
	JPanel jp_content;
	JLabel jl_location;
	JLabel jl_tip;
	private JTable jt;

	public ShowUncheckSalaryWindow(
			HashMap<SalaryRegistInfo, ArrayList<SalaryStand>> es) {
		this.sris = es;
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

		jl_location = new JLabel("薪酬标准复核");
		jl_tip = new JLabel("当前等待复核的人力资源档案总数：");
		jp_up.add(jl_location, BorderLayout.NORTH);
		jp_up.add(jl_tip, BorderLayout.SOUTH);
		c.add(jp_up, BorderLayout.NORTH);

		jp_content = new JPanel();
		String[] columnNames = new String[] { "薪酬标准编号", "薪酬标准名称", "薪酬总额",
				"制定人", "登记人", "登记时间", "查看详细信息并复核" };

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
		new ShowUncheckSalaryWindow(null);
	}

	private void initDate() {
		int i = 0;
		for (Entry<SalaryRegistInfo, ArrayList<SalaryStand>> sss : sris
				.entrySet()) {
			info[i][0] = String.valueOf(sss.getKey().getId());
			info[i][1] = sss.getValue().get(0).getSalaryRegistInfo()
					.getSalaryStandName();
			info[i][2] = String.valueOf(sss.getValue().get(0)
					.getSalaryRegistInfo().getTotalMoney());
			info[i][3] = sss.getValue().get(0).getSalaryRegistInfo()
					.getSalaryFormulater();
			info[i][4] = sss.getValue().get(0).getSalaryRegistInfo()
					.getSalaryRegistor();
			info[i][5] = sss.getValue().get(0).getSalaryRegistInfo()
					.getSalaryRegistTime();
			info[i][6] = "查看详细信息并复核";
			i++;
		}
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			int selectRow = jt.getSelectedRow();
			if (null != info[selectRow][1]) {
				String registInfoName = jt.getValueAt(jt.getSelectedRow(), 1)
						.toString().trim();
				for (Entry<SalaryRegistInfo, ArrayList<SalaryStand>> s : sris
						.entrySet()) {
					if (s.getKey().getSalaryStandName().equals(registInfoName)) {
						new SalaryStandRecheckWindow(s.getValue());
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
