package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.EmpBean;
import com.regi.RegiAction;
import java.sql.ResultSet;

//connection to database
public class CandidateDao {
	
	public static Connection con;
	public static Connection connectionz() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection("jdbc:mysql://localhost/in0719a39a?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","IN0719A39A","HFSii88Tt");
		return con;
		
	}
	//IN0719A39A
	//HFSii88Tt
	//save data in database
	public static int register(RegiAction ra) {
		int flag = 0;
		try {
			
			PreparedStatement pst = connectionz().prepareStatement("INSERT INTO register(fname,lname,uname,gender,email,pass,phone,address) VALUES (?,?,?,?,?,?,?,?)");
		
			pst.setString(1, ra.getFname());
			pst.setString(2, ra.getLname());
			pst.setString(3, ra.getUname());
			pst.setString(4, ra.getGender());
			pst.setString(5, ra.getEmail());
			pst.setString(6, ra.getPass());
			pst.setString(7, ra.getPhone());
			pst.setString(8, ra.getAddress());
			
			flag = pst.executeUpdate();
		}
		catch (Exception ex) {
			
			ex.printStackTrace();
		}
		return flag;
		
		
		
	}
	//fetch saved data 
	public ResultSet report(String email) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM register Where email=?";
			PreparedStatement ps = connectionz().prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (connectionz() != null) {
				connectionz().close();
			}
		}
	}

	// search view
	public ResultSet search(String find) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM register WHERE fname LIKE ? OR lname LIKE ? OR uname LIKE ? OR gender LIKE ? OR email LIKE ? ";
			PreparedStatement ps = connectionz().prepareStatement(sql);
			ps.setString(1, find);
			ps.setString(2, find);
			ps.setString(3, find);
			ps.setString(4, find);
			ps.setString(5, find);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (connectionz() != null) {
				connectionz().close();
			}
		}
	}
	
	public static EmpBean view(String email) throws SQLException, Exception {
		EmpBean bean = null;
		try {
			String sql = "SELECT * FROM register Where email=?";
			PreparedStatement ps = connectionz().prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				bean = new EmpBean();
				bean.setFname(rs.getString("fname"));
				bean.setLname(rs.getString("lname"));
				bean.setUname(rs.getString("uname"));
				bean.setEmail(rs.getString("email"));
				bean.setPass(rs.getString("pass"));
				bean.setGender(rs.getString("gender"));
				bean.setPhone(rs.getString("phone"));
				bean.setAddress(rs.getString("address"));
			}
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (connectionz() != null) {
				connectionz().close();
			}
		}
	}
	
	//  admin user
	public static  ResultSet admin() throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT fname,lname,uname,gender,email,pass,phone,address FROM register";
			PreparedStatement ps = connectionz().prepareStatement(sql);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (connectionz() != null) {
				connectionz().close();
			}
		}
	}
		
	//update new data
	public int updateUserDetails(EmpBean bean, String email)
			throws SQLException, Exception {
		int i = 0;
		try {
			String sql = "UPDATE register SET fname=?, lname=?, uname=?, gender=?, phone=?, address=? WHERE email=?";
			PreparedStatement ps = connectionz().prepareStatement(sql);
			ps.setString(1, bean.getFname());
			ps.setString(2, bean.getLname());
			ps.setString(3, bean.getUname());
			ps.setString(4, bean.getGender());
			ps.setString(5, bean.getPhone());
			ps.setString(6, bean.getAddress());
			ps.setString(7, email);
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}return i;
		
	}
	
	//delete from database
	public int deleteUserDetails(String email) throws SQLException, Exception {
		connectionz().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "DELETE FROM register WHERE email=?";
			PreparedStatement ps = connectionz().prepareStatement(sql);
			ps.setString(1, email);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			connectionz().rollback();
			return 0;
		} finally {
			if (connectionz() != null) {
				connectionz().close();
			}
		}
	}
	
}
