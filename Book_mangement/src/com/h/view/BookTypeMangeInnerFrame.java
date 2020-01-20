package com.h.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
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
import com.h.model.BookType;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookTypeMangeInnerFrame extends JFrame {

	private JPanel contentPane;
	private JTable bookTypetable;
	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao  = new BookTypeDao();
	private BookDao bookDao  = new BookDao();

	private JTextField searchTex;
	private JTextField idTex;
	private JTextField bookTypeNameTxt;
	private JTextArea bookTypeDescTxt;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeMangeInnerFrame frame = new BookTypeMangeInnerFrame();
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
	public BookTypeMangeInnerFrame() {
		setAlwaysOnTop(true);
		setTitle("图书类别管理");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("图书类别名称：");
		
		searchTex = new JTextField();
		searchTex.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookTypeSearchActionPeformed(arg0);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(91)
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(searchTex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(63)
							.addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(71)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(134, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(searchTex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(44)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
		);
		
		JLabel lblNewLabel_1 = new JLabel("编号：");
		
		idTex = new JTextField();
		idTex.setEditable(false);
		idTex.setText("");
		idTex.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("图书类别名称：");
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("描述：");
		
	    bookTypeDescTxt = new JTextArea();
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookTypeUpdate(arg0);
			}
		});
		
		JButton btnNewButton_2 = new JButton("删除");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookDelete(arg0);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(idTex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(lblNewLabel_2)
							.addGap(18)
							.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(12)
								.addComponent(btnNewButton_1)
								.addPreferredGap(ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
								.addComponent(btnNewButton_2)
								.addGap(17))
							.addComponent(bookTypeDescTxt, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)))
					.addGap(34))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(idTex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_2)
							.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		bookTypetable = new JTable();
		bookTypetable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				bookTypeMousePressed(arg0);
			}
		});
		bookTypetable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTypetable.getColumnModel().getColumn(1).setPreferredWidth(120);
		bookTypetable.getColumnModel().getColumn(2).setPreferredWidth(103);
		scrollPane.setViewportView(bookTypetable);
		contentPane.setLayout(gl_contentPane);
		//设置文本域边框
		bookTypeDescTxt.setBorder(new LineBorder(new Color(127,157,185)));
		this.fillTable(new BookType());
	}
	/**
	 * 删除事件处理
	 * @param arg0
	 */
	private void bookDelete(ActionEvent arg0) {
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
				boolean flag=bookDao.isExistBookTypeId(con,id);
				if(flag) {
					JOptionPane.showMessageDialog(null, "当前图书类别下有图书，不能删除");
					return;
				}
				int deleteNum=bookTypeDao.delete(con, id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new BookType());
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

	private void bookTypeUpdate(ActionEvent arg0) {
		String id=idTex.getText();
		String bookTypeName=bookTypeNameTxt.getText();
		String bookTypeDesc=bookTypeDescTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			this.resetValue();
			this.fillTable(new BookType());
			
		}
		if(StringUtil.isEmpty(bookTypeName)) {
			JOptionPane.showMessageDialog(null, "图书类别名称不能为空");
			this.resetValue();
			this.fillTable(new BookType());
			
		}
		BookType bookType=new BookType(Integer.parseInt(id),bookTypeName,bookTypeDesc);
		Connection con=null;
		try {
			con=dbUtil.getConnection();
			int modifynumber=bookTypeDao.update(con, bookType);
			if(modifynumber==1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				this.resetValue();
				this.fillTable(new BookType());
				
			}else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败");

		}finally {
			try {
				dbUtil.closeCollection(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 表格行点击事件处理
	 * @param arg0
	 */
	private void bookTypeMousePressed(MouseEvent arg0) {
		int row=bookTypetable.getSelectedRow();
		idTex.setText((String)bookTypetable.getValueAt(row, 0));
		bookTypeNameTxt.setText((String) bookTypetable.getValueAt(row, 1));
		bookTypeDescTxt.setText((String) bookTypetable.getValueAt(row, 2));
	}

	/**
	 * 图书类别查询事件处理
	 * @param arg0
	 */
	private void bookTypeSearchActionPeformed(ActionEvent arg0) {
		String s_bookTypeName=this.searchTex.getText();
		BookType bookType=new BookType(s_bookTypeName);
		this.fillTable(bookType);
	}

	/**
	 * 表中传数据,初始化表格
	 * @param bookType
	 */
	private void fillTable(BookType bookType) {
		DefaultTableModel dtm= (DefaultTableModel) bookTypetable.getModel();
		dtm.setRowCount(0);//设置成0行，清空表格
		Connection con=null;
		try {
			con=dbUtil.getConnection();
			ResultSet rs= bookTypeDao.list(con, bookType);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookTypeName"));
				v.add(rs.getString("bookTypeDesc"));
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
	/**
	 * 重置表单
	 */
	private void resetValue() {
		this.idTex.setText("");
		this.bookTypeNameTxt.setText("");
		this.bookTypeDescTxt.setText("");
		
	}
}
