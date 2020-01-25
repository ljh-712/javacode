package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

import control.Utils;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Font;

public class ChangePassword extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private String accou;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
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
	public ChangePassword() {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 415);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		btnNewButton.setBackground(new Color(204, 153, 204));
		btnNewButton.setForeground(Color.WHITE);
		JLabel lblNewLabel = new JLabel("\u65E7\u5BC6\u7801\uFF1A");
		
		JLabel label = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		
		JLabel label_1 = new JLabel("\u786E\u8BA4\u65B0\u5BC6\u7801\uFF1A");
		
		passwordField = new JPasswordField();
		
		passwordField_1 = new JPasswordField();
		
		passwordField_2 = new JPasswordField();
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 10));
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		button.setBackground(new Color(204, 153, 204));
		button.setForeground(new Color(255, 255, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(80)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(label)
									.addComponent(lblNewLabel))
								.addComponent(label_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField_2, 178, 178, 178)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(passwordField_1)
									.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(184)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(96, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(362, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(27))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(69)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(passwordField_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addGap(34)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(button)
					.addGap(21))
		);
		contentPane.setLayout(gl_contentPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String LastPassword=passwordField.getText();
				String OneNewPassword=passwordField_1.getText();
				String TwoNewPassword=passwordField_2.getText();
				if(Utils.PdemPassword(accou, LastPassword)&&OneNewPassword.equals(TwoNewPassword))
				{
					Utils.Changpassword(accou, OneNewPassword);
					Xianshi xi=new Xianshi();
					xi.setVisible(true);
				}
				else
				{
					lblNewLabel_1.setText("密码不正确或两次输入密码不一致");
				}
			}
		});
	}

	public String getAccou() {
		return accou;
	}

	public void setAccou(String accou) {
		this.accou = accou;
	}
}
