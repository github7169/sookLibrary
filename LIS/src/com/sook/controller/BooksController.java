package com.sook.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sook.DAO.BooksDAO;
import com.sook.DTO.BooksDTO;
import com.sook.DTO.UsersDTO;
import com.sook.util.AbstractController;
import com.sook.util.StatusUtil;

public class BooksController extends AbstractController{
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = getURI(request);
		System.out.println("uri : "+uri);
		if ("/books/getBooks".equals(uri)) {
			selectBook(request, response);
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
		
		BooksDTO booksDTO = new BooksDTO();
		BooksDAO booksDAO = new BooksDAO();			
		System.out.println("rentedBook was called");
		
		String userId = request.getParameter("userId");
		
		ArrayList<BooksDTO> getRentedBookList = new ArrayList<BooksDTO>();
				
		getRentedBookList = booksDAO.getRentedList(booksDTO, userId);
		request.setAttribute("GETRENTEDBOOKLIST", getRentedBookList );
						
		RequestDispatcher view = request.getRequestDispatcher("/getrentedlist.jsp");  
		view.forward(request, response);  
	}

	private void selectBook(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
			BooksDTO booksDTO = new BooksDTO();
			BooksDAO booksDAO = new BooksDAO();			
			System.out.println("selectBook was called");
			
			String keyword = request.getParameter("keyword");
			String[] bookfilter = request.getParameterValues("book_filter");
			
			ArrayList<BooksDTO> getBookList =new ArrayList<BooksDTO>();
			
			int option = 0;
			
			switch (bookfilter[0]) {
			case "registnum":
				booksDTO.setBookRegistNumber(keyword);
				option = StatusUtil.bookOptionRegistNumber;
				break;
			case "title":
				booksDTO.setBookTitle(keyword);
				option = StatusUtil.bookOptionTitle;
				break;
			case "author":
				booksDTO.setBookAuthor(keyword);
				option = StatusUtil.bookOptionAuthor;
				break;
			case "publisher":
				booksDTO.setBookPublisher(keyword);
				option = StatusUtil.bookOptionPublisher;
				break;
			case "ISBN":
				booksDTO.setBookISBN(keyword);
				option = StatusUtil.bookOptionISBN;
				break;
			default:
				break;
			}
			getBookList = booksDAO.selectBook(booksDTO, option, keyword);
			request.setAttribute("GETBOOKLIST", getBookList );
	
	        RequestDispatcher rd = request.getRequestDispatcher("/getbooks.jsp");  
	        rd.forward(request, response);  
	}
}
