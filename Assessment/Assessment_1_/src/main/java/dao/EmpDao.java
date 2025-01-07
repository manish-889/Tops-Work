package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import util.DbConnector;

public class EmpDao {

	Connection con = null;
	
	public EmpDao() {
		con = DbConnector.getConnection();
	}

	public int addEmp(Employee emp) {
		
		int i = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO emp(fname,lname,email,mob,address,gender,password,cpassword) VALUES(?,?,?,?,?,?,?,?)");
			ps.setString(1, emp.getFname());
			ps.setString(2, emp.getLname());
			ps.setString(3, emp.getEmail());
			ps.setString(4, emp.getMob());
			ps.setString(5, emp.getAddress());
			ps.setString(6, emp.getGender());
			ps.setString(7, emp.getPassword());
			ps.setString(8, emp.getCpassword());
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public List<Employee> displayAllEmployee() {
		
		List<Employee> list = new ArrayList<>();
		
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM emp");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setFname(rs.getString(2));
				emp.setLname(rs.getString(3));
				emp.setEmail(rs.getString(4));
				emp.setMob(rs.getString(5));
				
				list.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public int deleteEmp(int uid) {
		int i = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM emp WHERE id = '"+uid+"'");
			
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public Employee getEmpById(int uid) {
		
		Employee emp = new Employee();
		
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM emp WHERE id = '"+uid+"'");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				emp.setId(rs.getInt(1));
				emp.setFname(rs.getString(2));
				emp.setLname(rs.getString(3));
				emp.setEmail(rs.getString(4));
				emp.setMob(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emp;
	}

	public int updateEmployeeDetails(Employee emp) {
		
		int i = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE emp SET fname=?, lname=?, email=?,mob=? WHERE id = ?");
			ps.setString(1, emp.getFname());
			ps.setString(2, emp.getLname());
			ps.setString(3, emp.getEmail());
			ps.setString(4, emp.getMob());
			ps.setInt(5, emp.getId());
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	
	
}
