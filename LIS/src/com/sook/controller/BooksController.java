package com.sook.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sook.DAO.BooksDAO;
import com.sook.DTO.BooksDTO;
import com.sook.DTO.UsersDTO;
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
		BooksDTO booksDTO = new BooksDTO();
		BooksDAO booksDAO = new BooksDAO();
		
		int bookRegistNumber = Integer.parseInt(request.getParameter("bookRegistNumber")); 
		String bookTitle = request.getParameter("bookTitle");
		String bookAuthor = request.getParameter("bookAuthor");  	 
		String bookPublisher = request.getParameter("bookPublisher");
		int bookPublicationYear = Integer.parseInt(request.getParameter("bookPublicationYear")); 
		int bookISBN = Integer.parseInt(request.getParameter("bookISBN"));
		int bookApplicationMark = Integer.parseInt(request.getParameter("bookApplicationMark"));
		int bookCategory = Integer.parseInt(request.getParameter("bookCategory"));
		int bookPrice = Integer.parseInt(request.getParameter("bookPrice"));
		
		booksDTO.setBookApplicationMark(bookApplicationMark);
		booksDTO.setBookAuthor(bookAuthor);
		booksDTO.setBookCategory(bookCategory);
		booksDTO.setBookISBN(bookISBN);
		booksDTO.setBookPrice(bookPrice);
		booksDTO.setBookPublicationYear(bookPublicationYear);
		booksDTO.setBookPublisher(bookPublisher);
		booksDTO.setBookRegistNumber(bookRegistNumber);
		booksDTO.setBookTitle(bookTitle);
		
		try {
			booksDAO.insertBook(booksDTO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
