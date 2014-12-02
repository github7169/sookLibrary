package com.sook.DAO;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;

import com.sook.DTO.UsersDTO;
import com.sook.util.JDBCUtil;
import com.sook.util.StatusUtil;

public class UsersDAO {
	private final String INSERT_USER = "INSERT INTO user VALUE(?,?,?,?,?)";
	private final String UPDATE_USER = "UPDATE user SET(?,?,?) where id=?";
//	private final String GET_USERS = "selete number,name,major,phone,status,money,books FROM user WHERE status ?";
//	private final String GET_USERS = "selete number,name,major,phone,status,money,books FROM user WHERE id ?";
//	private final String GET_USERS = "selete number,name,major,phone,status,money,books FROM user WHERE name ?";
	
	private com.mysql.jdbc.Connection conn =null;
	private PreparedStatement pstmt=null;
	private RewultSet rs =null;
	
	private UsersDTO user = new UsersDTO();
	
	//-회원가입 (joinuser.jsp - managemember.jsp)
	public int insertUser(UsersDTO usersDTO) {
		try{
			conn=JDBCUtil.getInstance().getConnection();
			pstmt=conn.prepareStatement(INSERT_USER);

			int idx=0;
			pstmt.setString(++idx,dto.getUser_id());
			pstmt.setString(++idx,dto.getUser_pwd());
			pstmt.setString(++idx,dto.getUser_name());
			pstmt.setString(++idx,dto.getUser_major());
			pstmt.setString(++idx,dto.getUser_phone());
		
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
	public int updateUser(UsersDTO usersDTO) throws SQLException {
		try{
			conn=JDBCUtil.getInstace().getConnection();
			pstmt = conn.prepareStatemen(UPDATE_USER);
			
			int idx = 0;
			pstmt.setString(++idx,userDTO.getUser_id());
			pstmt.setString(++idx,userDTO.getUser_pw());
			pstmt.setString(++idx,userDTO.getUser_name());
			pstmt.setString(++idx,userDTO.getUser_major());
			
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
	public ArrayList<UsersDTO> getUsers (UsersDTO usersDTO){
		
	}
}
