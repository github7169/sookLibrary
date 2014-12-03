package com.sook.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sook.DTO.UsersDTO;
import com.sook.util.AbstractController;
import com.sook.util.StatusUtil;

public class UsersController extends AbstractController{
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = getURI(request);
		if ("/users/insertUser".equals(uri)) {
			insertUser(request, response);
		}else if("/users/login".equals(uri)){
			login(request, response);
		}else if("/users/getUsers".equals(uri)){
			getUsers(request,response);
		} else if("/users/updateUser".equals(uri)){
			updateUser(request,response);
		} else if("users/checkUserId".equals(uri)){
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
		response.sendRedirect(request.getContextPath()+"/updateuser.jsp");
	}

	private void getUsers(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		//연체 유저 리스트를 여기에 넣는다.
		ArrayList<UsersDTO> userlist = new ArrayList<UsersDTO>();
		
		request.setAttribute("USERLIST", userlist);
		
		RequestDispatcher view = request.getRequestDispatcher("/getusers.jsp");  
        view.forward(request, response);
	}

	private void insertUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//가입 처리 후 책 찾기 화면으로 이동
		response.sendRedirect(request.getContextPath()+"/getbooks.jsp");
	}
}
