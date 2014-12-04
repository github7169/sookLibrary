package com.sook.DAO;
import com.mysql.jdbc.Connection;

import java.sql.DriverManager;

import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.sook.DTO.BooksDTO;
import com.sook.DTO.UsersDTO;
import com.sook.util.JDBCUtil;
import com.sook.util.StatusUtil;


public class UsersDAO {
	private final String INSERT_USER = "INSERT INTO users VALUE(?,?,?,?,?);";
	private final String UPDATE_USER = "UPDATE user SET(?,?,?) where id=?;";
	
	//아이디 혹은 이름으로 검색
	private final String GET_USERS_ID = "SELECT * "
			+ "FROM users WHERE userId LIKE ?";
	
	private final String GET_USERS_NAME = "SELECT * "
			+ "FROM users WHERE userName LIKE ?";
	
	//학생의 상태에 따른 (대출가능,연체중,대출제한) 검색
	private final String GET_USERS_STATUS = "SELECT * "
			+ "FROM users WHERE userStatus LIKE ?";
	

	private java.sql.Connection conn =null;
	private java.sql.PreparedStatement pstmt=null;
	private ResultSet rs =null;
	private UsersDTO user = new UsersDTO();

	//-회원가입 (joinuser.jsp - managemember.jsp)
	public int insertUser(UsersDTO usersDTO) throws SQLException {
		
		int result = 0;
		conn = JDBCUtil.getInstance().getConnection();
		
		try{
			conn=JDBCUtil.getInstance().getConnection();
			pstmt=conn.prepareStatement(INSERT_USER);

			int idx=0;
			pstmt.setString(++idx,usersDTO.getUserId());
			pstmt.setString(++idx,usersDTO.getUserPwd());
			pstmt.setString(++idx,usersDTO.getUserName());
			pstmt.setString(++idx,usersDTO.getUserDepartment());
			pstmt.setString(++idx,usersDTO.getUserPhoneNum());
		
			rs = pstmt.getGeneratedKeys();
		}
		
		catch (SQLException e){
			//TODO auto-generated catch block 
			
			e.printStackTrace();
		}
		
		finally{
			pstmt.close();
		}
		return result;
	}
	

	//- 계정관리 (updateuser.jsp)
	public int updateUser(UsersDTO usersDTO) throws SQLException {
		int result = 0;
		conn = JDBCUtil.getInstance().getConnection();
		
		try{
			conn=JDBCUtil.getInstance().getConnection();
			pstmt = conn.prepareStatement(UPDATE_USER);
			
			int idx = 0;
			pstmt.setString(++idx,usersDTO.getUserId());
			pstmt.setString(++idx,usersDTO.getUserPwd());
			pstmt.setString(++idx,usersDTO.getUserName());
			pstmt.setString(++idx,usersDTO.getUserDepartment());
			
			pstmt.executeUpdate();
		}
		
		catch(SQLException e){
			//TODO auto-generated catch block 
			e.printStackTrace();
		}
		
		finally{
			pstmt.close();
		}
		return result;
	}


	//(Librarian) - 회원 조회 (getusers.jsp)
	public ArrayList<UsersDTO> getUsers(UsersDTO usersDTO, int option, String keyword){
		
		
		conn = JDBCUtil.getInstance().getConnection();
		ArrayList<UsersDTO> list = new ArrayList<UsersDTO>();
		
		try {
			
			if ( option == StatusUtil.userOptionId ){				
				pstmt = conn.prepareStatement(GET_USERS_ID);

			} else if ( option == StatusUtil.userOptionName ){				
				pstmt = conn.prepareStatement(GET_USERS_ID);
	
			
			//회원 상태에 따른 검색인데 약간 애매함........ ****
				
			} else if ( option == StatusUtil.userStatusRestricted ){				
				pstmt = conn.prepareStatement(GET_USERS_STATUS);
				
			} else if ( option == StatusUtil.userStatusAvailable ){				
			pstmt = conn.prepareStatement(GET_USERS_STATUS);
			}
			
			else if ( option == StatusUtil.userStatusOverdue ){				
			pstmt = conn.prepareStatement(GET_USERS_STATUS);
			}
			
			pstmt.setString(1, "%" + keyword + "%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
			
				UsersDTO users = new UsersDTO();
				
				users.setUserId(rs.getString("userId"));
				users.setUserName(rs.getString("userName"));
				users.setUserPhoneNum(rs.getString("userPhoneNum"));
				users.setUserDepartment(rs.getString("userDepartment"));
				users.setUserStatus(rs.getInt("userStatus"));
				
				list.add(users);
			}
			
		}catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return list;
}

}
