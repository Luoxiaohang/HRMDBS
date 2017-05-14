package com.hrmdbs.archive.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.hrmdbs.archive.bean.PositionName;
import com.hrmdbs.archive.bean.PositionSorted;
import com.hrmdbs.archive.bean.ProfessionalTitle;
import com.hrmdbs.archive.bean.SecondOrganization;
import com.hrmdbs.archive.bean.ThirdOrganization;
import com.hrmdbs.archive.bean.TopOrganization;
import com.hrmdbs.service.OrganizationService;

public class AddPositionWindow {

	private JFrame frame;
	private HashMap<String, TopOrganization> tol;
	private HashMap<String, SecondOrganization> sol;
	private HashMap<String, ThirdOrganization> tdol;
	private JButton jb_addTop;
	private JButton jb_addSecond;
	private JButton jb_addThird;
	private JButton jb_addName;
	private JButton jb_addTitle;
	private JButton jb_addSorted;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPositionWindow window = new AddPositionWindow();
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
	public AddPositionWindow() {
		initialize();
		initData();
		initListener();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("rawtypes")
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u589E\u8BBE\u673A\u6784\u53CA\u804C\u4F4D");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		jb_addSorted = new JButton("\u6DFB\u52A0\u804C\u4F4D\u5206\u7C7B");
		jb_addSorted.setBounds(252, 50, 129, 23);
		frame.getContentPane().add(jb_addSorted);

		jb_addName = new JButton("\u6DFB\u52A0\u804C\u4F4D\u540D\u79F0");
		jb_addName.setBounds(252, 120, 129, 23);
		frame.getContentPane().add(jb_addName);

		jb_addTitle = new JButton("\u6DFB\u52A0\u804C\u79F0");
		jb_addTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jb_addTitle.setBounds(252, 191, 129, 23);
		frame.getContentPane().add(jb_addTitle);

		jb_addTop = new JButton("\u6DFB\u52A0\u4E00\u7EA7\u7ED3\u6784");
		jb_addTop.setBounds(51, 50, 129, 23);
		frame.getContentPane().add(jb_addTop);

		jb_addSecond = new JButton("\u6DFB\u52A0\u4E8C\u7EA7\u7ED3\u6784");
		jb_addSecond.setBounds(51, 120, 129, 23);
		frame.getContentPane().add(jb_addSecond);

		jb_addThird = new JButton("\u6DFB\u52A0\u4E09\u7EA7\u7ED3\u6784");
		jb_addThird.setBounds(51, 191, 129, 23);
		frame.getContentPane().add(jb_addThird);
		frame.setVisible(true);
	}

	private void initListener() {
		jb_addThird.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddThirdOgnize();
			}
		});
		jb_addTop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sb = JOptionPane.showInputDialog(null, "请输入一级结构名字");
				if (null != sb && sb.length() != 0) {
					if (OrganizationService.addTopPosition(sb)) {
						JOptionPane.showMessageDialog(frame, "添加成功", null,
								JOptionPane.INFORMATION_MESSAGE);// ;
					}
				}
			}
		});
		jb_addSecond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddSeconOgnize();
			}
		});
		jb_addName.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(frame, "请输入新的职位名称",
						"添加职位名称", JOptionPane.INFORMATION_MESSAGE);
				if (null != name && name.length() != 0) {
					if (OrganizationService.addPositionName(new PositionName(
							name))) {
						JOptionPane.showMessageDialog(frame, "添加成功", null,
								JOptionPane.INFORMATION_MESSAGE);// ;
					}
				}
			}
		});
		jb_addTitle.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(frame, "请输入新的职称",
						"添加职称", JOptionPane.INFORMATION_MESSAGE);
				if (null != name && name.length() != 0) {
					if (OrganizationService
							.addProfessionanTitle(new ProfessionalTitle(name))) {
						JOptionPane.showMessageDialog(frame, "添加成功", null,
								JOptionPane.INFORMATION_MESSAGE);// ;
					}
				}

			}
		});
		jb_addSorted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(frame, "请输入新的职位分类",
						"添加职位分类", JOptionPane.INFORMATION_MESSAGE);
				if (null != name && name.length() != 0) {
					if (OrganizationService
							.addTopPositionSorted(new PositionSorted(name))) {
						JOptionPane.showMessageDialog(frame, "添加成功", null,
								JOptionPane.INFORMATION_MESSAGE);// ;
					}
				}
			}
		});
	}

	@SuppressWarnings("unchecked")
	private void initData() {
		tol = OrganizationService.findAllTopOrganization();
		sol = OrganizationService.findAllSecondOrganization();
		tdol = OrganizationService.findAllThirdOrganization();

		ArrayList<String> topName = new ArrayList<String>();
		topName.addAll(tol.keySet());
		topName.add("增设一级职位");

		ArrayList<String> secName = new ArrayList<String>();
		secName.addAll(sol.keySet());
		secName.add("增设二级职位");

		ArrayList<String> thdName = new ArrayList<String>();
		thdName.addAll(tdol.keySet());
		thdName.add("增设三级职位");
	}
}
