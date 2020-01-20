package com.h.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.h.Util.DbUtil;
import com.h.Util.StringUtil;
import com.h.dao.BookDao;
import com.h.dao.BookTypeDao;
import com.h.model.Book;
import com.h.model.BookType;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookMangeInnerFrame extends JFrame {

	private JPanel contentPane;
	private JTable bookTable;
	private JTextField bookNameTxt;
	private JTextField bookAuthoeTex;
	private JComboBox bookTypeJcb;
	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private BookDao bookDao=new BookDao();
	private JTextField idTex;
	private JTextField bookNameTxt1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField priceTxt;
	private JTextField authorTxt;
	private JRadioButton manJrb;
	private JRadioButton womanJrb;
	private JTextArea bookDescTxt;
	private JComboBox bookTypeTxtJcb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookMangeInnerFrame frame = new BookMangeInnerFrame();
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
	public BookMangeInnerFrame() {
		setTitle("图书管理");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 659);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u68C0\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(59, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 820, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(3)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		
		JLabel label_3 = new JLabel("编   号：");
		
		idTex = new JTextField();
		idTex.setEditable(false);
		idTex.setColumns(10);
		
		JLabel label_4 = new JLabel("图书名称：");
		
		bookNameTxt1 = new JTextField();
		bookNameTxt1.setColumns(10);
		
		JLabel label_5 = new JLabel("作者性别：");
		
		manJrb = new JRadioButton("男");
		buttonGroup.add(manJrb);
		manJrb.setSelected(true);
		
		womanJrb = new JRadioButton("女");
		buttonGroup.add(womanJrb);
		
		JLabel label_6 = new JLabel("价   格：");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel label_7 = new JLabel("作   者：");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel label_8 = new JLabel("图书类别：");
		
		bookTypeTxtJcb = new JComboBox();
		
		JLabel label_9 = new JLabel("图书描述：");
		
		bookDescTxt = new JTextArea();
		
		JButton button_1 = new JButton("修改");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookUpdateActionPerformed(arg0);
			}
		});
		
		JButton button_2 = new JButton("删除");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookDeleteActionPerformed(arg0);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_9)
							.addGap(15)
							.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 605, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_6)
								.addComponent(label_3))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(16)
									.addComponent(idTex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(18)
									.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(79)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookNameTxt1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_7)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(authorTxt)))
							.addGap(78)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(manJrb)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(womanJrb))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_8)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookTypeTxtJcb, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(127, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(257, Short.MAX_VALUE)
					.addComponent(button_1)
					.addGap(170)
					.addComponent(button_2)
					.addGap(306))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_3))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(10)
							.addComponent(idTex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(12)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_4)
								.addComponent(bookNameTxt1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(manJrb)
								.addComponent(womanJrb)
								.addComponent(label_5))))
					.addGap(23)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_8)
						.addComponent(bookTypeTxtJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(33)
							.addComponent(label_9))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(30)
							.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(button_1)
						.addComponent(button_2))
					.addGap(15))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel label = new JLabel("图书名称：");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("图书作者：");
		
		bookAuthoeTex = new JTextField();
		bookAuthoeTex.setColumns(10);
		
		JLabel label_2 = new JLabel("图书类别：");
		
		bookTypeJcb = new JComboBox();
		
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookSearchActionPerformed(arg0);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookAuthoeTex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(49)
					.addComponent(label_2)
					.addGap(28)
					.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(29))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(16, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(bookAuthoeTex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2)
								.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(button))
							.addGap(12))))
		);
		panel.setLayout(gl_panel);
		
		bookTable = new JTable();
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				bookTableMousePressed(arg0);
			}
		});
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u4F5C\u8005\u6027\u522B", "\u56FE\u4E66\u4EF7\u683C", "          \u56FE\u4E66\u63CF\u8FF0", "\u56FE\u4E66\u7C7B\u522B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTable.getColumnModel().getColumn(5).setPreferredWidth(237);
		scrollPane.setViewportView(bookTable);
		contentPane.setLayout(gl_contentPane);
		//设置文本域边框
	    bookDescTxt.setBorder(new LineBorder(new Color(127,157,185)));
		this.fillBookType("search");
		this.fillBookType("modify");

		this.fillTable(new Book());
	}
	/**
	 * 图书删除事件处理
	 * @param arg0
	 */
	private void bookDeleteActionPerformed(ActionEvent arg0) {
		String id=idTex.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确认要删除此记录吗");
		if(n==0) {
			Connection con=null;
			try {
				con=dbUtil.getConnection();
				int deleteNum=bookDao.delete(con, id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new Book());
				}else {
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败");
				// TODO: handle exception
			}finally {
				try {
					dbUtil.closeCollection(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	/**
	 * 图书修改事件处理
	 * @param arg0
	 */
	private void bookUpdateActionPerformed(ActionEvent arg0) {
		String id=this.idTex.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的书籍");
			return;
		}
		String bookName=this.bookNameTxt1.getText();
		String author=this.authorTxt.getText();
		String price=this.priceTxt.getText();
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
		Book book=new Book(Integer.parseInt(id), bookName, author, sex,Float.parseFloat(price), bookTypeId,bookDesc);
		Connection con=null;
		try {
			con=dbUtil.getConnection();
			int n=bookDao.update(con, book);//n=1代表添加成功
			if(n==1) {
				JOptionPane.showMessageDialog(null, "修改成功！");
				resetValue();
				fillTable(new Book());
			}else {
				JOptionPane.showMessageDialog(null, "修改失败！");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败！");
	
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
	 * 重置表单
	 */
	private void resetValue() {
		this.idTex.setText("");
		this.bookNameTxt1.setText("");
		this.authorTxt.setText("");
		this.priceTxt.setText("");
		this.manJrb.setSelected(true);
		this.bookDescTxt.setText("");
		if(this.bookTypeTxtJcb.getItemCount()>0) {//如果图书类别不为空
			this.bookTypeTxtJcb.setSelectedIndex(0);
		}
		
	}
	/**
	 * 表格含点击事件处理
	 * @param arg0
	 */
	private void bookTableMousePressed(MouseEvent arg0) {
		int row=this.bookTable.getSelectedRow();
		this.idTex.setText((String)bookTable.getValueAt(row, 0));
		this.bookNameTxt1.setText((String)bookTable.getValueAt(row, 1));
		this.authorTxt.setText((String)bookTable.getValueAt(row, 2));
		String sex=(String)bookTable.getValueAt(row, 3);
		if("男".equals(sex)) {
			this.manJrb.setSelected(true);
		}else if("女".equals(sex)) {
			this.womanJrb.setSelected(true);
		}
		this.priceTxt.setText((Float)bookTable.getValueAt(row, 4)+"");
		this.bookDescTxt.setText((String) bookTable.getValueAt(row, 5));
		String bookTypeName=(String) this.bookTable.getValueAt(row, 6);
		int n=this.bookTypeTxtJcb.getItemCount();
		for(int i=0;i<n;i++) {
			BookType item=(BookType) this.bookTypeTxtJcb.getItemAt(i);
			if(item.getBookTypeName().equals(bookTypeName)) {
				this.bookTypeTxtJcb.setSelectedIndex(i);
			}
		}

		
	}

	/**
	 * 图书查询事件处理
	 * @param arg0
	 */
	private void bookSearchActionPerformed(ActionEvent arg0) {
		String bookName=this.bookNameTxt.getText();
		String author=this.bookAuthoeTex.getText();
		BookType bookType=(BookType) this.bookTypeJcb.getSelectedItem();
		int bookTypeId=bookType.getId();
		Book book=new Book(bookName, author, bookTypeId);
		this.fillTable(book);
	}

	/**
	 * 初始化下拉框
	 * @param type下拉框类型
	 */
	private void fillBookType(String type) {
		Connection con=null;
		BookType bookType=null;
		try {
			con=dbUtil.getConnection();
			ResultSet rs=bookTypeDao.list(con, new BookType());
			if("search".equals(type)) {
				bookType=new BookType();
				bookType.setBookTypeName("请选择...");
				bookType.setId(-1);
				this.bookTypeTxtJcb.addItem(bookType);
			}
			while(rs.next()) {
				bookType=new BookType();
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				bookType.setId(rs.getInt("id"));
				if("search".equals(type)) {
					this.bookTypeJcb.addItem(bookType);
				}else if("modify".equals(type)) {
					this.bookTypeTxtJcb.addItem(bookType);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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
	 * 初始化表格数据
	 * @param book
	 */
	private void fillTable(Book book) {
		DefaultTableModel dtm= (DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0);//设置成0行，清空表格
		Connection con=null;
		try {
			con=dbUtil.getConnection();
			ResultSet rs= bookDao.list(con, book);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookName"));
				v.add(rs.getString("author"));
				v.add(rs.getString("sex"));
				v.add(rs.getFloat("price"));
				v.add(rs.getString("bookDesc"));
				v.add(rs.getString("bookTypeName"));
				dtm.addRow(v);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCollection(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
