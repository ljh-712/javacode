package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import ORM.Attendence;
import ORM.Employee;
import ORM.Exam;
import ORM.Salary;
import control.Utils;

import java.awt.Color;

public class AdInformation extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private String ac;

	/**
	 * Launch the application.
	 */
	
	public void setac(String s) {
		this.ac=s;
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdInformation frame = new AdInformation();
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
	public AdInformation() {
		setBackground(Color.WHITE);
		setTitle("\u7BA1\u7406\u5458\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 503);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
		);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JButton button = new JButton("\u57FA\u672C\u4FE1\u606F");
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(204, 153, 204));
		
		panel_1.add(button);
		
		JButton button_1 = new JButton("\u8003\u8BC4\u4FE1\u606F");
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(204, 153, 204));
		
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("\u8003\u52E4\u4FE1\u606F");
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(new Color(204, 153, 204));
		
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("\u85AA\u8D44\u4FE1\u606F");
		button_3.setForeground(Color.WHITE);
		button_3.setBackground(new Color(204, 153, 204));
		
		panel_1.add(button_3);
		
		JButton button_8 = new JButton("\u589E\u52A0\u5458\u5DE5\u4FE1\u606F");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Insert in=new Insert();
				in.setVisible(true);
			}
		});
		button_8.setForeground(Color.WHITE);
		button_8.setBackground(new Color(204, 153, 204));
		panel_1.add(button_8);
		
		JButton button_9 = new JButton("\u4FEE\u6539\u5BC6\u7801");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword cp=new ChangePassword();
				cp.setAccou(ac);
				cp.setVisible(true);
			}
		});
		button_9.setForeground(Color.WHITE);
		button_9.setBackground(new Color(204, 153, 204));
		panel_1.add(button_9);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(204, 153, 204));
		panel_1.add(btnNewButton);
		panel.setLayout(gl_panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new CardLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_2.add(panel_3, "name_1692738091226700");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_2.add(panel_4, "name_1692748404290000");
		
		JLabel label = new JLabel("\u5DE5\u53F7\uFF1A");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton button_4 = new JButton("删除");
		button_4.setForeground(Color.WHITE);
		button_4.setBackground(new Color(204, 153, 204));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label_1 = new JLabel("");
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(label, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(155)
							.addComponent(label_1)
							.addGap(316)
							.addComponent(button_4)))
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(button_4)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(34)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(122, Short.MAX_VALUE))
		);
		
		table = new JTable();
		 DefaultTableCellRenderer r=new DefaultTableCellRenderer();
	     r.setHorizontalAlignment(JLabel.CENTER);
	     table.setDefaultRenderer(Object.class,r);
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\u5DE5\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u6C11\u65CF", "\u653F\u6CBB\u9762\u8C8C", "\u51FA\u751F\u65E5\u671F", "\u8EAB\u4EFD\u8BC1\u53F7", "\u5B66\u5386", "\u90E8\u95E8", "\u7535\u8BDD"
			}
		));
		scrollPane.setViewportView(table);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_2.add(panel_5, "name_1692753284430700");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(96)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(130, Short.MAX_VALUE))
		);
		
		table_1 = new JTable();
		 DefaultTableCellRenderer r_1=new DefaultTableCellRenderer();
	        r_1.setHorizontalAlignment(JLabel.CENTER);
	        table_1.setDefaultRenderer(Object.class,r_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\u5DE5\u53F7", "\u59D3\u540D", "\u8363\u8A89", "\u8FDD\u89C4"
			}
		));
		scrollPane_1.setViewportView(table_1);
		panel_5.setLayout(gl_panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_2.add(panel_6, "name_1692757224563200");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(93)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(133, Short.MAX_VALUE))
		);
		
		table_2 = new JTable();
		 DefaultTableCellRenderer r_2=new DefaultTableCellRenderer();
	        r_2.setHorizontalAlignment(JLabel.CENTER);
	        table_2.setDefaultRenderer(Object.class,r_2);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"\u5DE5\u53F7", "\u59D3\u540D", "\u7F3A\u52E4\u6B21\u6570", "\u51FA\u52E4\u6B21\u6570", "\u8BF7\u5047\u6B21\u6570"
			}
		));
		scrollPane_2.setViewportView(table_2);
		panel_6.setLayout(gl_panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		panel_2.add(panel_7, "name_1692761889541900");
		
		JScrollPane scrollPane_3 = new JScrollPane();
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 701, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(82, Short.MAX_VALUE))
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addGap(84)
					.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(141, Short.MAX_VALUE))
		);
		
		table_3 = new JTable();
		 DefaultTableCellRenderer r_3=new DefaultTableCellRenderer();
	        r_3.setHorizontalAlignment(JLabel.CENTER);
	        table_3.setDefaultRenderer(Object.class,r_3);
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\u5DE5\u53F7", "\u59D3\u540D", "\u57FA\u7840\u5DE5\u8D44", "\u5956\u91D1", "\u6263\u9664\u5DE5\u8D44", "\u6D25\u8D34", "\u5E94\u53D1\u5DE5\u8D44", "\u5B9E\u53D1\u5DE5\u8D44"
			}
		));
		scrollPane_3.setViewportView(table_3);
		panel_7.setLayout(gl_panel_7);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Employee> mt=Utils.selectEmpAll();
				for(int i=0;i<mt.size();i++)
				{
					table.setValueAt(mt.get(i).getEmpId(), i, 0);
					table.setValueAt(mt.get(i).getName(), i, 1);
					table.setValueAt(mt.get(i).getSex(), i, 2);
					table.setValueAt(mt.get(i).getAge(), i, 3);
					table.setValueAt(mt.get(i).getNation(), i, 4);
					table.setValueAt(mt.get(i).getPolitics(), i, 5);
					table.setValueAt(mt.get(i).getBirth(), i, 6);
					table.setValueAt(mt.get(i).getIdCardNum(), i, 7);
					table.setValueAt(mt.get(i).getAcademic(), i, 8);
					table.setValueAt(mt.get(i).getDepartNo(), i, 9);
					table.setValueAt(mt.get(i).getTel(), i, 10);
				}
				panel_3.setVisible(false);
				panel_4.setVisible(true);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
			}
		});
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Exam> ei=Utils.selectExamAll();
				for(int i=0;i<ei.size();i++) {
					table_1.setValueAt(ei.get(i).getEmpId(), i,0);
					table_1.setValueAt(ei.get(i).getEmpName(), i,1);
					table_1.setValueAt(ei.get(i).getAward(), i,2);
					table_1.setValueAt(ei.get(i).getIllegal(), i,3);
					
				}
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(true);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
			}
		});
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Attendence> rr=Utils.selectAttendAll();
				for(int i=0;i<rr.size();i++)
				{
					table_2.setValueAt(rr.get(i).getEmpId(),i, 0);
					table_2.setValueAt(rr.get(i).getEmpName(),i, 1);
					table_2.setValueAt(rr.get(i).getAbsence(),i,2);
					table_2.setValueAt(rr.get(i).getAttend(),i, 3);
					table_2.setValueAt(rr.get(i).getLeave(),i, 4);
				}
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(true);
				panel_7.setVisible(false);
			}
		});
		
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Salary> op=Utils.selectSalaryAll();
				for(int i=0;i<op.size();i++) {
				table_3.setValueAt(op.get(i).getEmpId(), i, 0);
				table_3.setValueAt(op.get(i).getEmpName(), i, 1);
				table_3.setValueAt(op.get(i).getBasic(), i, 2);
				table_3.setValueAt(op.get(i).getReward(), i, 3);
				table_3.setValueAt(op.get(i).getDeduction(), i, 4);
				table_3.setValueAt(op.get(i).getAllowance(), i, 5);
				table_3.setValueAt(op.get(i).getYfSalary(), i, 6);
				table_3.setValueAt(op.get(i).getSfSalary(), i, 7);
				}
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_7.setVisible(true);
			}
		});
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tr=textField.getText();
				System.out.println(tr);
				boolean o=Utils.Delete(tr);
				if(o)
				{
					label_1.setText("成功！");
				}
				else
				{
					label_1.setText("失败");
				}
			}
		});
	}
}
