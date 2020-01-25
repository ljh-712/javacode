package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Utils;

import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	private JPanel contentPane;
	private JTextField account;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePage() {
		setResizable(false);
		setTitle("\u767B\u5F55");
		setForeground(Color.LIGHT_GRAY);
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 486);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton login = new JButton("\u767B\u5F55");
		login.setForeground(Color.WHITE);
		login.setToolTipText("");
		login.setBackground(new Color(153, 102, 153));
		
		JRadioButton averageEmployee = new JRadioButton("\u666E\u901A\u5458\u5DE5");
		averageEmployee.setBackground(Color.WHITE);
		
		JRadioButton administrator = new JRadioButton("\u7BA1\u7406\u5458");
		administrator.setBackground(Color.WHITE);
		// ����������ѡ��ť
		ButtonGroup group = new ButtonGroup();
		group.add(administrator);
		group.add(averageEmployee);
		averageEmployee.setSelected(true);
		JLabel userID = new JLabel("\u8D26\u53F7\uFF1A");
		
		account = new JTextField();
		account.setHorizontalAlignment(SwingConstants.LEFT);
		account.setColumns(10);
		
		JLabel userPassword = new JLabel("\u5BC6\u7801\uFF1A");
		
		passwordField = new JPasswordField();
		
		JLabel label = new JLabel("\u4EBA\u4E8B\u7BA1\u7406\u7CFB\u7EDF");
		label.setFont(new Font("����", Font.PLAIN, 40));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 10));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(162)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(userID)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(account, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(averageEmployee)
											.addPreferredGap(ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
											.addComponent(administrator))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(userPassword)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
												.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))))))
							.addGap(20))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(176)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)))
					.addGap(175))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(253, Short.MAX_VALUE)
					.addComponent(login, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addGap(247))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(63)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userID)
						.addComponent(account, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(userPassword))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(averageEmployee)
						.addComponent(administrator))
					.addGap(32)
					.addComponent(login, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(93))
		);
		contentPane.setLayout(gl_contentPane);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(averageEmployee.isSelected()) {
				String ac=account.getText();
				String pa=passwordField.getText();
				if(Utils.PdemPassword(ac, pa)) {
					emInformation em=new emInformation();
					em.setAc(account.getText());
					em.setVisible(true);
				}
				else
				{
					lblNewLabel.setText("账号或密码错误，请重新输入！！");
				}
				}
				if(administrator.isSelected()) {
				String ac=account.getText();
				String pa=passwordField.getText();
				if(Utils.PdadPassword(ac, pa)) {
					AdInformation ad=new AdInformation();
					ad.setac(account.getText());
						ad.setVisible(true);
					}
				else
				{
					lblNewLabel.setText("账号或密码错误，请重新输入！！");
				}
				}
			}
		});
	}
}
