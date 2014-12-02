package com.sook.DAO;
import com.mysql.jdbc.Connection;

import java.sql.DriverManager;

import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.sook.DTO.UsersDTO;
import com.sook.util.JDBCUtil;
import com.sook.util.StatusUtil;

public class UsersDAO {
	private final String INSERT_USER = "INSERT INTO user VALUE(?,?,?,?,?)";
	private final String UPDATE_USER = "UPDATE user SET(?,?,?) where id=?";
//	private final String GET_USERS = "SELECT number,name,major,phone,status,money,books FROM user WHERE status ?";
//	private final String GET_USERS = "SELECT number,name,major,phone,status,money,books FROM user WHERE id ?";
//	private final String GET_USERS = "SELECT number,name,major,phone,status,money,books FROM user WHERE name ?";
	
	private java.sql.Connection conn =null;
	private java.sql.PreparedStatement pstmt=null;
	private ResultSet rs =null;
	
	private UsersDTO user = new UsersDTO();
	
	//-회원가입 (joinuser.jsp - managemember.jsp)
	public void insertUser(UsersDTO usersDTO) throws SQLException {
		try{
			conn=JDBCUtil.getInstance().getConnection();
			pstmt=conn.prepareStatement(INSERT_USER);

			int idx=0;
			pstmt.setString(++idx,user.getUserId());
			pstmt.setString(++idx,user.getUserPwd());
			pstmt.setString(++idx,user.getUserName());
			pstmt.setString(++idx,user.getUserDepartment());
			pstmt.setString(++idx,user.getUserPhoneNum());
		
		}
		
		catch (SQLException e){
			//TODO auto-generated catch block 
			e.printStackTrace();
		}
		
		finally{
			pstmt.close();
		}
	}
	

	//- 계정관리 (updateuser.jsp)
	public void updateUser(UsersDTO usersDTO) throws SQLException {
		try{
			conn=JDBCUtil.getInstance().getConnection();
			pstmt = conn.prepareStatement(UPDATE_USER);
			
			int idx = 0;
			pstmt.setString(++idx,usersDTO.getUserId());
			pstmt.setString(++idx,usersDTO.getUserPwd());
			pstmt.setString(++idx,usersDTO.getUserName());
			pstmt.setString(++idx,usersDTO.getUserDepartment());
			
			//pstmt.executeUpdate();
		}
		
		catch(SQLException e){
			//TODO auto-generated catch block 
			e.printStackTrace();
		}
		
		finally{
			pstmt.close();
		}
	}


	//(Librarian) - 회원 조회 (getusers.jsp)
	public ArrayList<UsersDTO> getUsers(UsersDTO usersDTO){
		
		
		return null;
		
	}
}
