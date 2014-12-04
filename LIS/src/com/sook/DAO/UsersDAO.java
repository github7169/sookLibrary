package com.sook.DAO;

import java.sql.DriverManager;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.sook.DTO.BooksDTO;
import com.sook.DTO.UsersDTO;
import com.sook.util.JDBCUtil;
import com.sook.util.StatusUtil;

public class UsersDAO {
	private final String INSERT_USER = "INSERT INTO users VALUE(?,?,?,?,?)";
	private final String UPDATE_USER = "UPDATE user SET(?,?,?) where id=?";
	// 학생의 아이디 혹은 이름으로 검색
	String userSearchCondition = null;
	private String GET_USERS = "SELECT * FROM users WHERE" + userSearchCondition
			+ " LIKE %?%";
	// 학생의 상태에 따른 (대출가능,연체중,대출제한) 검색
	private final String GET_USERS_STATUS = "SELECT * FROM users WHERE userStatus LIKE ?";

	private final String GET_LENTED_LIST = "SELECT * FROM books WHERE bookRentedBy = ?;";

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private UsersDTO user = new UsersDTO();

	// -회원가입 (joinuser.jsp - managemember.jsp)
	public void insertUser(UsersDTO usersDTO) throws SQLException {

		try {
			conn = JDBCUtil.getInstance().getConnection();
			pstmt = conn.prepareStatement(INSERT_USER);

			int idx = 0;
			pstmt.setString(++idx, usersDTO.getUserId());
			pstmt.setString(++idx, usersDTO.getUserPwd());
			pstmt.setString(++idx, usersDTO.getUserName());
			pstmt.setString(++idx, usersDTO.getUserDepartment());
			pstmt.setString(++idx, usersDTO.getUserPhoneNum());
			
			pstmt.executeUpdate();

		}

		catch (SQLException e) {
			// TODO auto-generated catch block
			e.printStackTrace();
		}

		finally {
			pstmt.close();
		}
	}

	// - 계정관리 (updateuser.jsp)
	public void updateUser(UsersDTO usersDTO) throws SQLException {
		try {
			conn = JDBCUtil.getInstance().getConnection();
			pstmt = conn.prepareStatement(UPDATE_USER);

			int idx = 0;
			pstmt.setString(++idx, usersDTO.getUserId());
			pstmt.setString(++idx, usersDTO.getUserPwd());
			pstmt.setString(++idx, usersDTO.getUserName());
			pstmt.setString(++idx, usersDTO.getUserDepartment());

			pstmt.executeUpdate();
		}

		catch (SQLException e) {
			// TODO auto-generated catch block
			e.printStackTrace();
		}

		finally {
			pstmt.close();
		}
	}

	// (Librarian) - 회원 조회 (getusers.jsp)
	public ArrayList<UsersDTO> getUsers(UsersDTO usersDTO, int option,
			String keyword) {
		// option = 20;
		// keyword = "jinhee";

		conn = JDBCUtil.getInstance().getConnection();
		ArrayList<UsersDTO> list = new ArrayList<UsersDTO>();

		try {
			switch (option) {
			case StatusUtil.userOptionId:
				userSearchCondition= "userId";
				break;
			case StatusUtil.userOptionName:
				userSearchCondition="userName";
				break;
			case StatusUtil.userStatusRestricted:
				userSearchCondition="userStatusRestricted";
				break;
			case StatusUtil.userStatusAvailable:
				userSearchCondition="userStatusAvailable";
				break;
			case StatusUtil.userStatusOverdue:
				userSearchCondition="userStatusOverdue";
				break;
			default:
				break;
			}
			pstmt = conn.prepareStatement(GET_USERS);
			pstmt.setString(1, keyword);

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

			for (int i = 0; i < list.size(); i++) {
				System.out.println("루프를 돕니다.");
				System.out.println("유저네임!" + list.get(i).getUserName()
						+ ", 유저 아이디!" + list.get(i).getUserId());
				System.out.println("유저 학과!" + list.get(i).getUserDepartment()
						+ ", 유저 폰넘버! " + list.get(i).getUserPhoneNum());
				System.out
						.println("-----------------------------------------------------------");
				int status;
				status = list.get(i).getUserStatus();
				if (status == 4) {
					System.out.println("연체중입니다.   "
							+ list.get(i).getUserStatus());
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
