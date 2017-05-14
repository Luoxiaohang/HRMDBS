package com.hrmdbs.archive.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import com.hrmdbs.archive.bean.Employee;

import javax.swing.SwingConstants;

public class DetailInfoWindow {

	private JFrame frame;

	private JTextField jtf_name;
	private JTextField jtf_Email;
	private JTextField jtf_Phone;
	private JTextField jtf_qq;
	private JTextField jtf_selPhone;
	private JTextField jtf_address;
	private JTextField jtf_PostNumber;
	private JTextField jtf_bornAddress;
	private JTextField jtf_birthday;
	private JTextField jtf_identityId;
	private JTextField jtf_socialSecurityID;
	private JTextField jtf_age;
	private JTextField jtf_bankName;
	private JTextField jtf_bankNumber;
	private JTextField jtf_registor;
	private JTextField jtf_registTime;
	private JButton jb_back;
	private JButton jb_addPhoto;

	private JComboBox<String> jcb_TopOrganization;
	private JComboBox<String> jcb_SecondOrganization;
	private JComboBox<String> jcb_ThirdOrganization;
	private JComboBox<String> jcb_PositionSorted;
	private JComboBox<String> jcb_PositionName;
	private JComboBox<String> jcb_ProfessionalTitle;
	private JComboBox<String> jcb_sex;
	private JComboBox<String> jcb_nationality;
	private JComboBox<String> jcb_nation;
	private JComboBox<String> jcb_faith;
	private JComboBox<String> jcb_politicsStatus;
	private JComboBox<String> jcb_education;
	private JComboBox<String> jcb_educationYears;
	private JComboBox<String> jcb_major;
	private JComboBox<String> jcb_salaryStandard;
	private JComboBox<String> jcb_hobby;
	private JComboBox<String> jcb_speciality;
	private JTextArea jta_perRecord;
	private JTextArea jta_familyRelation;
	private JTextArea jta_remark;
	private Employee employee;
	private JLabel lblNewLabel_27;
	private JLabel jl_archiveId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailInfoWindow window = new DetailInfoWindow(null);
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
	public DetailInfoWindow(Employee employee) {
		this.employee = employee;
		initialize();
		initListener();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 664, 512);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 67, 75, 78, 81, 72, 72, 0, 0,
				0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0,
				1.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JLabel jl_location = new JLabel(
				"\u5F53\u524D\u4F4D\u7F6E:\u8BE6\u7EC6\u4FE1\u606F\u67E5\u770B\u754C\u9762");
		GridBagConstraints gbc_jl_location = new GridBagConstraints();
		gbc_jl_location.anchor = GridBagConstraints.WEST;
		gbc_jl_location.gridwidth = 4;
		gbc_jl_location.insets = new Insets(0, 0, 5, 5);
		gbc_jl_location.gridx = 0;
		gbc_jl_location.gridy = 2;
		frame.getContentPane().add(jl_location, gbc_jl_location);

		jb_back = new JButton("\u8FD4\u56DE");
		GridBagConstraints gbc_jb_back = new GridBagConstraints();
		gbc_jb_back.insets = new Insets(0, 0, 5, 0);
		gbc_jb_back.gridx = 7;
		gbc_jb_back.gridy = 3;
		frame.getContentPane().add(jb_back, gbc_jb_back);

		lblNewLabel_27 = new JLabel("\u6863\u6848\u7F16\u53F7:");
		GridBagConstraints gbc_lblNewLabel_27 = new GridBagConstraints();
		gbc_lblNewLabel_27.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_27.gridx = 0;
		gbc_lblNewLabel_27.gridy = 4;
		frame.getContentPane().add(lblNewLabel_27, gbc_lblNewLabel_27);

		jl_archiveId = new JLabel(employee.getHrid());
		jl_archiveId.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_jl_archiveId = new GridBagConstraints();
		gbc_jl_archiveId.gridwidth = 2;
		gbc_jl_archiveId.insets = new Insets(0, 0, 5, 5);
		gbc_jl_archiveId.gridx = 1;
		gbc_jl_archiveId.gridy = 4;
		frame.getContentPane().add(jl_archiveId, gbc_jl_archiveId);

		JLabel lblNew = new JLabel("I\u7EA7\u7ED3\u6784");
		GridBagConstraints gbc_lblNew = new GridBagConstraints();
		gbc_lblNew.anchor = GridBagConstraints.WEST;
		gbc_lblNew.insets = new Insets(0, 0, 5, 5);
		gbc_lblNew.gridx = 0;
		gbc_lblNew.gridy = 5;
		frame.getContentPane().add(lblNew, gbc_lblNew);

		jcb_TopOrganization = new JComboBox(new String[] { employee
				.getTopOrganization().getTopOrganizationName() });
		GridBagConstraints gbc_jcb_TopOrganization = new GridBagConstraints();
		gbc_jcb_TopOrganization.fill = GridBagConstraints.BOTH;
		gbc_jcb_TopOrganization.insets = new Insets(0, 0, 5, 5);
		gbc_jcb_TopOrganization.gridx = 1;
		gbc_jcb_TopOrganization.gridy = 5;
		frame.getContentPane()
				.add(jcb_TopOrganization, gbc_jcb_TopOrganization);

		JLabel lblNewLabel_1 = new JLabel("II\u7EA7\u7ED3\u6784");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 5;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcb_SecondOrganization = new JComboBox(new String[] { employee
				.getSecondOrganization().getSecondOrganizationName() });
		GridBagConstraints gbc_jcb_SecondOrganization = new GridBagConstraints();
		gbc_jcb_SecondOrganization.insets = new Insets(0, 0, 5, 5);
		gbc_jcb_SecondOrganization.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_SecondOrganization.gridx = 3;
		gbc_jcb_SecondOrganization.gridy = 5;
		frame.getContentPane().add(jcb_SecondOrganization,
				gbc_jcb_SecondOrganization);

		JLabel lblNewLabel_2 = new JLabel("III\u7EA7\u7ED3\u6784");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 4;
		gbc_lblNewLabel_2.gridy = 5;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);

		jcb_ThirdOrganization = new JComboBox(new String[] { employee
				.getThirdOrganization().getThirdOrganizationName() });
		GridBagConstraints gbc_jcb_ThirdOrganization = new GridBagConstraints();
		gbc_jcb_ThirdOrganization.gridwidth = 2;
		gbc_jcb_ThirdOrganization.insets = new Insets(0, 0, 5, 5);
		gbc_jcb_ThirdOrganization.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_ThirdOrganization.gridx = 5;
		gbc_jcb_ThirdOrganization.gridy = 5;
		frame.getContentPane().add(jcb_ThirdOrganization,
				gbc_jcb_ThirdOrganization);

		JLabel lblNewLabel_20 = new JLabel("\u7167\u7247");
		GridBagConstraints gbc_lblNewLabel_20 = new GridBagConstraints();
		gbc_lblNewLabel_20.gridheight = 4;
		gbc_lblNewLabel_20.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_20.gridx = 7;
		gbc_lblNewLabel_20.gridy = 5;
		frame.getContentPane().add(lblNewLabel_20, gbc_lblNewLabel_20);

		JLabel lblNewLabel = new JLabel("\u804C\u4F4D\u5206\u7C7B");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 6;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		jcb_PositionSorted = new JComboBox(new String[] { employee
				.getPositionSorted().getPositionSortedName() });
		GridBagConstraints gbc_jcb_PositionSorted = new GridBagConstraints();
		gbc_jcb_PositionSorted.insets = new Insets(0, 0, 5, 5);
		gbc_jcb_PositionSorted.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_PositionSorted.gridx = 1;
		gbc_jcb_PositionSorted.gridy = 6;
		frame.getContentPane().add(jcb_PositionSorted, gbc_jcb_PositionSorted);

		JLabel lblNewLabel_5 = new JLabel("\u804C\u4F4D\u540D\u79F0");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 6;
		frame.getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);

		jcb_PositionName = new JComboBox(new String[] { employee
				.getPositionName().getPositionName() });
		GridBagConstraints gbc_jcb_PositionName = new GridBagConstraints();
		gbc_jcb_PositionName.insets = new Insets(0, 0, 5, 5);
		gbc_jcb_PositionName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_PositionName.gridx = 3;
		gbc_jcb_PositionName.gridy = 6;
		frame.getContentPane().add(jcb_PositionName, gbc_jcb_PositionName);

		JLabel lblNewLabel_6 = new JLabel("\u804C\u79F0");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.gridx = 4;
		gbc_lblNewLabel_6.gridy = 6;
		frame.getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);

		jcb_ProfessionalTitle = new JComboBox(new String[] { employee
				.getProfessionalTitle().getProfessionalTitle() });
		GridBagConstraints gbc_jcb_ProfessionalTitle = new GridBagConstraints();
		gbc_jcb_ProfessionalTitle.gridwidth = 2;
		gbc_jcb_ProfessionalTitle.insets = new Insets(0, 0, 5, 5);
		gbc_jcb_ProfessionalTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_ProfessionalTitle.gridx = 5;
		gbc_jcb_ProfessionalTitle.gridy = 6;
		frame.getContentPane().add(jcb_ProfessionalTitle,
				gbc_jcb_ProfessionalTitle);

		JLabel lblNewLabel_3 = new JLabel("\u59D3\u540D");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 7;
		frame.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtf_name = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 7;
		frame.getContentPane().add(jtf_name, gbc_textField);
		jtf_name.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("\u6027\u522B");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 7;
		frame.getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);

		jcb_sex = new JComboBox(new Object[] { "男", "女" });
		GridBagConstraints gbc_jcb_sex = new GridBagConstraints();
		gbc_jcb_sex.insets = new Insets(0, 0, 5, 5);
		gbc_jcb_sex.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_sex.gridx = 3;
		gbc_jcb_sex.gridy = 7;
		frame.getContentPane().add(jcb_sex, gbc_jcb_sex);

		JLabel lblNewLabel_7 = new JLabel("EMAIL");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 4;
		gbc_lblNewLabel_7.gridy = 7;
		frame.getContentPane().add(lblNewLabel_7, gbc_lblNewLabel_7);

		jtf_Email = new JTextField();
		jtf_Email.setText("");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 5;
		gbc_textField_1.gridy = 7;
		frame.getContentPane().add(jtf_Email, gbc_textField_1);
		jtf_Email.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("\u7535\u8BDD");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 8;
		frame.getContentPane().add(lblNewLabel_8, gbc_lblNewLabel_8);

		jtf_Phone = new JTextField();
		jtf_Phone.setText("");
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 8;
		frame.getContentPane().add(jtf_Phone, gbc_textField_2);
		jtf_Phone.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("QQ");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 2;
		gbc_lblNewLabel_9.gridy = 8;
		frame.getContentPane().add(lblNewLabel_9, gbc_lblNewLabel_9);

		jtf_qq = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 8;
		frame.getContentPane().add(jtf_qq, gbc_textField_3);
		jtf_qq.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("\u624B\u673A");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_10.gridx = 4;
		gbc_lblNewLabel_10.gridy = 8;
		frame.getContentPane().add(lblNewLabel_10, gbc_lblNewLabel_10);

		jtf_selPhone = new JTextField();
		jtf_selPhone.setText("");
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 2;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 5;
		gbc_textField_4.gridy = 8;
		frame.getContentPane().add(jtf_selPhone, gbc_textField_4);
		jtf_selPhone.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("\u4F4F\u5740");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 0;
		gbc_lblNewLabel_11.gridy = 9;
		frame.getContentPane().add(lblNewLabel_11, gbc_lblNewLabel_11);

		jtf_address = new JTextField();
		jtf_address.setText("");
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.gridwidth = 3;
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 9;
		frame.getContentPane().add(jtf_address, gbc_textField_5);
		jtf_address.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("\u90AE\u7F16");
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 4;
		gbc_lblNewLabel_12.gridy = 9;
		frame.getContentPane().add(lblNewLabel_12, gbc_lblNewLabel_12);

		jtf_PostNumber = new JTextField();
		jtf_PostNumber.setText("");
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.gridwidth = 2;
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 5;
		gbc_textField_6.gridy = 9;
		frame.getContentPane().add(jtf_PostNumber, gbc_textField_6);
		jtf_PostNumber.setColumns(10);

		jb_addPhoto = new JButton("\u6DFB\u52A0\u7167\u7247");
		GridBagConstraints gbc_jb_addPhoto = new GridBagConstraints();
		gbc_jb_addPhoto.insets = new Insets(0, 0, 5, 0);
		gbc_jb_addPhoto.gridx = 7;
		gbc_jb_addPhoto.gridy = 9;
		frame.getContentPane().add(jb_addPhoto, gbc_jb_addPhoto);

		JLabel lblNewLabel_13 = new JLabel("\u56FD\u7C4D");
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_13.gridx = 0;
		gbc_lblNewLabel_13.gridy = 10;
		frame.getContentPane().add(lblNewLabel_13, gbc_lblNewLabel_13);

		jcb_nationality = new JComboBox(new Object[] { "中国", "其他" });
		GridBagConstraints gbc_jcb_nationality = new GridBagConstraints();
		gbc_jcb_nationality.insets = new Insets(0, 0, 5, 5);
		gbc_jcb_nationality.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_nationality.gridx = 1;
		gbc_jcb_nationality.gridy = 10;
		frame.getContentPane().add(jcb_nationality, gbc_jcb_nationality);

		JLabel lblNewLabel_18 = new JLabel("\u51FA\u751F\u5730");
		GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
		gbc_lblNewLabel_18.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_18.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_18.gridx = 2;
		gbc_lblNewLabel_18.gridy = 10;
		frame.getContentPane().add(lblNewLabel_18, gbc_lblNewLabel_18);

		jtf_bornAddress = new JTextField();
		jtf_bornAddress.setText("");
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 3;
		gbc_textField_7.gridy = 10;
		frame.getContentPane().add(jtf_bornAddress, gbc_textField_7);
		jtf_bornAddress.setColumns(10);

		JLabel lblNewLabel_23 = new JLabel("\u751F\u65E5");
		GridBagConstraints gbc_lblNewLabel_23 = new GridBagConstraints();
		gbc_lblNewLabel_23.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_23.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_23.gridx = 4;
		gbc_lblNewLabel_23.gridy = 10;
		frame.getContentPane().add(lblNewLabel_23, gbc_lblNewLabel_23);

		jtf_birthday = new JTextField();
		jtf_birthday.setText("");
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.insets = new Insets(0, 0, 5, 5);
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.gridx = 5;
		gbc_textField_8.gridy = 10;
		frame.getContentPane().add(jtf_birthday, gbc_textField_8);
		jtf_birthday.setColumns(10);

		JLabel lblNewLabel_29 = new JLabel("\u6C11\u65CF");
		GridBagConstraints gbc_lblNewLabel_29 = new GridBagConstraints();
		gbc_lblNewLabel_29.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_29.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_29.gridx = 6;
		gbc_lblNewLabel_29.gridy = 10;
		frame.getContentPane().add(lblNewLabel_29, gbc_lblNewLabel_29);

		jcb_nation = new JComboBox(new Object[] { "汉族", "彝族", "壮族", "其他" });
		GridBagConstraints gbc_jcb_nation = new GridBagConstraints();
		gbc_jcb_nation.insets = new Insets(0, 0, 5, 0);
		gbc_jcb_nation.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_nation.gridx = 7;
		gbc_jcb_nation.gridy = 10;
		frame.getContentPane().add(jcb_nation, gbc_jcb_nation);

		JLabel lblNewLabel_14 = new JLabel("\u5B97\u6559\u4FE1\u4EF0");
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_14.gridx = 0;
		gbc_lblNewLabel_14.gridy = 11;
		frame.getContentPane().add(lblNewLabel_14, gbc_lblNewLabel_14);

		jcb_faith = new JComboBox(new Object[] { "佛教", "基督教", "伊斯兰教", "其他" });
		GridBagConstraints gbc_jcb_faith = new GridBagConstraints();
		gbc_jcb_faith.insets = new Insets(0, 0, 5, 5);
		gbc_jcb_faith.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_faith.gridx = 1;
		gbc_jcb_faith.gridy = 11;
		frame.getContentPane().add(jcb_faith, gbc_jcb_faith);

		JLabel lblNewLabel_19 = new JLabel("\u653F\u6CBB\u9762\u8C8C");
		GridBagConstraints gbc_lblNewLabel_19 = new GridBagConstraints();
		gbc_lblNewLabel_19.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_19.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_19.gridx = 2;
		gbc_lblNewLabel_19.gridy = 11;
		frame.getContentPane().add(lblNewLabel_19, gbc_lblNewLabel_19);

		jcb_politicsStatus = new JComboBox(new Object[] { "团员", "党员", "其他" });
		GridBagConstraints gbc_jcb_politicsStatus = new GridBagConstraints();
		gbc_jcb_politicsStatus.insets = new Insets(0, 0, 5, 5);
		gbc_jcb_politicsStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_politicsStatus.gridx = 3;
		gbc_jcb_politicsStatus.gridy = 11;
		frame.getContentPane().add(jcb_politicsStatus, gbc_jcb_politicsStatus);

		JLabel lblNewLabel_24 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\u7801");
		GridBagConstraints gbc_lblNewLabel_24 = new GridBagConstraints();
		gbc_lblNewLabel_24.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_24.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_24.gridx = 4;
		gbc_lblNewLabel_24.gridy = 11;
		frame.getContentPane().add(lblNewLabel_24, gbc_lblNewLabel_24);

		jtf_identityId = new JTextField();
		jtf_identityId.setText("");
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.insets = new Insets(0, 0, 5, 5);
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.gridx = 5;
		gbc_textField_9.gridy = 11;
		frame.getContentPane().add(jtf_identityId, gbc_textField_9);
		jtf_identityId.setColumns(10);

		JLabel lblNewLabel_30 = new JLabel("\u793E\u4FDD\u53F7\u7801");
		GridBagConstraints gbc_lblNewLabel_30 = new GridBagConstraints();
		gbc_lblNewLabel_30.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_30.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_30.gridx = 6;
		gbc_lblNewLabel_30.gridy = 11;
		frame.getContentPane().add(lblNewLabel_30, gbc_lblNewLabel_30);

		jtf_socialSecurityID = new JTextField();
		jtf_socialSecurityID.setText("");
		GridBagConstraints gbc_jtf_socialSecurityID = new GridBagConstraints();
		gbc_jtf_socialSecurityID.insets = new Insets(0, 0, 5, 0);
		gbc_jtf_socialSecurityID.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_socialSecurityID.gridx = 7;
		gbc_jtf_socialSecurityID.gridy = 11;
		frame.getContentPane().add(jtf_socialSecurityID,
				gbc_jtf_socialSecurityID);
		jtf_socialSecurityID.setColumns(10);

		JLabel lblNewLabel_15 = new JLabel("\u5E74\u9F84");
		GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
		gbc_lblNewLabel_15.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_15.gridx = 0;
		gbc_lblNewLabel_15.gridy = 12;
		frame.getContentPane().add(lblNewLabel_15, gbc_lblNewLabel_15);

		jtf_age = new JTextField();
		jtf_age.setText("");
		GridBagConstraints gbc_jtf_age = new GridBagConstraints();
		gbc_jtf_age.insets = new Insets(0, 0, 5, 5);
		gbc_jtf_age.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_age.gridx = 1;
		gbc_jtf_age.gridy = 12;
		frame.getContentPane().add(jtf_age, gbc_jtf_age);
		jtf_age.setColumns(10);

		JLabel lblNewLabel_33 = new JLabel("\u5B66\u5386");
		GridBagConstraints gbc_lblNewLabel_33 = new GridBagConstraints();
		gbc_lblNewLabel_33.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_33.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_33.gridx = 2;
		gbc_lblNewLabel_33.gridy = 12;
		frame.getContentPane().add(lblNewLabel_33, gbc_lblNewLabel_33);

		jcb_education = new JComboBox(new Object[] { "硕士", "研究生", "博士", "其他" });
		GridBagConstraints gbc_jcb_education = new GridBagConstraints();
		gbc_jcb_education.insets = new Insets(0, 0, 5, 5);
		gbc_jcb_education.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_education.gridx = 3;
		gbc_jcb_education.gridy = 12;
		frame.getContentPane().add(jcb_education, gbc_jcb_education);

		JLabel lblNewLabel_25 = new JLabel("\u6559\u80B2\u5E74\u9650");
		GridBagConstraints gbc_lblNewLabel_25 = new GridBagConstraints();
		gbc_lblNewLabel_25.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_25.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_25.gridx = 4;
		gbc_lblNewLabel_25.gridy = 12;
		frame.getContentPane().add(lblNewLabel_25, gbc_lblNewLabel_25);

		jcb_educationYears = new JComboBox();
		GridBagConstraints gbc_jcb_educationYears = new GridBagConstraints();
		gbc_jcb_educationYears.insets = new Insets(0, 0, 5, 5);
		gbc_jcb_educationYears.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_educationYears.gridx = 5;
		gbc_jcb_educationYears.gridy = 12;
		frame.getContentPane().add(jcb_educationYears, gbc_jcb_educationYears);

		JLabel lblNewLabel_31 = new JLabel("\u5B66\u5386\u4E13\u4E1A");
		GridBagConstraints gbc_lblNewLabel_31 = new GridBagConstraints();
		gbc_lblNewLabel_31.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_31.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_31.gridx = 6;
		gbc_lblNewLabel_31.gridy = 12;
		frame.getContentPane().add(lblNewLabel_31, gbc_lblNewLabel_31);

		jcb_major = new JComboBox(
				new Object[] { "计算机专业", "软件工程", "通信工程", "其他" });
		GridBagConstraints gbc_jcb_major = new GridBagConstraints();
		gbc_jcb_major.insets = new Insets(0, 0, 5, 0);
		gbc_jcb_major.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_major.gridx = 7;
		gbc_jcb_major.gridy = 12;
		frame.getContentPane().add(jcb_major, gbc_jcb_major);

		JLabel lblNewLabel_16 = new JLabel("\u85AA\u916C\u6807\u51C6");
		GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
		gbc_lblNewLabel_16.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_16.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_16.gridx = 0;
		gbc_lblNewLabel_16.gridy = 13;
		frame.getContentPane().add(lblNewLabel_16, gbc_lblNewLabel_16);

		jcb_salaryStandard = new JComboBox();
		GridBagConstraints gbc_jcb_salaryStandard = new GridBagConstraints();
		gbc_jcb_salaryStandard.insets = new Insets(0, 0, 5, 5);
		gbc_jcb_salaryStandard.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_salaryStandard.gridx = 1;
		gbc_jcb_salaryStandard.gridy = 13;
		frame.getContentPane().add(jcb_salaryStandard, gbc_jcb_salaryStandard);

		JLabel lblNewLabel_21 = new JLabel("\u5F00\u6237\u884C");
		GridBagConstraints gbc_lblNewLabel_21 = new GridBagConstraints();
		gbc_lblNewLabel_21.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_21.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_21.gridx = 2;
		gbc_lblNewLabel_21.gridy = 13;
		frame.getContentPane().add(lblNewLabel_21, gbc_lblNewLabel_21);

		jtf_bankName = new JTextField();
		GridBagConstraints gbc_jtf_bankName = new GridBagConstraints();
		gbc_jtf_bankName.insets = new Insets(0, 0, 5, 5);
		gbc_jtf_bankName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_bankName.gridx = 3;
		gbc_jtf_bankName.gridy = 13;
		frame.getContentPane().add(jtf_bankName, gbc_jtf_bankName);
		jtf_bankName.setColumns(10);

		JLabel lblNewLabel_26 = new JLabel("\u5E10\u53F7");
		GridBagConstraints gbc_lblNewLabel_26 = new GridBagConstraints();
		gbc_lblNewLabel_26.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_26.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_26.gridx = 4;
		gbc_lblNewLabel_26.gridy = 13;
		frame.getContentPane().add(lblNewLabel_26, gbc_lblNewLabel_26);

		jtf_bankNumber = new JTextField();
		jtf_bankNumber.setText("");
		GridBagConstraints gbc_jtf_bankNumber = new GridBagConstraints();
		gbc_jtf_bankNumber.insets = new Insets(0, 0, 5, 5);
		gbc_jtf_bankNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_bankNumber.gridx = 5;
		gbc_jtf_bankNumber.gridy = 13;
		frame.getContentPane().add(jtf_bankNumber, gbc_jtf_bankNumber);
		jtf_bankNumber.setColumns(10);

		JLabel lblNewLabel_32 = new JLabel("\u767B\u8BB0\u4EBA");
		GridBagConstraints gbc_lblNewLabel_32 = new GridBagConstraints();
		gbc_lblNewLabel_32.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_32.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_32.gridx = 6;
		gbc_lblNewLabel_32.gridy = 13;
		frame.getContentPane().add(lblNewLabel_32, gbc_lblNewLabel_32);

		jtf_registor = new JTextField();
		jtf_registor.setText("");
		GridBagConstraints gbc_jtf_registor = new GridBagConstraints();
		gbc_jtf_registor.insets = new Insets(0, 0, 5, 0);
		gbc_jtf_registor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_registor.gridx = 7;
		gbc_jtf_registor.gridy = 13;
		frame.getContentPane().add(jtf_registor, gbc_jtf_registor);
		jtf_registor.setColumns(10);

		JLabel lblNewLabel_17 = new JLabel("\u5EFA\u6863\u65F6\u95F4");
		GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
		gbc_lblNewLabel_17.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_17.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_17.gridx = 0;
		gbc_lblNewLabel_17.gridy = 14;
		frame.getContentPane().add(lblNewLabel_17, gbc_lblNewLabel_17);

		jtf_registTime = new JTextField();
		jtf_registTime.setText("");
		GridBagConstraints gbc_jtf_registTime = new GridBagConstraints();
		gbc_jtf_registTime.insets = new Insets(0, 0, 5, 5);
		gbc_jtf_registTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_registTime.gridx = 1;
		gbc_jtf_registTime.gridy = 14;
		frame.getContentPane().add(jtf_registTime, gbc_jtf_registTime);
		jtf_registTime.setColumns(10);

		JLabel lblNewLabel_22 = new JLabel("\u7231\u597D");
		GridBagConstraints gbc_lblNewLabel_22 = new GridBagConstraints();
		gbc_lblNewLabel_22.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_22.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_22.gridx = 2;
		gbc_lblNewLabel_22.gridy = 14;
		frame.getContentPane().add(lblNewLabel_22, gbc_lblNewLabel_22);

		jcb_hobby = new JComboBox(new Object[] { "篮球", "足球", "跑步", "其他" });
		GridBagConstraints gbc_jcb_hobby = new GridBagConstraints();
		gbc_jcb_hobby.insets = new Insets(0, 0, 5, 5);
		gbc_jcb_hobby.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_hobby.gridx = 3;
		gbc_jcb_hobby.gridy = 14;
		frame.getContentPane().add(jcb_hobby, gbc_jcb_hobby);

		JLabel lblNewLabel_28 = new JLabel("\u7279\u957F");
		GridBagConstraints gbc_lblNewLabel_28 = new GridBagConstraints();
		gbc_lblNewLabel_28.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_28.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_28.gridx = 4;
		gbc_lblNewLabel_28.gridy = 14;
		frame.getContentPane().add(lblNewLabel_28, gbc_lblNewLabel_28);

		jcb_speciality = new JComboBox(new Object[] { "数据库", "网页前端", "网页后台",
				"其他" });
		GridBagConstraints gbc_jcb_speciality = new GridBagConstraints();
		gbc_jcb_speciality.insets = new Insets(0, 0, 5, 5);
		gbc_jcb_speciality.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_speciality.gridx = 5;
		gbc_jcb_speciality.gridy = 14;
		frame.getContentPane().add(jcb_speciality, gbc_jcb_speciality);

		JLabel jl_perRecord = new JLabel("\u4E2A\u4EBA\u5C65\u5386");
		GridBagConstraints gbc_jl_perRecord = new GridBagConstraints();
		gbc_jl_perRecord.anchor = GridBagConstraints.WEST;
		gbc_jl_perRecord.gridheight = 2;
		gbc_jl_perRecord.insets = new Insets(0, 0, 5, 5);
		gbc_jl_perRecord.gridx = 0;
		gbc_jl_perRecord.gridy = 15;
		frame.getContentPane().add(jl_perRecord, gbc_jl_perRecord);

		jta_perRecord = new JTextArea();
		GridBagConstraints gbc_jta_perRecord = new GridBagConstraints();
		gbc_jta_perRecord.gridheight = 2;
		gbc_jta_perRecord.gridwidth = 7;
		gbc_jta_perRecord.insets = new Insets(0, 0, 5, 0);
		gbc_jta_perRecord.fill = GridBagConstraints.BOTH;
		gbc_jta_perRecord.gridx = 1;
		gbc_jta_perRecord.gridy = 15;
		frame.getContentPane().add(jta_perRecord, gbc_jta_perRecord);

		JLabel jl_familyRelation = new JLabel(
				"\u5BB6\u5EAD\u5173\u7CFB\u4FE1\u606F");
		GridBagConstraints gbc_jl_familyRelation = new GridBagConstraints();
		gbc_jl_familyRelation.gridheight = 2;
		gbc_jl_familyRelation.anchor = GridBagConstraints.WEST;
		gbc_jl_familyRelation.insets = new Insets(0, 0, 5, 5);
		gbc_jl_familyRelation.gridx = 0;
		gbc_jl_familyRelation.gridy = 17;
		frame.getContentPane().add(jl_familyRelation, gbc_jl_familyRelation);

		jta_familyRelation = new JTextArea();
		GridBagConstraints gbc_jta_familyRelation = new GridBagConstraints();
		gbc_jta_familyRelation.gridheight = 2;
		gbc_jta_familyRelation.gridwidth = 7;
		gbc_jta_familyRelation.insets = new Insets(0, 0, 5, 0);
		gbc_jta_familyRelation.fill = GridBagConstraints.BOTH;
		gbc_jta_familyRelation.gridx = 1;
		gbc_jta_familyRelation.gridy = 17;
		frame.getContentPane().add(jta_familyRelation, gbc_jta_familyRelation);

		JLabel jl_remark = new JLabel("\u5907\u6CE8");
		GridBagConstraints gbc_jl_remark = new GridBagConstraints();
		gbc_jl_remark.anchor = GridBagConstraints.WEST;
		gbc_jl_remark.gridheight = 2;
		gbc_jl_remark.insets = new Insets(0, 0, 0, 5);
		gbc_jl_remark.gridx = 0;
		gbc_jl_remark.gridy = 19;
		frame.getContentPane().add(jl_remark, gbc_jl_remark);

		jta_remark = new JTextArea();
		GridBagConstraints gbc_jta_remark = new GridBagConstraints();
		gbc_jta_remark.gridheight = 2;
		gbc_jta_remark.gridwidth = 7;
		gbc_jta_remark.fill = GridBagConstraints.BOTH;
		gbc_jta_remark.gridx = 1;
		gbc_jta_remark.gridy = 19;
		frame.getContentPane().add(jta_remark, gbc_jta_remark);
		frame.setVisible(true);
	}

	private void initListener() {
		jb_back.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		jb_addPhoto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	// private void reSetData() {
	// employee.setName(jtf_name.getText().trim());
	// employee.setSex(jcb_sex.getSelectedItem().toString().trim());
	// employee.setEmail(jtf_Email.getText().trim());
	// employee.setPhone(jtf_Phone.getText().trim());
	// employee.setQq(jtf_qq.getText().trim());
	// employee.setSelPhone(jtf_selPhone.getText().trim());
	// employee.setPostNumber(jtf_PostNumber.getText().trim());
	// employee.setNationality(jcb_nationality.getSelectedIndex());
	// employee.setBornAddress(jtf_bornAddress.getText().trim());
	// employee.setBirthday(jtf_birthday.getText().trim());
	// employee.setFaith(jcb_faith.getSelectedIndex());
	// employee.setPoliticsStatus(jcb_politicsStatus.getSelectedIndex());
	// employee.setIdentityId(jtf_identityId.getText().trim());
	// employee.setAge(jtf_age.getText().trim());
	// employee.setEducation(jcb_education.getSelectedIndex());
	// employee.setEducationYears(jcb_educationYears.getSelectedIndex());
	// employee.setSalaryStandard(jcb_salaryStandard.getSelectedIndex());
	// employee.setBankName(jtf_bankName.getText().trim());
	// employee.setBankNumber(jtf_bankNumber.getText().trim());
	// employee.setRegistTime(jtf_registTime.getText().trim());
	// employee.setHobby(jcb_hobby.getSelectedIndex());
	// employee.setSpeciality(jcb_speciality.getSelectedIndex());
	// employee.setPerRecord(jta_perRecord.getText().trim());
	// employee.setFamilyRelation(jta_familyRelation.getText().trim());
	// employee.setRemark(jta_remark.getText().trim());
	// employee.setNation(jcb_nation.getSelectedIndex());
	// employee.setSocialSecurityID(jtf_socialSecurityID.getText().trim());
	// employee.setMajor(jcb_major.getSelectedIndex());
	// employee.setRegistor(jtf_registor.getText().trim());
	// }
}
