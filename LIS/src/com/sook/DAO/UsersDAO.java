package com.sook.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sook.DTO.UsersDTO;
import com.sook.util.JDBCUtil;
import com.sook.util.StatusUtil;

public class UsersDAO {
	
	private final String INSERT_USER = "INSERT INTO users(userId, userPwd, userName, userDepartment, userPhoneNum, userPosition) VALUE(?,?,?,?,?,?)";
	private final String UPDATE_USER = "UPDATE users SET userPwd = ?, userName = ?, userDepartment = ?, userPhoneNum =? where userId=?";
	// 학생의 아이디 혹은 이름으로 검색
	String userSearchCondition = null;
	
	private final String GET_USERS_BY_ID = "SELECT * FROM users WHERE userId LIKE ?";
	private final String GET_USERS_BY_NAME ="SELECT * FROM users WHERE userName LIKE ?";
	
//	private final String GET_USERS_BY_STATUS ="SElECT * FROM users WHERE userStatus LIKE?";
	
	private final String GET_Restricted_LIST ="SELECT * FROM users WHERE userStatus LIKE ?";
	private final String GET_Available_LIST ="SELECT * FROM users WHERE userStatus LIKE ?";
	private final String GET_Overdue_LIST ="SELECT * FROM users WHERE userStatus LIKE ?";
	

	//private final String GET_USER_LIST = "SELECT * FROM users WHERE bookRentedBy = ?;";


	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public int insertUser(UsersDTO usersDTO) {
		conn = JDBCUtil.getInstance().getConnection();
		int result = 0;
		try {
			pstmt = conn.prepareStatement(INSERT_USER);
			
			int idx = 0;
			pstmt.setString(++idx, usersDTO.getUserId());
			pstmt.setString(++idx, usersDTO.getUserPwd());
			pstmt.setString(++idx, usersDTO.getUserName());
			pstmt.setString(++idx, usersDTO.getUserDepartment());
			pstmt.setString(++idx, usersDTO.getUserPhoneNum());
			pstmt.setString(++idx, usersDTO.getUserPostion());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	//- 계정관리 (updateuser.jsp)
	public int updateUser(UsersDTO usersDTO) throws SQLException {
		
		int result = 0;
		conn = JDBCUtil.getInstance().getConnection();
		
		try{
			pstmt = conn.prepareStatement(UPDATE_USER);
			int idx = 0;
			pstmt.setString(++idx, usersDTO.getUserPwd());
			pstmt.setString(++idx, usersDTO.getUserName());
			pstmt.setString(++idx, usersDTO.getUserDepartment());
			pstmt.setString(++idx, usersDTO.getUserPhoneNum());
			pstmt.setString(++idx, usersDTO.getUserId());

			result=pstmt.executeUpdate();
		}

		catch (SQLException e) {
			// TODO auto-generated catch block
			e.printStackTrace();
		}

		finally {
			pstmt.close();
		}
		return result;
	}

	// (Librarian) - 회원 조회 (getusers.jsp)
	public ArrayList<UsersDTO> getUsers(UsersDTO usersDTO, int option,
			String keyword) {
		System.out.println("UserDAO : getUsers was called");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = JDBCUtil.getInstance().getConnection();
		ArrayList<UsersDTO> list = new ArrayList<UsersDTO>();
		try {
			switch (option) {
			case StatusUtil.userOptionId:
				System.out.println("호출되었습니다.keyword값 : " +keyword);
				pstmt = conn.prepareStatement(GET_USERS_BY_ID);
				userSearchCondition= "userId";
				break;
			case StatusUtil.userOptionName:
				userSearchCondition="userName";
				pstmt = conn.prepareStatement(GET_USERS_BY_NAME);
				break;
				/*
			case StatusUtil.userStatusRestricted:
				System.out.println("호출되었습니다.keyword값 : " +keyword);
				userSearchCondition="restricted";
				pstmt = conn.prepareStatement(GET_Restricted_LIST);
				break;
			case StatusUtil.userStatusAvailable:
				userSearchCondition="available";
				pstmt = conn.prepareStatement(GET_Available_LIST);
				break;
			case StatusUtil.userStatusOverdue:
				userSearchCondition="overdue";
				pstmt = conn.prepareStatement(GET_Overdue_LIST);
				break; */
	
			default:
				break;
			}
		
			
			
			pstmt.setString(1, "%"+keyword+"%");

			rs = pstmt.executeQuery();
			while (rs.next()) {

				UsersDTO users = new UsersDTO();

				users.setUserId(rs.getString("userId"));
				users.setUserName(rs.getString("userName"));
				users.setUserPhoneNum(rs.getString("userPhoneNum"));
				users.setUserDepartment(rs.getString("userDepartment"));
				users.setUserStatus(rs.getInt("userStatus"));

				list.add(users);
			}
			//test
			for(int i=0; i<list.size() ; i++){
				System.out.println("성공");
				System.out.println( "name "+ list.get(i).getUserName()+ "  department  "+list.get(i).getUserDepartment());
				System.out.println( "phone "+ list.get(i).getUserPhoneNum()+ "  status  "+list.get(i).getUserStatus());
			}	


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
	
	
	public ArrayList<UsersDTO> getUsers_by_status(UsersDTO usersDTO, int option,
			int stat) {
		System.out.println("UserDAO : getUsers_by_status was called");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = JDBCUtil.getInstance().getConnection();
		ArrayList<UsersDTO> list = new ArrayList<UsersDTO>();
		try {
			switch (option) {
			
			case StatusUtil.userStatusRestricted:
				System.out.println("호출되었습니다.keyword값 : " +stat);
				
				userSearchCondition="restricted";
				pstmt = conn.prepareStatement(GET_Restricted_LIST);
				break;
			case StatusUtil.userStatusAvailable:
				System.out.println("호출되었습니다.keyword값 : " +stat);
				userSearchCondition="available";
				pstmt = conn.prepareStatement(GET_Available_LIST);
				break;
			case StatusUtil.userStatusOverdue:
				System.out.println("호출되었습니다.keyword값 : " +stat);
				userSearchCondition="overdue";
				pstmt = conn.prepareStatement(GET_Overdue_LIST);
				break;
	
			default:
				break;
			}
			
			
			pstmt.setString(1, "%"+stat+"%");
			


			rs = pstmt.executeQuery();
			while (rs.next()) {

				UsersDTO users = new UsersDTO();

				users.setUserId(rs.getString("userId"));
				users.setUserName(rs.getString("userName"));
				users.setUserPhoneNum(rs.getString("userPhoneNum"));
				users.setUserDepartment(rs.getString("userDepartment"));
				users.setUserStatus(rs.getInt("userStatus"));

				list.add(users);
			}
			//test
			for(int i=0; i<list.size() ; i++){
				System.out.println("성공");
				System.out.println( "name "+ list.get(i).getUserName()+ "  department  "+list.get(i).getUserDepartment());
				System.out.println( "phone "+ list.get(i).getUserPhoneNum()+ "  status  "+list.get(i).getUserStatus());
			}	


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}


}
