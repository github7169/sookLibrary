package com.sook.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sook.DTO.BooksDTO;
import com.sook.util.AbstractController;

public class BooksController extends AbstractController{
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = getURI(request);
		System.out.println("uri : "+uri);
		if ("/books/getBooks".equals(uri)) {
			getBooks(request, response);
		} else if ("/books/getRentedList".equals(uri)) {
			getRentedList(request, response);
		} else if("/books/insertBook".equals(uri)) {
			insertBook(request, response);
		} else if("/books/deleteBook".equals(uri)) {
			deleteBook(request, response);
		} else if("/books/updateBook".equals(uri)){
			updateBook(request, response);
		}
	}

	private void updateBook(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.sendRedirect(request.getContextPath() + "/getbooks.jsp");
	}

	private void deleteBook(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.sendRedirect(request.getContextPath() + "/getbooks.jsp");
	}

	private void insertBook(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		response.sendRedirect(request.getContextPath() + "/getbooks.jsp");
	}

	private void getRentedList(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		//set rented book list at this arraylist variable
		ArrayList<BooksDTO> booklist = new ArrayList<BooksDTO>();
		
		request.setAttribute("BOOKLIST", booklist);
		
        RequestDispatcher view = request.getRequestDispatcher("/getrentedlist.jsp");  
        view.forward(request, response);  
	}

	private void getBooks(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		//set book list at this arraylist variable
		ArrayList<BooksDTO> booklist = new ArrayList<BooksDTO>();
				
		request.setAttribute("BOOKLIST", booklist);
		
		RequestDispatcher view = request.getRequestDispatcher("/getbooks.jsp");  
        view.forward(request, response);
	}
}
