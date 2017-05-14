package com.hrmdbs.archive.view;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.hrmdbs.archive.bean.Employee;
import com.hrmdbs.archive.bean.PositionName;
import com.hrmdbs.archive.bean.PositionSorted;
import com.hrmdbs.archive.bean.ProfessionalTitle;
import com.hrmdbs.archive.bean.SecondOrganization;
import com.hrmdbs.archive.bean.ThirdOrganization;
import com.hrmdbs.archive.bean.TopOrganization;
import com.hrmdbs.constant.Constant;
import com.hrmdbs.service.EmployeeService;
import com.hrmdbs.service.OrganizationService;

public class QueryWindow {

	private JFrame frame;
	private JTextField jtf_from;
	private JTextField jtf_to;

	private JButton jb_query;
	private JButton jb_back;
	private JComboBox jcb_secondOrganization;
	private JComboBox jcb_ThirdOrganization;
	private JComboBox jcb_PositionSorted;
	private JComboBox jcb_PositionName;
	private JComboBox jcb_TopOrganization;

	private HashMap<String, TopOrganization> tol;
	private HashMap<String, SecondOrganization> sol;
	private HashMap<String, ThirdOrganization> tdol;
	private HashMap<String, ProfessionalTitle> ptl;
	private HashMap<String, PositionName> pnl;
	private HashMap<String, PositionSorted> psl;
	private int state;
	private JButton jb_queryAll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryWindow window = new QueryWindow(
							Constant.QUERY_EMPLOYEE);
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
	public QueryWindow(int state) {
		this.state = state;
		initialize();
		initDate();
		intiListener();
	}

	private void intiListener() {
		jb_query.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Employee employee = new Employee();
				packageInfo(employee);
				ArrayList<Employee> es = EmployeeService.findEmployee(employee);
				if (es.size() == 0) {
					JOptionPane.showMessageDialog(null, "没有查询结果", null,
							JOptionPane.ERROR_MESSAGE);
				} else {
					switch (state) {
					case Constant.DELETE_EMPLOYEE:
						new DeleteWindow(es);
						break;
					case Constant.QUERY_EMPLOYEE:
						new QueryResultWindow(es);
						break;
					case Constant.UPDATE_EMPLOYEE:
						new UpdateListWindow(es);
						break;
					default:
						break;
					}

				}
			}

		});
		jb_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});

		jb_queryAll.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<Employee> es = EmployeeService
						.findAllEffectiveEmployee();
				switch (state) {
				case Constant.DELETE_EMPLOYEE:
					new DeleteWindow(es);
					break;
				case Constant.QUERY_EMPLOYEE:
					new QueryResultWindow(es);
					break;
				case Constant.UPDATE_EMPLOYEE:
					new UpdateListWindow(es);
					break;
				default:
					break;
				}
			}
		});
	}

	@SuppressWarnings("unchecked")
	private void initDate() {
		tol = OrganizationService.findAllTopOrganization();
		sol = OrganizationService.findAllSecondOrganization();
		tdol = OrganizationService.findAllThirdOrganization();
		ptl = OrganizationService.findAllProfessionalTitle();
		pnl = OrganizationService.findAllPositionName();
		psl = OrganizationService.findAllPositionSorted();

		jcb_TopOrganization.setModel(new DefaultComboBoxModel(tol.keySet()
				.toArray(new String[] {})));

		jcb_secondOrganization.setModel(new DefaultComboBoxModel(sol.keySet()
				.toArray(new String[] {})));

		jcb_ThirdOrganization.setModel(new DefaultComboBoxModel(tdol.keySet()
				.toArray(new String[] {})));

		jcb_PositionSorted.setModel(new DefaultComboBoxModel(psl.keySet()
				.toArray(new String[] {})));

		jcb_PositionName.setModel(new DefaultComboBoxModel(pnl.keySet()
				.toArray(new String[] {})));
	}

	private void packageInfo(Employee employee) {
		String topOrganizationName = jcb_TopOrganization.getSelectedItem()
				.toString().trim();
		employee.setTopOrganization(tol.get(topOrganizationName));

		String secondOrganizationName = jcb_secondOrganization
				.getSelectedItem().toString().trim();
		employee.setSecondOrganization(sol.get(secondOrganizationName));

		String thirdOrganizationName = jcb_ThirdOrganization.getSelectedItem()
				.toString().trim();
		employee.setThirdOrganization(tdol.get(thirdOrganizationName));

		String positionNameName = jcb_PositionName.getSelectedItem().toString()
				.trim();
		employee.setPositionName(pnl.get(positionNameName));

		String positionSortedName = jcb_PositionSorted.getSelectedItem()
				.toString().trim();
		employee.setPositionSorted(psl.get(positionSortedName));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 1.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JLabel jl_location = new JLabel("人力档案查询");
		GridBagConstraints gbc_jl_location = new GridBagConstraints();
		gbc_jl_location.anchor = GridBagConstraints.WEST;
		gbc_jl_location.gridwidth = 3;
		gbc_jl_location.insets = new Insets(0, 0, 5, 5);
		gbc_jl_location.gridx = 0;
		gbc_jl_location.gridy = 0;
		frame.getContentPane().add(jl_location, gbc_jl_location);

		jb_queryAll = new JButton("\u67E5\u8BE2\u6240\u6709");
		GridBagConstraints gbc_jb_queryAll = new GridBagConstraints();
		gbc_jb_queryAll.insets = new Insets(0, 0, 5, 5);
		gbc_jb_queryAll.gridx = 6;
		gbc_jb_queryAll.gridy = 1;
		frame.getContentPane().add(jb_queryAll, gbc_jb_queryAll);

		jb_query = new JButton("\u67E5\u8BE2");
		GridBagConstraints gbc_jb_query = new GridBagConstraints();
		gbc_jb_query.insets = new Insets(0, 0, 5, 5);
		gbc_jb_query.gridx = 7;
		gbc_jb_query.gridy = 1;
		frame.getContentPane().add(jb_query, gbc_jb_query);

		jb_back = new JButton("\u8FD4\u56DE");
		GridBagConstraints gbc_jb_back = new GridBagConstraints();
		gbc_jb_back.insets = new Insets(0, 0, 5, 0);
		gbc_jb_back.gridx = 8;
		gbc_jb_back.gridy = 1;
		frame.getContentPane().add(jb_back, gbc_jb_back);

		JLabel lblNewLabel_1 = new JLabel("I\u7EA7\u7ED3\u6784");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcb_TopOrganization = new JComboBox();
		GridBagConstraints gbc_jcb_TopOrganization_1 = new GridBagConstraints();
		gbc_jcb_TopOrganization_1.gridwidth = 4;
		gbc_jcb_TopOrganization_1.insets = new Insets(0, 0, 5, 5);
		gbc_jcb_TopOrganization_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_TopOrganization_1.gridx = 1;
		gbc_jcb_TopOrganization_1.gridy = 2;
		frame.getContentPane().add(jcb_TopOrganization,
				gbc_jcb_TopOrganization_1);

		JLabel lblNewLabel_2 = new JLabel("II\u7EA7\u7ED3\u6784");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);

		jcb_secondOrganization = new JComboBox();
		GridBagConstraints gbc_jcb_secondOrganization = new GridBagConstraints();
		gbc_jcb_secondOrganization.gridwidth = 4;
		gbc_jcb_secondOrganization.insets = new Insets(0, 0, 5, 5);
		gbc_jcb_secondOrganization.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_secondOrganization.gridx = 1;
		gbc_jcb_secondOrganization.gridy = 3;
		frame.getContentPane().add(jcb_secondOrganization,
				gbc_jcb_secondOrganization);

		JLabel lblNewLabel_3 = new JLabel("III\u7EA7\u7ED3\u6784");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		frame.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);

		jcb_ThirdOrganization = new JComboBox();
		GridBagConstraints gbc_jcb_ThirdOrganization = new GridBagConstraints();
		gbc_jcb_ThirdOrganization.gridwidth = 4;
		gbc_jcb_ThirdOrganization.insets = new Insets(0, 0, 5, 5);
		gbc_jcb_ThirdOrganization.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_ThirdOrganization.gridx = 1;
		gbc_jcb_ThirdOrganization.gridy = 4;
		frame.getContentPane().add(jcb_ThirdOrganization,
				gbc_jcb_ThirdOrganization);

		JLabel lblNewLabel_4 = new JLabel("\u804C\u4F4D\u5206\u7C7B");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		frame.getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);

		jcb_PositionSorted = new JComboBox();
		GridBagConstraints gbc_jcb_PositionSorted = new GridBagConstraints();
		gbc_jcb_PositionSorted.gridwidth = 4;
		gbc_jcb_PositionSorted.insets = new Insets(0, 0, 5, 5);
		gbc_jcb_PositionSorted.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_PositionSorted.gridx = 1;
		gbc_jcb_PositionSorted.gridy = 5;
		frame.getContentPane().add(jcb_PositionSorted, gbc_jcb_PositionSorted);

		JLabel lblNewLabel_5 = new JLabel("\u804C\u4F4D\u540D\u79F0");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		frame.getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);

		jcb_PositionName = new JComboBox();
		GridBagConstraints gbc_jcb_PositionName = new GridBagConstraints();
		gbc_jcb_PositionName.gridwidth = 4;
		gbc_jcb_PositionName.insets = new Insets(0, 0, 5, 5);
		gbc_jcb_PositionName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_PositionName.gridx = 1;
		gbc_jcb_PositionName.gridy = 6;
		frame.getContentPane().add(jcb_PositionName, gbc_jcb_PositionName);

		JLabel lblNewLabel_6 = new JLabel("\u5EFA\u6863\u65F6\u95F4");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		frame.getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);

		jtf_from = new JTextField();
		GridBagConstraints gbc_jtf_from = new GridBagConstraints();
		gbc_jtf_from.gridwidth = 2;
		gbc_jtf_from.insets = new Insets(0, 0, 0, 5);
		gbc_jtf_from.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_from.gridx = 1;
		gbc_jtf_from.gridy = 7;
		frame.getContentPane().add(jtf_from, gbc_jtf_from);
		jtf_from.setColumns(10);

		JLabel jl_to = new JLabel("\u81F3");
		GridBagConstraints gbc_jl_to = new GridBagConstraints();
		gbc_jl_to.anchor = GridBagConstraints.EAST;
		gbc_jl_to.insets = new Insets(0, 0, 0, 5);
		gbc_jl_to.gridx = 3;
		gbc_jl_to.gridy = 7;
		frame.getContentPane().add(jl_to, gbc_jl_to);

		jtf_to = new JTextField();
		GridBagConstraints gbc_jtf_to = new GridBagConstraints();
		gbc_jtf_to.gridwidth = 2;
		gbc_jtf_to.insets = new Insets(0, 0, 0, 5);
		gbc_jtf_to.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_to.gridx = 4;
		gbc_jtf_to.gridy = 7;
		frame.getContentPane().add(jtf_to, gbc_jtf_to);
		jtf_to.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("(YYYY.MM.DD)");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_7.gridwidth = 2;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_7.gridx = 6;
		gbc_lblNewLabel_7.gridy = 7;
		frame.getContentPane().add(lblNewLabel_7, gbc_lblNewLabel_7);
		frame.setVisible(true);
	}

}
