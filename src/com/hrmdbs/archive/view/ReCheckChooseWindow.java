package com.hrmdbs.archive.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hrmdbs.archive.bean.Employee;

public class ReCheckChooseWindow extends JFrame implements MouseListener {
	List<Employee> es = null;
	String[][] info = new String[20][8];
	JPanel jp_up;
	JPanel jp_content;
	JLabel jl_location;
	JLabel jl_tip;
	private JTable jt;

	public ReCheckChooseWindow(List<Employee> es) {
		this.es = es;
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

		jl_location = new JLabel("人力档案登记复核");
		jl_tip = new JLabel("当前等待复核的人力资源档案总数：");
		jp_up.add(jl_location, BorderLayout.NORTH);
		jp_up.add(jl_tip, BorderLayout.SOUTH);
		c.add(jp_up, BorderLayout.NORTH);

		jp_content = new JPanel();
		String[] columnNames = new String[] { "档案编号", "姓名", "性别", "一级结构",
				"二级结构", "三级结构", "职位名称", "复核" };

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
		new ReCheckChooseWindow(null);
	}

	private void initDate() {
		for (int i = 0; i < 20 && i < es.size(); i++) {
			info[i][0] = String.valueOf(es.get(i).getHrid());
			info[i][1] = String.valueOf(es.get(i).getName());
			info[i][2] = String.valueOf(es.get(i).getSex());
			info[i][3] = es.get(i).getTopOrganization()
					.getTopOrganizationName();
			info[i][4] = es.get(i).getSecondOrganization()
					.getSecondOrganizationName();
			info[i][5] = es.get(i).getThirdOrganization()
					.getThirdOrganizationName();
			info[i][6] = es.get(i).getProfessionalTitle()
					.getProfessionalTitle();
			info[i][7] = "复核";
		}
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			int selectRow = jt.getSelectedRow();
			if (info[selectRow][0] != null) {
				new RecheckWindow(es.get(jt.getSelectedRow()));
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
