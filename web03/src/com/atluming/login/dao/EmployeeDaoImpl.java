package com.atluming.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.atluming.login.beans.Department;
import com.atluming.login.beans.Employee;
import com.atluming.login.util.DbUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public List<Employee> selectAllEmplyee() {
		// TODO Auto-generated method stub
		List<Employee> emps=new ArrayList<Employee>();
		try {
			Connection con=DbUtil.getConnection();
			String sql="select e.id eid,e.last_name,e.email,e.gender,d.id did,d.depName from employee e,department d where e.d_id=d.id";
			System.out.println(sql);
			PreparedStatement pstm=con.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			while(rs.next()) {
				Employee employee=new Employee();
				employee.setId(rs.getInt("eid"));
				employee.setLastName(rs.getString("last_name"));
				employee.setEmail(rs.getString("email"));
				employee.setGender(rs.getString("gender"));
				
				Department department=new Department();
				department.setId(rs.getInt("did"));
				department.setDepName(rs.getString("depName"));
				employee.setDept(department);
				emps.add(employee);
			}
			return emps;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			try {
				DbUtil.closeConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}
	

}
