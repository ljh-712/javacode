package interfaces;

import control.Utils;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Insert extends JFrame {

	private JPanel contentPane;
	private JTextField xingming;
	private JTextField gonghao;
	private JTextField minzu;
	private JTextField shenfen;
	private JTextField chusheng;
	private JTextField dianhua;
	private JTextField xingbie;
	private JTextField zhengzhi;
	private JTextField bumen;
	private JTextField zhicheng;
	private JTextField wenhua;
	private JTextField mima;
	private JTextField nianling;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert frame = new Insert();
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
	public Insert() {
		setTitle("\u589E\u52A0\u5458\u5DE5\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 538);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		
		xingming = new JTextField();
		xingming.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6027\u522B\uFF1A");
		
		JLabel label_2 = new JLabel("\u90E8\u95E8\uFF1A");
		
		JLabel label_3 = new JLabel("\u804C\u79F0\uFF1A");
		
		JButton button = new JButton("\u786E\u8BA4\u589E\u52A0");
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(204, 153, 204));
		
		JLabel label_4 = new JLabel("\u5DE5\u53F7\uFF1A");
		
		gonghao = new JTextField();
		gonghao.setColumns(10);
		
		JLabel label_5 = new JLabel("\u6C11\u65CF\uFF1A");
		
		JLabel label_6 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		
		JLabel label_7 = new JLabel("\u51FA\u751F\u65E5\u671F\uFF1A");
		
		JLabel label_8 = new JLabel("\u6587\u5316\u7A0B\u5EA6\uFF1A");
		
		JLabel label_9 = new JLabel("\u7535\u8BDD\uFF1A");
		
		JLabel label_10 = new JLabel("\u653F\u6CBB\u9762\u8C8C\uFF1A");
		
		minzu = new JTextField();
		minzu.setColumns(10);
		
		shenfen = new JTextField();
		shenfen.setColumns(10);
		
		chusheng = new JTextField();
		chusheng.setColumns(10);
		
		dianhua = new JTextField();
		dianhua.setColumns(10);
		
		JButton button_1 = new JButton("返回");
		button_1.setForeground(new Color(255, 255, 255));
		button_1.setBackground(new Color(204, 153, 204));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		xingbie = new JTextField();
		xingbie.setColumns(10);
		
		zhengzhi = new JTextField();
		zhengzhi.setColumns(10);
		
		bumen = new JTextField();
		bumen.setColumns(10);
		
		zhicheng = new JTextField();
		zhicheng.setColumns(10);
		
		wenhua = new JTextField();
		wenhua.setColumns(10);
		
		mima = new JTextField();
		mima.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("初始密码：");
		
		nianling = new JTextField();
		nianling.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("年龄：");
		
		JLabel x = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
											.addComponent(label_1)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(xingbie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
											.addComponent(label)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(xingming, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
											.addComponent(label_4)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(gonghao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
											.addComponent(label_5)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(minzu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(label_6)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(shenfen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGap(140)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(label_8)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(wenhua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabel)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(mima, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
											.addComponent(label_9)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(dianhua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
											.addComponent(label_3)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(zhicheng, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(label_7)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(chusheng, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
													.addComponent(label_2)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(bumen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
									.addGap(20))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(nianling, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addComponent(label_10)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(zhengzhi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(242)
							.addComponent(button)
							.addGap(61)
							.addComponent(x)))
					.addContainerGap(140, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(494, Short.MAX_VALUE)
					.addComponent(button_1)
					.addGap(39))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_7)
						.addComponent(chusheng, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(gonghao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(xingming, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bumen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(label))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(xingbie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(zhicheng, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(label_1))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_8)
						.addComponent(wenhua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(minzu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(shenfen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(dianhua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_9))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(zhengzhi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(mima, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel))
						.addComponent(label_10))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(75)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(button)
								.addComponent(x))
							.addGap(54)
							.addComponent(button_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(nianling, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))))
					.addGap(22))
		);
		contentPane.setLayout(gl_contentPane);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String gh=gonghao.getText();
				String xm=xingming.getText();
				String xb=xingbie.getText();
				String mz=minzu.getText();
				String sf=shenfen.getText();
				String zz=zhengzhi.getText();
				String cs=chusheng.getText();
				String bm=bumen.getText();
				String zc=zhicheng.getText();
				String wh=wenhua.getText();
				String dh=dianhua.getText();
				String nl=nianling.getText();
				String mm=mima.getText();
				boolean m=Utils.Insert(mm, gh, xm, nl, xb, sf, dh, bm, zc, mz, cs, wh, zz);
				if(m)
				{
					x.setText("成功！");
				}
				else
				{
					x.setText("失败！");
				}
			}
		});
	}
}
