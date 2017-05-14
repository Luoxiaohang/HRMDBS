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
import com.hrmdbs.salary.bean.Bonus;
import com.hrmdbs.salary.bean.SalaryStand;
import com.hrmdbs.service.OrganizationService;

public class PayrollReCheckWindow extends JFrame implements MouseListener {

	JPanel jp_up;
	JPanel jp_content;
	JLabel jl_location;
	JLabel jl_tip;
	private JTable jt;

	private ArrayList<Bonus> bonuss;
	private HashMap<ThirdOrganization, ArrayList<Bonus>> employees;
	HashMap<Integer, ArrayList<SalaryStand>> sris = null;
	String[][] info = new String[20][7];

	public PayrollReCheckWindow(
			HashMap<ThirdOrganization, ArrayList<Bonus>> employees) {
		this.employees = employees;
		initDate();
		initWindow();
	}

	/**
	 * @param args
	 */

	private void initWindow() {
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		// �����ϲ�
		jp_up = new JPanel(new BorderLayout());

		jl_location = new JLabel("н�귢�Ÿ���");
		jl_tip = new JLabel("��ǰ�ȴ����˵�������Դ����������");
		jp_up.add(jl_location, BorderLayout.NORTH);
		jp_up.add(jl_tip, BorderLayout.SOUTH);
		c.add(jp_up, BorderLayout.NORTH);

		jp_content = new JPanel();
		String[] columnNames = new String[] { "н�귢�ŵ����", "I���ṹ", "II���ṹ",
				"III���ṹ", "����", "����н���ܶ�", "����" };

		final DefaultTableModel m_data = new DefaultTableModel(info,
				columnNames);
		// ���ò��ɱ༭
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
		new PayrollReCheckWindow(null);
	}

	private void initDate() {
		int i = 0;
		for (Entry<ThirdOrganization, ArrayList<Bonus>> sss : employees
				.entrySet()) {
			info[i][0] = "SG100000000" + i;
			info[i][1] = sss.getKey().getSecondOrganization()
					.getTopOrganization().getTopOrganizationName();
			info[i][2] = sss.getKey().getSecondOrganization()
					.getSecondOrganizationName();
			info[i][3] = sss.getKey().getThirdOrganizationName();
			info[i][4] = String.valueOf(sss.getValue().size());
			float money = 0;
			for (int k = 0; k < sss.getValue().size(); k++) {
				money = money + sss.getValue().get(k).getBonus()
						- sss.getValue().get(k).getDeductedBonus();
			}
			info[i][5] = "" + money;
			info[i][6] = "����";
			i++;
		}

	}

	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			String thirdOganizationName = ((String) jt.getValueAt(
					jt.getSelectedRow(), 3)).trim();
			if (null != thirdOganizationName) {
				for (Entry<ThirdOrganization, ArrayList<Bonus>> to : employees
						.entrySet()) {
					if (to.getKey().getThirdOrganizationName()
							.equals(thirdOganizationName)) {
						new PayrollRecheckDetailWindow(employees.get(to
								.getKey()));
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
