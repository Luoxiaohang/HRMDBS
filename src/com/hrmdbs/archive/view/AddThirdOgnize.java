package com.hrmdbs.archive.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.hrmdbs.archive.bean.SecondOrganization;
import com.hrmdbs.archive.bean.ThirdOrganization;
import com.hrmdbs.service.OrganizationService;

public class AddThirdOgnize {

	private JFrame frame;
	private JTextField jt_name;
	private JButton jb_cancel;
	private JButton jb_commit;
	private JComboBox jcb_topName;
	HashMap<String, SecondOrganization> sos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddThirdOgnize window = new AddThirdOgnize();
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
	public AddThirdOgnize() {
		initData();
		initialize();
		iniListener();
	}

	private void initData() {
		sos = OrganizationService.findAllSecondOrganization();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("rawtypes")
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u6DFB\u52A0\u4E09\u7EA7\u7ED3\u6784");
		frame.setBounds(80, 50, 350, 250);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		jcb_topName = new JComboBox(sos.keySet().toArray());
		jcb_topName.setBounds(172, 28, 120, 21);
		frame.getContentPane().add(jcb_topName);

		JLabel lblNewLabel = new JLabel("\u9009\u62E9\u4E8C\u7EA7\u7ED3\u6784");
		lblNewLabel.setBounds(55, 31, 86, 15);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(
				"\u8BF7\u8F93\u5165\u4E09\u7EA7\u7ED3\u6784\u540D\u79F0");
		lblNewLabel_1.setBounds(36, 80, 120, 15);
		frame.getContentPane().add(lblNewLabel_1);

		jt_name = new JTextField();
		jt_name.setBounds(172, 77, 120, 21);
		frame.getContentPane().add(jt_name);
		jt_name.setColumns(10);

		jb_commit = new JButton("\u786E\u8BA4");
		jb_commit.setBounds(63, 125, 93, 23);
		frame.getContentPane().add(jb_commit);

		jb_cancel = new JButton("\u53D6\u6D88");
		jb_cancel.setBounds(213, 125, 57, 23);
		frame.getContentPane().add(jb_cancel);
		frame.setVisible(true);
	}

	private void iniListener() {
		jb_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		jb_commit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = jcb_topName.getSelectedItem().toString().trim();
				if (null != name && name.length() != 0) {
					ThirdOrganization so = new ThirdOrganization();
					so.setThirdOrganizationName(name);
					so.setSecondOrganization(sos.get(name));
					if (OrganizationService.addThirdOrganization(so)) {
						JOptionPane.showMessageDialog(frame, "Ìí¼Ó³É¹¦", null,
								JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
					}
				}
			}
		});
	}
}
