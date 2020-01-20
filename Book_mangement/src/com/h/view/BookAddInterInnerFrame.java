package com.h.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.h.Util.DbUtil;
import com.h.Util.StringUtil;
import com.h.dao.BookDao;
import com.h.dao.BookTypeDao;
import com.h.model.Book;
import com.h.model.BookType;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookAddInterInnerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField bookNameTex;
	private JTextField bookAuthorTex;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField bookpriceTex;
	private JComboBox bookTypeJcb;
	private JTextArea bookDescTxt;
	private JRadioButton manJrb;
	private JRadioButton womanJrb;

	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private BookDao bookDao=new BookDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddInterInnerFrame frame = new BookAddInterInnerFrame();
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
	public BookAddInterInnerFrame() {
		setTitle("图书添加");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("图书名称：");
		
		JLabel lblNewLabel_1 = new JLabel("图书作者：");
		
		bookNameTex = new JTextField();
		bookNameTex.setColumns(10);
		
		bookAuthorTex = new JTextField();
		bookAuthorTex.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("作者性别：");
		
		manJrb = new JRadioButton("男");
		buttonGroup.add(manJrb);
		manJrb.setSelected(true);
		
		womanJrb = new JRadioButton("女");
		buttonGroup.add(womanJrb);
		
		JLabel lblNewLabel_3 = new JLabel("图书价格：");
		
		bookpriceTex = new JTextField();
		bookpriceTex.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("图书描述：");
		
		bookDescTxt = new JTextArea();
		
		JLabel label = new JLabel("图书类别：");
		
		bookTypeJcb = new JComboBox();
		
		JButton button = new JButton("添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//
				bookAddActionPerformed(arg0);
			}

			
		});
		
		JButton button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetValueActionPerfermed(arg0);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(62)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(45)
							.addComponent(bookNameTex, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_2))
							.addGap(36)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(manJrb)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(womanJrb)
									.addGap(129)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_1)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(bookAuthorTex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_3)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(bookpriceTex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGap(3))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addGap(42)
							.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
					.addGap(103))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(228, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(176)
					.addComponent(button_1)
					.addGap(156))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(bookNameTex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(bookAuthorTex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(manJrb)
						.addComponent(womanJrb)
						.addComponent(lblNewLabel_3)
						.addComponent(bookpriceTex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addGap(74))
		);
		contentPane.setLayout(gl_contentPane);
		//设置文本域边框
		bookDescTxt.setBorder(new LineBorder(new Color(127,157,185)));
		fillBookType();
	}
	/**
	 * 重置事件处理
	 * @param arg0
	 */
	private void resetValueActionPerfermed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		resetValue();
	}

	/**
	 * 图书添加事件处理
	 * @param arg0
	 */
	private void bookAddActionPerformed(ActionEvent arg0) {
		String bookName=this.bookNameTex.getText();
		String author=this.bookAuthorTex.getText();
		String price=this.bookpriceTex.getText();
		String bookDesc=this.bookDescTxt.getText();
		if(StringUtil.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "图书名称不能为空");
			return;
		}
		if(StringUtil.isEmpty(author)) {
			JOptionPane.showMessageDialog(null, "图书作者不能为空");
			return;
		}
		if(StringUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "图书价格不能为空");
			return;
		}
		String sex="";
		if(manJrb.isSelected()) {
			sex="男";
		}else if(womanJrb.isSelected()) {
			sex="女";
		}
		BookType bookType= (BookType) bookTypeJcb.getSelectedItem();
		int bookTypeId=bookType.getId();
		Book book=new Book(bookName,author, sex, Float.parseFloat(price),bookTypeId,bookDesc);
		Connection con=null;
		try {
			con=dbUtil.getConnection();
			int addNum=bookDao.add(con, book);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null, "添加成功");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "添加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "添加失败");
			// TODO: handle exception
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 重置表单
	 */
	private void resetValue() {
		this.bookNameTex.setText("");
		this.bookAuthorTex.setText("");
		this.bookpriceTex.setText("");
		this.manJrb.setSelected(true);
		this.bookDescTxt.setText("");
		if(this.bookTypeJcb.getItemCount()>0) {//如果图书类别不为空
			this.bookTypeJcb.setSelectedIndex(0);
		}
		
	}

	/**
	 * 图书类别提示,初始化图书类别下拉框
	 */
	private void fillBookType() {
		Connection con=null;
		BookType bookType=null;
		try {
			con=dbUtil.getConnection();
			ResultSet rs= bookTypeDao.list(con, new BookType());
			while(rs.next()) {
				bookType=new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				this.bookTypeJcb.addItem(bookType);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
