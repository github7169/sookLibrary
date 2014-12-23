package com.sook.DAO;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sook.DTO.BooksDTO;
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
		booksDTO.setBookTitle("TEST");
		booksDTO.setBookAuthor("test");
		booksDTO.setBookPublisher("publisher");
		booksDTO.setBookPublicationYear(2015);
		booksDTO.setBookISBN("10101");
		booksDTO.setBookApplicationMark(11111);
		booksDTO.setBookCategory(StatusUtil.bookCategoryOthers);
		booksDTO.setBookPrice(20000);
		booksDTO.setBookCount(0);
		booksDTO.setBookStatus(6);
	}
	
	@AfterClass
	public static void tearDownClass() throws Exception {
		// Code executed after the last test method
		
	}
	
	@Test
	public void testInsertBook() throws SQLException {
		assertEquals(booksDAO.insertBook(booksDTO), 1);
		booksDAO.deleteBook("1000000000");
	}
	
	@Test
	public void testUpdateBook() throws SQLException {
		booksDTO.setBookPrice(1000000);
		assertEquals(booksDAO.updateBook(booksDTO), 1);
	}
/*	
	@Test
	public void testDeleteBookSuccess() throws SQLException{
		String registnum = "1000000000";
		assertEquals(booksDAO.deleteBook(registnum), 1);
		
	}
	
	@Test
	public void testDeleteBookFailure() throws SQLException{
		String registnum = "0";
		assertEquals(booksDAO.deleteBook(registnum), 0);
		
	}
	*/
	 @Test 
	 public void testSelectBookByRegistNum() {
		 //등록번호로 검색
		 assertEquals(booksDAO.selectBook(booksDTO, 14, "12345").get(0).getBookTitle(),"Software");
	 }
	 
	 @Test 
	 public void testSelectBookByAuthor() {
		 //책 저자로 검색;
		 assertEquals(booksDAO.selectBook(booksDTO, 16, "John").get(0).getBookTitle(),"Javascript");
	 }
	 
	 @Test 
	 public void testgetRentedList() {
		 assertEquals(booksDAO.getRentedList(booksDTO, "1211514").get(0).getBookTitle(),"Adobe Photoshop");
	 }
}