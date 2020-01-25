package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import ORM.Employee;
import ORM.Exam;
import ORM.Salary;
import control.Utils;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;

public class emInformation extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private String ac;

	/**
	 * Launch the application.
	 */
	public void setAc(String ac) {
		this.ac=ac;
	};
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					emInformation frame = new emInformation();
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
	public emInformation() {
		setBackground(Color.WHITE);
		setTitle("\u5458\u5DE5\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 587);
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
		
		JButton btnNewButton = new JButton("基本信息");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(204, 153, 204));
		JButton btnNewButton_1 = new JButton("薪资信息");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(221, 160, 221));
		JButton btnNewButton_2 = new JButton("考评信息");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(221, 160, 221));
		JButton btnNewButton_3 = new JButton("修改密码");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(221, 160, 221));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangePassword cp=new ChangePassword();
				cp.setAccou(ac);
				cp.setVisible(true);
			}
		});
		
		JButton btnNewButton_4 = new JButton("退出");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(221, 160, 221));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		panel_1.add(btnNewButton);
		panel_1.add(btnNewButton_1);
		panel_1.add(btnNewButton_2);
		panel_1.add(btnNewButton_3);
		panel_1.add(btnNewButton_4);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 544, GroupLayout.PREFERRED_SIZE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new CardLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_2.add(panel_3, "name_32042007518081");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_2.add(panel_4, "name_32043875275474");
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		// 修改滚动面板背景色
	    scrollPane.getViewport().setBackground(Color.white);
		panel_4.add(scrollPane, BorderLayout.NORTH);
		
		table = new JTable();
		 DefaultTableCellRenderer r=new DefaultTableCellRenderer();
	        r.setHorizontalAlignment(JLabel.CENTER);
	        table.setDefaultRenderer(Object.class,r);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\u5DE5\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u6C11\u65CF", "\u653F\u6CBB\u9762\u8C8C", "\u51FA\u751F\u65E5\u671F", "\u8EAB\u4EFD\u8BC1\u53F7", "\u5B66\u5386", "\u90E8\u95E8", "\u7535\u8BDD"
			}
		));
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, "name_32058444224446");
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		// 修改滚动面板背景色
	    scrollPane_1.getViewport().setBackground(Color.white);
	    
		panel_5.add(scrollPane_1, BorderLayout.CENTER);
		
		table_1 = new JTable();
		 DefaultTableCellRenderer r_1=new DefaultTableCellRenderer();
	        r_1.setHorizontalAlignment(JLabel.CENTER);
	        table_1.setDefaultRenderer(Object.class,r_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\u5DE5\u53F7", "\u59D3\u540D", "\u57FA\u7840\u5DE5\u8D44", "\u5956\u91D1", "\u6263\u9664\u5DE5\u8D44", "\u6D25\u8D34", "\u5E94\u53D1\u5DE5\u8D44", "\u5B9E\u53D1\u5DE5\u8D44"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6, "name_32166526975055");
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		// 修改滚动面板背景色
	    scrollPane_2.getViewport().setBackground(Color.white);
	    
		panel_6.add(scrollPane_2, BorderLayout.CENTER);
		
		table_2 = new JTable();
		 DefaultTableCellRenderer r_2=new DefaultTableCellRenderer();
	        r_2.setHorizontalAlignment(JLabel.CENTER);
	        table_2.setDefaultRenderer(Object.class,r_2);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null, null, null},
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
		scrollPane_2.setViewportView(table_2);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.setVisible(false);
				Employee em=Utils.selectOne(ac);
				table.setValueAt(em.getEmpId(), 0, 0);
				table.setValueAt(em.getName(), 0, 1);
				table.setValueAt(em.getSex(), 0, 2);
				table.setValueAt(em.getAge(), 0, 3);
				table.setValueAt(em.getNation(), 0, 4);
				table.setValueAt(em.getPolitics(), 0, 5);
				table.setValueAt(em.getBirth(), 0, 6);
				table.setValueAt(em.getIdCardNum(), 0, 7);
				table.setValueAt(em.getAcademic(), 0, 8);
				table.setValueAt(em.getDepartNo(), 0, 9);
				table.setValueAt(em.getTel(), 0, 10);
				panel_4.setVisible(true);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Salary sa=Utils.selectSalaryOne(ac);
				table_1.setValueAt(sa.getEmpId(), 0, 0);
				table_1.setValueAt(sa.getEmpName(), 0, 1);
				table_1.setValueAt(sa.getBasic(), 0, 2);
				table_1.setValueAt(sa.getReward(), 0, 3);
				table_1.setValueAt(sa.getDeduction(), 0, 4);
				table_1.setValueAt(sa.getAllowance(), 0, 5);
				table_1.setValueAt(sa.getYfSalary(), 0, 6);
				table_1.setValueAt(sa.getSfSalary(), 0, 7);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(true);
				panel_6.setVisible(false);
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Exam> sf=Utils.selectExamAll(ac);
				for(int i=0;i<sf.size();i++)
				{
					table_2.setValueAt(sf.get(i).getEmpId(), i,0);
					table_2.setValueAt(sf.get(i).getEmpName(), i,1);
					table_2.setValueAt(sf.get(i).getAward(), i,2);
					table_2.setValueAt(sf.get(i).getIllegal(), i,3);
				}
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(true);
			}
		});
	}
}
