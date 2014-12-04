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

import com.sook.DAO.UsersDAO;
import com.sook.DTO.UsersDTO;
import com.sook.util.AbstractController;
import com.sook.util.StatusUtil;

public class UsersController extends AbstractController{
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = getURI(request);
		System.out.println(uri);
		if ("/users/insertUser".equals(uri)) {
			insertUser(request, response);
		}else if("/users/login".equals(uri)){
			login(request, response);
		}else if("/users/getUsers".equals(uri)){
			getUsers(request,response);
		} else if("/users/updateUser".equals(uri)){
			updateUser(request,response);
		} else if("/users/checkUserId".equals(uri)){
			checkUserId(request, response);
		}
	}

	private void checkUserId(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//학생인지 사서인지 및 중복확인 등..
		response.sendRedirect(request.getContextPath() + "/getbooks.jsp");
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
			String userId = request.getParameter("userId");
			String userPwd = request.getParameter("userPwd");
			
			HttpSession session = request.getSession();
			
			UsersDTO user = new UsersDTO();
			user.setUserId(userId);
			user.setUserPwd(userPwd);
			user.setUserName("사서_관리자");
			user.setUserPostion(StatusUtil.userPositionLibrarian);
			
			session.setAttribute("USER", user);
			response.sendRedirect(request.getContextPath() + "/getbooks.jsp");
	}

	private void updateUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		UsersDTO user = (UsersDTO)session.getAttribute("USER");
		String userId = user.getUserId();
		
		UsersDTO usersDTO = new UsersDTO();
		UsersDAO usersDAO = new UsersDAO();
		
		String userPhoneNum = request.getParameter("userPhoneNum");
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		String userDepartment = request.getParameter("userDepartment");
		
		System.out.println("userName"+userName);
		System.out.println("userDepartment"+userDepartment);
		System.out.println("userName"+userName);
		
		usersDTO.setUserPhoneNum(userPhoneNum);
		usersDTO.setUserDepartment(userDepartment);
		usersDTO.setUserName(userName);
		usersDTO.setUserPwd(userPwd);
		usersDTO.setUserId(userId);
		
		try {
			int result = usersDAO.updateUser(usersDTO);
			if(result==0)
				System.out.println("user update error");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.sendRedirect(request.getContextPath()+"/updateuser.jsp");
	}

	private void getUsers(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		UsersDAO usersDAO = new UsersDAO();
		UsersDTO usersDTO = new UsersDTO();
		System.out.println("getUsers was called");
		String keyword = request.getParameter("keyword");
		String[] selectedOption = request.getParameterValues("userFilter");
		int option = 0;
		//연체 유저 리스트를 여기에 넣는다.
		ArrayList<UsersDTO> userlist = new ArrayList<UsersDTO>();

		switch (selectedOption[0]) {
		case "userId":
			usersDTO.setUserId(keyword);
			option = StatusUtil.userOptionId;
			break;
		case "userName":
			usersDTO.setUserName(keyword);
			option = StatusUtil.userOptionName;
		default:
			break;
		}
		
		userlist = usersDAO.getUsers(usersDTO, option, keyword);
		
		request.setAttribute("USERLIST", userlist);
		
		RequestDispatcher view = request.getRequestDispatcher("/getusers.jsp");  
        view.forward(request, response);
	}

	private void insertUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UsersDTO usersDTO = new UsersDTO();
		UsersDAO usersDAO= new UsersDAO();
		
		//가입 처리 후 책 찾기 화면으로 이동
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String userDepartment = request.getParameter("userDepartment");
		String userPhoneNum = request.getParameter("userPhoneNum");
	
		
		usersDTO.setUserDepartment(userDepartment);
		usersDTO.setUserId(userId);
		usersDTO.setUserName(userName);
		usersDTO.setUserPhoneNum(userPhoneNum);
		usersDTO.setUserPwd(userPwd);
		//임시로 사서로 가입
		usersDTO.setUserPostion(StatusUtil.userPositionLibrarian);
		
		int result=usersDAO.insertUser(usersDTO);
		if(result==0)
			System.out.println("유저 생성에 실패하였습니다.");
		
		session.setAttribute("USER", usersDTO);
		response.sendRedirect(request.getContextPath() + "/getbooks.jsp");
	}
}
