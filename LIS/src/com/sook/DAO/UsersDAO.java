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
		//학생의 아이디 혹은 이름으로 검색 
	private final String GET_USERS_ID = "SELECT * "
			+ "FROM users WHERE userId LIKE ?";
	
	private final String GET_USERS_NAME = "SELECT * "
			+ "FROM users WHERE userName LIKE ?";
	
	//학생의 상태에 따른 (대출가능,연체중,대출제한) 검색
	private final String GET_USERS_STATUS = "SELECT * "
			+ "FROM users WHERE userStatus LIKE ?";
	
	private final String GET_LENTED_LIST = "SELECT * FROM books "
			+ "WHERE bookRentedBy = ?;";

	private java.sql.Connection conn =null;
	private java.sql.PreparedStatement pstmt=null;
	private ResultSet rs =null;
	
	private UsersDTO user = new UsersDTO();
	//짜증짜증 ㅎㅎ 
	//-회원가입 (joinuser.jsp - managemember.jsp)
	public void insertUser(UsersDTO usersDTO) throws SQLException {
		
		try{
			conn=JDBCUtil.getInstance().getConnection();
			pstmt=conn.prepareStatement(INSERT_USER);

			int idx=0;
			pstmt.setString(++idx,usersDTO.getUserId());
			pstmt.setString(++idx,usersDTO.getUserPwd());
			pstmt.setString(++idx,usersDTO.getUserName());
			pstmt.setString(++idx,usersDTO.getUserDepartment());
			pstmt.setString(++idx,usersDTO.getUserPhoneNum());
		
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
			
			pstmt.executeUpdate();
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
	public ArrayList<UsersDTO> getUsers(UsersDTO usersDTO, int option, String keyword){
		
		
		
		//option = 20;
		//keyword = "jinhee";	
		
		conn = JDBCUtil.getInstance().getConnection();
		ArrayList<UsersDTO> list = new ArrayList<UsersDTO>();
		
		try {
			System.out.println( "나와랏" );
			
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
				
			for(int i=0; i<list.size() ; i++){
				System.out.println("루프를 돕니다.");
				System.out.println("유저네임!"+ list.get(i).getUserName() + ", 유저 아이디!"+ list.get(i).getUserId() );
				System.out.println("유저 학과!"+ list.get(i).getUserDepartment() + ", 유저 폰넘버! " + list.get(i).getUserPhoneNum());
				System.out.println("-----------------------------------------------------------");
			int status;
				status=list.get(i).getUserStatus();
				if (status==4){
					System.out.println("연체중입니다.   " + list.get(i).getUserStatus());
				}
			}
			

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	return list;
}

}
