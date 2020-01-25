package control;
		import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.PreparedStatement;
		import java.sql.ResultSet;
		import java.sql.SQLException;
		import java.util.ArrayList;

		import ORM.Attendence;
		import ORM.Employee;
		import ORM.Exam;
		import ORM.Salary;
public class Utils {
	private static final String connectionURL = "jdbc:mysql://localhost:3306/person?userUnicode=true&characterEncoding=UTF8&useSSL=false";
	private static final String userName = "root";
	private static final String password = "";
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");//
			return DriverManager.getConnection(connectionURL, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static  void close(ResultSet rs, PreparedStatement stmt, Connection con) {
		if(rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(stmt != null)
			try {
				stmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		if(con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static boolean PdemPassword(String account,String Password) {
		Connection con=Utils.getConnection();
		boolean boo = false;
		PreparedStatement ps=null;
		ResultSet re=null;
		try {
			ps = con.prepareStatement("SELECT empId FROM empmessage WHERE empId = ?AND password=?");
			ps.setString(1, account);
			ps.setString(2, Password);
			re = ps.executeQuery();
			boo = re.next();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("SQL语句错误");
		}
		return boo;
	}
	public static boolean PdadPassword(String account,String Password) {
		Connection con=Utils.getConnection();
		boolean boo = false;
		PreparedStatement ps=null;
		ResultSet re=null;
		try {
			ps = con.prepareStatement("SELECT * FROM empmessage WHERE empId = ?AND password=?");
			ps.setString(1, account);
			ps.setString(2, Password);
			//ps.setString(3, "01");
			re = ps.executeQuery();
			boo = re.next();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("SQL语句错误");
		}
		return boo;
	}
	public static Employee selectOne(String id) {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			con = Utils.getConnection();
			String sql = "select empId ,empName,sex,age,nation,politics,birth,IDnumber,title,academic,department.depName,tel "
					+ "from empmessage,department where department.Num=empmessage.departNo and empId = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			Employee emp = new Employee();
			while(rs.next()) {
				emp.setEmpId(rs.getString("empId"));
				emp.setName(rs.getString("empName"));
				emp.setAge(rs.getInt("age"));
				emp.setSex(rs.getString("sex"));
				emp.setIdCardNum(rs.getString("IDnumber"));
				emp.setTel(rs.getString("tel"));
				emp.setDepartNo(rs.getString("depName"));
				emp.setTitle(rs.getString("title"));
				emp.setNation(rs.getString("nation"));
				emp.setBirth(rs.getString("birth"));
				emp.setAcademic(rs.getString("academic"));
				emp.setPolitics(rs.getString("politics"));
			}
			return emp;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Utils.close(rs, stmt, con);
		}
		return null;
	}
	public static Salary selectSalaryOne(String id) {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			con = Utils.getConnection();//��ȡ����
			String sql = "select empmessage.empId,empmessage.empName,salary.basic,salary.reward,salary.deduction,salary.allowance,salarymanage.yfSalary,salarymanage.sfSalary\r\n" +
					"from salarymanage,salary,empmessage\r\n" +
					"where empmessage.empId=salarymanage.empId and salarymanage.id=salary.id and empmessage.empId =?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			Salary salary = new Salary();
			while(rs.next()) {
				salary.setEmpId(rs.getString("empId"));
				salary.setEmpName(rs.getString("empName"));
				salary.setBasic(rs.getInt("basic"));
				salary.setReward(rs.getInt("reward"));
				salary.setDeduction(rs.getInt("deduction"));
				salary.setAllowance(rs.getInt("allowance"));
				salary.setYfSalary(rs.getInt("yfSalary"));
				salary.setSfSalary(rs.getInt("sfSalary"));
			}
			return salary;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {  //�ر�����
			Utils.close(rs, stmt, con);
		}
		return null;
	}
	public static void Changpassword(String account,String Password) {
		Connection con=Utils.getConnection();
		PreparedStatement ps=null;
		try {
			ps = con.prepareStatement("update empmessage set password=? where empId=?");
			ps.setString(1, Password);
			ps.setString(2, account);
			int result=ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("SQL语句错误");
		}
	}
	public static ArrayList<Exam> selectExamAll(String s){
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			con = Utils.getConnection();//��ȡ����
			String sql = "select empmessage.empId, empmessage.empName, award, illegal\r\n" +
					"from exam, exammanage,empmessage\r\n" +
					"where exammanage.empId =? and exam.examNo = exammanage.examNo and empmessage.empId=exammanage.empId";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, s);
			rs = stmt.executeQuery();
			ArrayList<Exam> list = new ArrayList<>();
			while(rs.next()) {
				Exam exam = new Exam();
				exam.setEmpId(rs.getString("empId"));
				exam.setEmpName(rs.getString("empName"));
				exam.setAward(rs.getString("award"));
				exam.setIllegal(rs.getString("illegal"));
				list.add(exam);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {  //�ر�����
			Utils.close(rs, stmt, con);
		}
		return null;
	}
	public static ArrayList<Employee> selectEmpAll() {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			con = Utils.getConnection();
			String sql = "select empId ,empName,sex,age,nation,politics,birth,IDnumber,title,academic,department.depName,tel "
					+ "from empmessage,department where department.Num=empmessage.departNo";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			ArrayList<Employee> list = new ArrayList<>();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getString("empId"));
				emp.setName(rs.getString("empName"));
				emp.setAge(rs.getInt("age"));
				emp.setSex(rs.getString("sex"));
				emp.setIdCardNum(rs.getString("IDnumber"));
				emp.setTel(rs.getString("tel"));
				emp.setDepartNo(rs.getString("depName"));
				emp.setTitle(rs.getString("title"));
				emp.setNation(rs.getString("nation"));
				emp.setBirth(rs.getString("birth"));
				emp.setAcademic(rs.getString("academic"));
				emp.setPolitics(rs.getString("politics"));
				list.add(emp);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {  //�ر�����
			Utils.close(rs, stmt, con);
		}
		return null;
	}
	public static ArrayList<Exam> selectExamAll(){
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			con = Utils.getConnection();//��ȡ����
			String sql = "select empmessage.empId, empmessage.empName, award, illegal\r\n" +
					"from exam, exammanage,empmessage\r\n" +
					"where exam.examNo = exammanage.examNo and empmessage.empId=exammanage.empId";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			ArrayList<Exam> list = new ArrayList<>();
			while(rs.next()) {
				Exam exam = new Exam();
				exam.setEmpId(rs.getString("empId"));
				exam.setEmpName(rs.getString("empName"));
				exam.setAward(rs.getString("award"));
				exam.setIllegal(rs.getString("illegal"));
				list.add(exam);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {  //�ر�����
			Utils.close(rs, stmt, con);
		}
		return null;
	}
	public static ArrayList<Attendence> selectAttendAll(){
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			con = Utils.getConnection();//��ȡ����
			String sql = "select empmessage.empId,empmessage.empName, absence, attend,leaveOut\r\n" +
					"from attendence, attendmanage,empmessage\r\n" +
					"where attendence.attNo = attendmanage.attNo and empmessage.empId=attendmanage.empId";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			ArrayList<Attendence> list = new ArrayList<>();
			while(rs.next()) {
				Attendence attendence = new Attendence();
				attendence.setEmpId(rs.getString("empId"));
				attendence.setEmpName(rs.getString("empName"));;
				attendence.setAbsence(rs.getInt("absence"));
				attendence.setAttend(rs.getInt("attend"));
				attendence.setLeave(rs.getInt("leaveOut"));
				list.add(attendence);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {  //�ر�����
			Utils.close(rs, stmt, con);
		}
		return null;
	}
	public static ArrayList<Salary> selectSalaryAll(){
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			con = Utils.getConnection();//��ȡ����
			String sql = "select empmessage.empId,empmessage.empName,salary.basic,salary.reward,salary.deduction,salary.allowance,salarymanage.yfSalary,salarymanage.sfSalary\r\n" +
					"from salarymanage,salary,empmessage\r\n" +
					"where empmessage.empId=salarymanage.empId and salarymanage.id=salary.id";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			ArrayList<Salary> list = new ArrayList<>();
			while(rs.next()) {
				Salary salary = new Salary();
				salary.setEmpId(rs.getString("empId"));
				salary.setEmpName(rs.getString("empName"));
				salary.setBasic(rs.getInt("basic"));
				salary.setReward(rs.getInt("reward"));
				salary.setDeduction(rs.getInt("deduction"));
				salary.setAllowance(rs.getInt("allowance"));
				salary.setYfSalary(rs.getInt("yfSalary"));
				salary.setSfSalary(rs.getInt("sfSalary"));
				list.add(salary);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {  //�ر�����
			Utils.close(rs, stmt, con);
		}
		return null;
	}
	public static boolean Insert(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String k,String l,String m) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = Utils.getConnection();//��ȡ����
			String sql="INSERT \r\n" +
					"into empmessage\r\n" +
					"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)\r\n" +
					"";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, a);
			stmt.setString(2, b);
			stmt.setString(3, c);
			stmt.setString(4, d);
			stmt.setString(5, e);
			stmt.setString(6, f);
			stmt.setString(7, g);
			stmt.setString(8, h);
			stmt.setString(9, i);
			stmt.setString(10, j);
			stmt.setString(11, k);
			stmt.setString(12, l);
			stmt.setString(13, m);
			int result = stmt.executeUpdate();
			if(result > 0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {  //�ر�����
			Utils.close(null, stmt, con);
		}
		return false;
	}
	public static boolean Delete(String a) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = Utils.getConnection();//��ȡ����
			String sql="Delete from  empmessage where empId=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, a);
			int result = stmt.executeUpdate();
			if(result > 0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {  //�ر�����
			Utils.close(null, stmt, con);
		}
		return false;
	}
	public static void main(String[] args) {
		ArrayList<Employee> cs=Utils.selectEmpAll();
		System.out.println(cs.get(1).getName());
	}
}
