package com.sook.DAO;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sook.DTO.BooksDTO;
import com.sook.DTO.UsersDTO;
import com.sook.util.StatusUtil;

public class BooksDAOTest {
	private static BooksDAO booksDAO;
	private static BooksDTO booksDTO;

	@BeforeClass
	public static void setUpClass() throws Exception {
		// Code executed before the first test method
		booksDAO = new BooksDAO();
		booksDTO = new BooksDTO();
		
		booksDTO.setBookRegistNumber("1000000000");
		booksDTO.setBookTitle("TestTitle");
		booksDTO.setBookAuthor("test");
		booksDTO.setBookPublisher("publisher");
		booksDTO.setBookPublicationYear(2015);
		booksDTO.setBookISBN("10101");
		booksDTO.setBookApplicationMark(11111);
		booksDTO.setBookCategory(StatusUtil.bookCategoryOthers);
		booksDTO.setBookPrice(20000);
	}
	
	@AfterClass
	public static void tearDownClass() throws Exception {
		// Code executed before the first test method
	}
	/*
	@Test
	public void testInsertBook() throws SQLException {
		assertEquals(booksDAO.insertBook(booksDTO), 1);
	}

	@Test
	public void testUpdateBook() throws SQLException {
		booksDTO.setBookAuthor("updateTitle");
		assertEquals(booksDAO.updateBook(booksDTO), 1);
	}
 */
	
	 @Test 
	 public void testSelectBook() {
		 assertEquals(booksDAO.selectBook(booksDTO, 14, "10").get(0).getBookTitle(),"TestTitle");
	 }
	 
	 @Test 
	 public void testgetRentedList() {
		 assertEquals(booksDAO.getRentedList(booksDTO, "1211453").get(0).getBookTitle(),"소프트웨어 공학");
	 }

}