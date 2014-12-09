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
	private final String GET_USERS_BY_NAME = "SELECT * FROM users WHERE userName LIKE ?";

	// private final String GET_USERS_BY_STATUS
	// ="SElECT * FROM users WHERE userStatus LIKE?";

	private final String GET_Restricted_LIST = "SELECT * FROM users WHERE userStatus LIKE ?";
	private final String GET_Available_LIST = "SELECT * FROM users WHERE userStatus LIKE ?";
	private final String GET_Overdue_LIST = "SELECT * FROM users WHERE userStatus LIKE ?";

	private final String CHECK_USER_ID = "SELECT * FROM sookmyung WHERE userId = ?";
	private final String LOGIN = "SELECT * FROM users WHERE userId = ?";
	// private final String GET_Restricted_LIST
	// ="SELECT * FROM users WHERE userStatus LIKE ?";
	// private final String GET_Available_LIST
	// ="SELECT * FROM users WHERE userStatus LIKE ?";
	// private final String GET_Overdue_LIST
	// ="SELECT * FROM users WHERE userStatus LIKE ?";

	// private final String GET_USER_LIST =
	// "SELECT * FROM users WHERE bookRentedBy = ?;";

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public int insertUser(UsersDTO usersDTO) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
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
			pstmt.setString(++idx, usersDTO.getUserPosition());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// - 계정관리 (updateuser.jsp)
	public int updateUser(UsersDTO usersDTO) throws SQLException {

		int result = 0;
		conn = JDBCUtil.getInstance().getConnection();

		try {
			pstmt = conn.prepareStatement(UPDATE_USER);
			int idx = 0;
			pstmt.setString(++idx, usersDTO.getUserPwd());
			pstmt.setString(++idx, usersDTO.getUserName());
			pstmt.setString(++idx, usersDTO.getUserDepartment());
			pstmt.setString(++idx, usersDTO.getUserPhoneNum());
			pstmt.setString(++idx, usersDTO.getUserId());

			result = pstmt.executeUpdate();
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
				System.out.println("호출되었습니다.keyword값 : " + keyword);
				pstmt = conn.prepareStatement(GET_USERS_BY_ID);
				userSearchCondition = "userId";
				break;
			case StatusUtil.userOptionName:
				userSearchCondition = "userName";
				pstmt = conn.prepareStatement(GET_USERS_BY_NAME);
				break;
			case StatusUtil.userStatusRestricted:
				System.out.println("호출되었습니다.keyword값 : " + keyword);
				userSearchCondition = "restricted";
				pstmt = conn.prepareStatement(GET_Restricted_LIST);
				break;
			case StatusUtil.userStatusAvailable:
				userSearchCondition = "available";
				pstmt = conn.prepareStatement(GET_Available_LIST);
				break;
			case StatusUtil.userStatusOverdue:
				userSearchCondition = "overdue";
				pstmt = conn.prepareStatement(GET_Overdue_LIST);
				break;

			default:
				break;
			}

			pstmt.setString(1, "%" + keyword + "%");

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
			// test
			for (int i = 0; i < list.size(); i++) {
				System.out.println("성공");
				System.out.println("name " + list.get(i).getUserName()
						+ "  department  " + list.get(i).getUserDepartment());
				System.out.println("phone " + list.get(i).getUserPhoneNum()
						+ "  status  " + list.get(i).getUserStatus());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<UsersDTO> getUsers_by_status(UsersDTO usersDTO,
			int option, int stat) {
		System.out.println("UserDAO : getUsers was called");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = JDBCUtil.getInstance().getConnection();
		ArrayList<UsersDTO> list = new ArrayList<UsersDTO>();
		try {
			switch (option) {

			case StatusUtil.userStatusRestricted:
				System.out.println("호출되었습니다.keyword값 : " + stat);

				userSearchCondition = "restricted";
				pstmt = conn.prepareStatement(GET_Restricted_LIST);
				break;
			case StatusUtil.userStatusAvailable:
				userSearchCondition = "available";
				pstmt = conn.prepareStatement(GET_Available_LIST);
				break;
			case StatusUtil.userStatusOverdue:
				userSearchCondition = "overdue";
				pstmt = conn.prepareStatement(GET_Overdue_LIST);
				break;

			default:
				break;
			}

			System.out.println(stat);
			// pstmt = conn.prepareStatement(GET_USERS);

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
			// test
			for (int i = 0; i < list.size(); i++) {
				System.out.println("성공");
				System.out.println("name " + list.get(i).getUserName()
						+ "  department  " + list.get(i).getUserDepartment());
				System.out.println("phone " + list.get(i).getUserPhoneNum()
						+ "  status  " + list.get(i).getUserStatus());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public UsersDTO checkUserId(UsersDTO usersDTO) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = JDBCUtil.getInstance().getConnection();

		try {
			pstmt = conn.prepareStatement(CHECK_USER_ID);

			pstmt.setString(1, usersDTO.getUserId());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				usersDTO.setUserId(rs.getString("userId"));
				usersDTO.setUserPosition(rs.getString("userPosition"));
			} else {
				System.out.println("존재하지 않는 학번, 교번입니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pstmt.close();
			rs.close();
		}

		return usersDTO;
	}

	public UsersDTO login(UsersDTO usersDTO) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = JDBCUtil.getInstance().getConnection();

		try {
			pstmt = conn.prepareStatement(LOGIN);

			pstmt.setString(1, usersDTO.getUserId());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				String userPwd = rs.getString("userPwd");
				if (userPwd.equals(usersDTO.getUserPwd())) {
					usersDTO.setUserDepartment(rs.getString("userDepartment"));
					usersDTO.setUserId(rs.getString("userId"));
					usersDTO.setUserName(rs.getString("userName"));
					usersDTO.setUserPhoneNum(rs.getString("userPhoneNum"));
					usersDTO.setUserPosition(rs.getString("userPosition"));
				} else {
					System.out.println("비밀번호가 틀립니다.");
				}
			} else {
				System.out.println("존재하지 않는 아이디 입니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rs.close();
			pstmt.close();
		}
		return usersDTO;
	}

}
