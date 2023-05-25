package com.kuebiko.it.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kuebiko.it.servlet.dto.SignupDTO;
import com.kuebiko.it.utils.MySQLConnectionUtils;

/**
 * Logic for db
 * 
 * @author javahunk
 *
 */
public class SignupDao {
	
	public static SignupDTO findBySid(int sid) {
		
		SignupDTO signupDTO=null;
		 //JDBC PROGRAMMING
		 try {
				Connection conn=MySQLConnectionUtils.getConnection();
				if(conn!=null) {
					System.out.println("I am connected with database");
				}
				//Creating the query
				String sql="select sid,name,email,gender from  asignup_tbl where sid=?";
				//Creating prepared statement with query
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, sid);
				//fire the query
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					String name=rs.getString("name");
					String email=rs.getString("email");
					String gender=rs.getString("gender");
					signupDTO=new SignupDTO(sid, name, email, gender);
				}
			 
		 }catch (Exception e) {
			 //It will print the problem in details
			 e.printStackTrace();
		}
		 
		 return signupDTO;
	}

	public static List<SignupDTO> search(String textSearch) {

		List<SignupDTO> signupDTOs = new ArrayList<SignupDTO>();
		// JDBC PROGRAMMING
		try {
			// Loading the DRIVER
			// Class is class
			Class.forName("com.mysql.jdbc.Driver");
			// Making connect to the database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch100_db", "root",
					"mysql@1234");
			if (conn != null) {
				System.out.println("I am connected with database");
			}
			// Creating the query
			// Nagendra Kumar
			String sql = "select sid,name,email,gender from  asignup_tbl where name like ? or email like ? or gender like ?";
			// Creating prepared statement with query
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + textSearch + "%");
			pstmt.setString(2, "%" + textSearch + "%");
			pstmt.setString(3, "%" + textSearch + "%");

			// fire the query
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int sid = rs.getInt("sid");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				// 1 row data goes inside one signup dto
				SignupDTO signupDTO = new SignupDTO(sid, name, email, gender);
				signupDTOs.add(signupDTO);
			}

		} catch (Exception e) {
			// It will print the problem in details
			e.printStackTrace();
		}
		return signupDTOs;
	}

	public static List<SignupDTO> findAll() {
		
		List<SignupDTO> signupDTOs = new ArrayList<SignupDTO>();
		// JDBC PROGRAMMING
		try {
			Connection conn = MySQLConnectionUtils.getConnection();
			if (conn != null) {
				System.out.println("I am connected with database");
			}
			// Creating the query
			String sql = "select sid,name,email,gender from  asignup_tbl";
			// Creating prepared statement with query
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// fire the query
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int sid = rs.getInt("sid");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				// 1 row data goes inside one signup dto
				SignupDTO signupDTO = new SignupDTO(sid, name, email, gender);
				signupDTOs.add(signupDTO);
			}

		} catch (Exception e) {
			// It will print the problem in details
			e.printStackTrace();
		}
		return signupDTOs;
	}

	public static void update(String username, String email, String gender, int sid) {
		// JDBC PROGRAMMING
		try {
			Connection conn = MySQLConnectionUtils.getConnection();
			if (conn != null) {
				System.out.println("I am connected with database");
			}
			// Creating the query
			String sql = "update asignup_tbl set name=?,email=?,gender=? where sid=?";

			// Creating prepared statement with query
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// Now Setting value inside place holders
			pstmt.setString(1, username);
			pstmt.setString(2, email);
			pstmt.setString(3, gender);
			pstmt.setInt(4, sid);
			// fire the query
			pstmt.executeUpdate();

		} catch (Exception e) {
			// It will print the problem in details
			e.printStackTrace();
		}
	}

	public static void save(String username, String email, String gender) {
		// JDBC PROGRAMMING
		try {
			Connection conn = MySQLConnectionUtils.getConnection();
			if (conn != null) {
				System.out.println("I am connected with database");
			}
			// Creating the query
			String sql = "insert into asignup_tbl (name,email,gender) values(?,?,?)";

			// Creating prepared statement with query
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// Now Setting value inside place holders
			pstmt.setString(1, username);
			pstmt.setString(2, email);
			pstmt.setString(3, gender);

			// fire the query
			pstmt.executeUpdate();

		} catch (Exception e) {
			// It will print the problem in details
			e.printStackTrace();
		}
	}

	public static void delete(int sid) {
		try {
			Connection conn = MySQLConnectionUtils.getConnection();
			if (conn != null) {
				System.out.println("I am connected with database");
			}
			// Creating the query
			String sql = "delete  from  asignup_tbl where sid = ?";
			// Creating prepared statement with query
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sid);
			pstmt.executeUpdate();

		} catch (Exception e) {
			// It will print the problem in details
			e.printStackTrace();
		}
	}
}
