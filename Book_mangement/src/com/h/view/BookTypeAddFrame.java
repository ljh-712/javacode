package com.h.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.h.Util.DbUtil;
import com.h.Util.StringUtil;
import com.h.dao.BookTypeDao;
import com.h.model.BookType;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class BookTypeAddFrame extends JFrame {

	private JPanel contentPane;
	private JTextArea bookTypeNameTxt;
	private JTextArea bookTypeDescTxt;
	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao  = new BookTypeDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAddFrame frame = new BookTypeAddFrame();
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
	public BookTypeAddFrame() {
		setTitle("图书类别添加");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("图书类别名称：");
		
		JLabel lblNewLabel = new JLabel("图书类别描述：");
		
		bookTypeNameTxt = new JTextArea();
		
		bookTypeDescTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookTypeAddActionPerformed(arg0);
			}
		});
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reSetValueEvent(e);
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(lblNewLabel))))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(bookTypeNameTxt)
								.addComponent(bookTypeDescTxt, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
							.addContainerGap(83, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(159)
							.addComponent(btnNewButton_1)
							.addGap(71))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(59)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(39)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		/**
		 * 设置文本域边框
		 */
		//设置文本域边框
		bookTypeDescTxt.setBorder(new LineBorder(new Color(127,157,185)));
		
		bookTypeNameTxt.setBorder(new LineBorder(new Color(127,157,185)));
		
	}
	/**
	 * 图书类别添加处理
	 * @param arg0
	 */
	
	private void bookTypeAddActionPerformed(ActionEvent arg0) {
		String bookTypeName=this.bookTypeNameTxt.getText();
		String bookTypeDesc=this.bookTypeDescTxt.getText();
		if(StringUtil.isEmpty(bookTypeName)) {
			JOptionPane.showMessageDialog(null, "图书类别名称不能为空");
			return;
		}
		BookType bookType=new BookType(bookTypeName,bookTypeDesc);
		Connection con=null;
		try {
			con=dbUtil.getConnection();
			int n=bookTypeDao.add(con, bookType);//n=1代表添加成功
			if(n==1) {
				JOptionPane.showMessageDialog(null, "添加成功！");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "添加失败！");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "添加失败！");
	
		} finally {
			// : handle finally clause
			try {
				dbUtil.closeCollection(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	/**
	 * 重置事件处理
	 * @param e
	 */
	private void reSetValueEvent(ActionEvent e) {
		this.resetValue();
		// TODO Auto-generated method stub
		
	}

	/**
	 * 重置
	 */
	private void resetValue() {
		this.bookTypeNameTxt.setText("");
		this.bookTypeDescTxt.setText("");
	}
}
