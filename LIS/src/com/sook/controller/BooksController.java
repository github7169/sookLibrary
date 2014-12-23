package com.sook.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sook.DAO.BooksDAO;
import com.sook.DTO.BooksDTO;
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
			try {
				deleteBook(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if("/books/updateBook".equals(uri)){
			try {
				updateBook(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void updateBook(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, SQLException {
		// TODO Auto-generated method stub
		
		BooksDTO booksDTO = new BooksDTO();
		BooksDAO booksDAO = new BooksDAO();
		System.out.println("updateBook was called");
		
		//BooksDTO getBook =new BooksDTO();
		System.out.println(request.getParameter("bookRegistNumber"));
		System.out.println(request.getParameter("bookTitle"));
		System.out.println(request.getParameter("bookAuthor"));
		System.out.println(request.getParameter("bookPublisher"));
		System.out.println(Integer.parseInt(request.getParameter("bookPublicationYear")));
		System.out.println(request.getParameter("bookISBN"));
		System.out.println(Integer.parseInt(request.getParameter("bookApplicationMark")));
		System.out.println(request.getParameter("bookCategory"));
		System.out.println(request.getParameter("bookPrice"));
		
		
		
		booksDTO.setBookRegistNumber(request.getParameter("bookRegistNumber"));
		booksDTO.setBookTitle(request.getParameter("bookTitle"));
		booksDTO.setBookAuthor(request.getParameter("bookAuthor"));
		booksDTO.setBookPublisher(request.getParameter("bookPublisher"));
		booksDTO.setBookPublicationYear(Integer.parseInt(request.getParameter("bookPublicationYear")));
		booksDTO.setBookISBN(request.getParameter("bookISBN"));
		booksDTO.setBookApplicationMark(Integer.parseInt(request.getParameter("bookApplicationMark")));
		booksDTO.setBookCategory(Integer.parseInt(request.getParameter("bookCategory")));
		booksDTO.setBookPrice(Integer.parseInt(request.getParameter("bookPrice")));
	
		//수정 불가능한 항목들
		//booksDTO.setBookCount(Integer.parseInt(request.getParameter("bookCount")));
		//booksDTO.setBookStatus(Integer.parseInt(request.getParameter("bookStatus")));
		//booksDTO.setBookRentDate(request.getParameter("bookRentDate"));
		//booksDTO.setBookReturnDate(request.getParameter("bookReturnDate"));
		//booksDTO.setBookRentedBy(request.getParameter("bookRentedBy"));
		
		if( booksDAO.updateBook(booksDTO) != 1)
			System.out.println("failed to updateBook");
		
		request.setAttribute("GETBOOK", booksDTO);

       // RequestDispatcher rd = request.getRequestDispatcher("getbooks.jsp");  
        //rd.forward(request, response);  
        response.sendRedirect(request.getContextPath() + "/getbooks.jsp");
	}

	private void deleteBook(HttpServletRequest request,
			HttpServletResponse response) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("deleteBook was called");
		
		BooksDAO booksDAO = new BooksDAO();
		
		String registnum= request.getParameter("bookRegistNumber");
		
		//System.out.println(registnum);
		
		booksDAO.deleteBook(registnum);
			
		response.sendRedirect(request.getContextPath() + "/getbooks.jsp");
	}

	private void insertBook(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		BooksDTO booksDTO = new BooksDTO();
		BooksDAO booksDAO = new BooksDAO();
		
		String bookRegistNumber = request.getParameter("bookRegistNumber"); 
		String bookTitle = request.getParameter("bookTitle");
		String bookAuthor = request.getParameter("bookAuthor");  	 
		String bookPublisher = request.getParameter("bookPublisher");
		int bookPublicationYear = Integer.parseInt(request.getParameter("bookPublicationYear")); 
		String bookISBN = request.getParameter("bookISBN");
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

		response.sendRedirect(request.getContextPath() + "/books/getBooks?book_filter=registnum&keyword=");
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
		if(getRentedBookList.size()==0){
			request.setAttribute("notFound", "notFound");
		}
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

			if(getBookList.size()==0){
				request.setAttribute("notFound", "notFound");
			}
			request.setAttribute("GETBOOKLIST", getBookList );
	
	        RequestDispatcher rd = request.getRequestDispatcher("/getbooks.jsp");  
	        rd.forward(request, response);  
	}
}
