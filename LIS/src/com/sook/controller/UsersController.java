package com.sook.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import com.sook.DAO.BooksDAO;

import com.sook.DAO.UsersDAO;
import com.sook.DTO.BooksDTO;
import com.sook.DTO.UsersDTO;
import com.sook.util.AbstractController;
import com.sook.util.StatusUtil;

public class UsersController extends AbstractController {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = getURI(request);

		if ("/users/insertUser".equals(uri)) {
			insertUser(request, response);
		} else if ("/users/login".equals(uri)) {
			login(request, response);
		} else if ("/users/getUsers".equals(uri)) {
			getUsers(request, response);
		} else if ("/users/updateUser".equals(uri)) {
			updateUser(request, response);
		} else if ("/users/checkUserId".equals(uri)) {
			checkUserId(request, response);
		} else if ("/users/logout".equals(uri)) {
			logout(request, response);
		} else if ("/users/deleteUser".equals(uri)) {
			deleteuser(request, response);
		}
	}

	private void deleteuser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		UsersDTO usersDTO = new UsersDTO();
		UsersDAO usersDAO = new UsersDAO();

		HttpSession session = request.getSession();

		usersDTO = (UsersDTO) session.getAttribute("USER");

		int result = usersDAO.deleteUser(usersDTO);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=UTF-8");
		JSONObject jsonObj = new JSONObject();

		try {
			if (result != 0) {
				session.invalidate();
				jsonObj.put("result", "success");
			} else {
				jsonObj.put("result", "fail");
			}
			out.print(jsonObj);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.flush();

	}

	private void logout(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.invalidate();

		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	private void checkUserId(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		UsersDTO usersDTO = new UsersDTO();
		UsersDAO usersDAO = new UsersDAO();

		String userId = request.getParameter("userId");
		
		usersDTO.setUserId(userId);
		
		PrintWriter out;
		JSONObject jsonObj;
		out = response.getWriter();
		response.setContentType("application/json; charset=UTF-8");
		jsonObj = new JSONObject();
		
		try {
			usersDTO = usersDAO.checkUserId(usersDTO);
			if (usersDTO.getUserId() == null) {
				jsonObj.put("result", "error");
			} else {
				jsonObj.put("result", "ok");
				jsonObj.put("position", usersDTO.getUserPosition());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(jsonObj);
		out.flush();
		// RequestDispatcher view = request.getRequestDispatcher("/regist.jsp");
		// view.forward(request, response);

	}

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		UsersDAO usersDAO = new UsersDAO();
		UsersDTO usersDTO = new UsersDTO();

		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");

		usersDTO.setUserId(userId);
		usersDTO.setUserPwd(userPwd);

		usersDTO = usersDAO.login(usersDTO);

		HttpSession session = request.getSession();
		session.setAttribute("USER", usersDTO);
		response.sendRedirect(request.getContextPath() + "/getbooks.jsp");
	}

	private void updateUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();

		UsersDTO user = (UsersDTO) session.getAttribute("USER");
		String userId = user.getUserId();

		UsersDTO usersDTO = new UsersDTO();
		UsersDAO usersDAO = new UsersDAO();

		String userPhoneNum = request.getParameter("userPhoneNum");
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		String userDepartment = request.getParameter("userDepartment");

		usersDTO.set(userPhoneNum, userDepartment, userName, userPwd, userId);

		int result = usersDAO.updateUser(usersDTO);
		if (result == 0)
			System.out.println("user update error");
		session.setAttribute("USER", usersDTO);
		response.sendRedirect(request.getContextPath() + "/updateuser.jsp");
	}

	private void getUsers(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		UsersDAO usersDAO = new UsersDAO();
		UsersDTO usersDTO = new UsersDTO();
		System.out.println("getUsers was called + getUsers_by_status");
		String keyword = request.getParameter("keyword");
		
		String[] selectedOption = request.getParameterValues("userFilter");
		String[] selectedOptionStatus = request.getParameterValues("statusFilter");

		int option = 0;
		// 연체 유저 리스트를 여기에 넣는다.
		ArrayList<UsersDTO> userlist = new ArrayList<UsersDTO>();
		
		BooksDTO booksDTO = new BooksDTO();
		//UsersDAO usersDAO = new UsersDAO();			
		System.out.println("getOverdueDay was called");
		
		ArrayList<BooksDTO> getOverdueDay = new ArrayList<BooksDTO>();
				
		
		
		
		switch (selectedOption[0]) {
		case "userId":
			System.out.println("userId was selected");
			usersDTO.setUserId(keyword);
			option = StatusUtil.userOptionId;
			userlist = usersDAO.getUsers(usersDTO, option, keyword);
			getOverdueDay = usersDAO.getOverdueDay(booksDTO, option, keyword);
			break;
		case "userName":
			usersDTO.setUserName(keyword);
			option = StatusUtil.userOptionName;
			userlist = usersDAO.getUsers(usersDTO, option, keyword);
			getOverdueDay = usersDAO.getOverdueDay(booksDTO, option, keyword);
			break;
			
		default:
			break;
		}
	
		switch (selectedOptionStatus[0]) {
		case "overdue":
			usersDTO.setUserStatus(4);
			option = StatusUtil.userStatusOverdue;
			userlist = usersDAO.getUsersByStatus(usersDTO, option, 4);
			getOverdueDay = usersDAO.getOverdueDayByStatus(booksDTO, option);
			break;

		case "restricted":
			usersDTO.setUserStatus(3);
			option = StatusUtil.userStatusRestricted;
			userlist = usersDAO.getUsersByStatus(usersDTO, option, 3);
			getOverdueDay = usersDAO.getOverdueDayByStatus(booksDTO, option);
			break;

		case "available":
			usersDTO.setUserStatus(5);
			option = StatusUtil.userStatusAvailable;
			userlist = usersDAO.getUsersByStatus(usersDTO, option, 5);
			getOverdueDay = usersDAO.getOverdueDayByStatus(booksDTO, option);
			break;

		default:
			break;
		}

		request.setAttribute("USERLIST", userlist);
		request.setAttribute("GETOVERDUEDAY", getOverdueDay );
		
		if(userlist.size()==0){
			request.setAttribute("notFound", "notFound");
		}
		
		
		RequestDispatcher view = request.getRequestDispatcher("/getusers.jsp");
		view.forward(request, response);
	}

	private void insertUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UsersDTO usersDTO = new UsersDTO();
		UsersDAO usersDAO = new UsersDAO();

		// 가입 처리 후 책 찾기 화면으로 이동
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String userDepartment = request.getParameter("userDepartment");
		String userPhoneNum = request.getParameter("userPhoneNum");
		String userPosition = request.getParameter("userPosition");

		usersDTO.setUserDepartment(userDepartment);
		usersDTO.setUserId(userId);
		usersDTO.setUserName(userName);
		usersDTO.setUserPhoneNum(userPhoneNum);
		usersDTO.setUserPwd(userPwd);
		// 임시로 사서로 가입
		usersDTO.setUserPosition(userPosition);

		int result = usersDAO.insertUser(usersDTO);
		if (result == 0)
			System.out.println("유저 생성에 실패하였습니다.");

		session.setAttribute("USER", usersDTO);
		response.sendRedirect(request.getContextPath() + "/getbooks.jsp");
	}
	

}
