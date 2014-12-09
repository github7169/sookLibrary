package com.sook.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sook.DTO.BooksDTO;
import com.sook.DTO.UsersDTO;
import com.sook.util.JDBCUtil;
import com.sook.util.StatusUtil;

public class BooksDAO {

	// 검색 쿼리문
	/*
	 * 검색 옵션 : 등록번호, 서명, 저자 , 출판사, ISBN 검색 결과 _ 사서 : 등록번호, 서명, 저자, 출판사, ISBN,
	 * 청구기호, 이용자, 대출상태, 반납예정일 상세 결과 _ 사서 : 등록번호, 서명, 저자, 출판사, 출판 년도, ISBN, 청구기호,
	 * 분류, 가격, 대출횟수, 이용자, 대출상태, 대출날짜, 반납예정일 검색 결과 _ 학생 : 등록번호, 서명, 저자, 출판사,
	 * 청구기호, 대출상태, 대출일, 반납예정일 상세 결과 _ 학생 : 등록번호, 서명, 저자, 출판사, 출판 년도, ISBN, 청구기호,
	 * 분류, 대출상태, 대출날짜, 반납예정일
	 */

	private final String GET_BOOKS_REGISTNUMBER = "SELECT * FROM books WHERE bookRegistNumber LIKE ?";
	private final String GET_BOOKS_TITLE = "SELECT * FROM books WHERE bookTitle LIKE ?";
	private final String GET_BOOKS_AUTHOR = "SELECT * FROM books WHERE bookAuthor LIKE ?";
	private final String GET_BOOKS_PUBLISHER = "SELECT * FROM books WHERE bookPublisher LIKE ?";
	private final String GET_BOOKS_ISBN = "SELECT * FROM books WHERE bookISBN LIKE ?";

	private final String GET_LENTED_LIST = "SELECT * FROM books WHERE bookRentedBy = ?;";

	private final String INSERT_BOOK = "INSERT INTO books(bookRegistNumber, bookTitle, bookAuthor, bookPublisher, "
			+ "bookPublicationYear, bookISBN, bookApplicationMark, bookCategory, bookPrice) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String DELETE_BOOK = "DELETE FROM books WHERE bookResgistNumber = ?";
	private final String UPDATE_BOOK = "UPDATE books SET bookRegistNumber=? bookTitle=? bookAuthor=? bookPublisher=?"
			+ "bookPublicationYear=? bookISBN=? bookApplivationMark=? bookCategory=? bookPrice=? WHERE bookRegistNumber=?";

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	Statement stmt = null;
	private ResultSet rs = null;

	public int insertBook(BooksDTO booksDTO) throws SQLException{ 
		int result = 0;
		conn = JDBCUtil.getInstance().getConnection();

		try {
			int idx = 0;
			pstmt=conn.prepareStatement(INSERT_BOOK, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(++idx, booksDTO.getBookRegistNumber());
			pstmt.setString(++idx, booksDTO.getBookTitle());
			pstmt.setString(++idx, booksDTO.getBookAuthor());
			pstmt.setString(++idx, booksDTO.getBookPublisher());
			pstmt.setInt(++idx, booksDTO.getBookPublicationYear());
			pstmt.setString(++idx, booksDTO.getBookISBN());
			pstmt.setInt(++idx, booksDTO.getBookApplicationMark());
			pstmt.setInt(++idx, booksDTO.getBookCategory());
			pstmt.setInt(++idx, booksDTO.getBookPrice());

			pstmt.executeUpdate();
				

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pstmt.close();
		}
		return result;
	}

	public int deleteBook(ArrayList<BooksDTO> list) throws SQLException {

		int i = 0;
		int result = 1;
		BooksDTO book = new BooksDTO();

		conn = JDBCUtil.getInstance().getConnection();
		// BooksDTO list를 받아와서 등록번호 키를 가지고 하나씩 delete query 수행

		while (i < list.size()) {

			book = list.get(i++);
			
			pstmt.setString(1, book.getBookRegistNumber());
			rs = pstmt.executeQuery();

		}

		if (!rs.first()) {
			System.out.println("등록번호" + book.getBookRegistNumber()
					+ "와 일치하는 삭제데이터 없음. 샂게 실패");
			result = 0;
		}

		pstmt.close();

		return result;
	}

	public int updateBook(BooksDTO booksDTO) throws SQLException {
		int result = 0;

		conn = JDBCUtil.getInstance().getConnection();

		// 이용자, 대출상태, 대출날짜, 반납예정일은 편집 불가능

		try {
			pstmt=conn.prepareStatement(UPDATE_BOOK, Statement.RETURN_GENERATED_KEYS);
		
			int idx=0;
			pstmt.setString(++idx, booksDTO.getBookRegistNumber());
			pstmt.setString(++idx, booksDTO.getBookTitle());
			pstmt.setString(++idx, booksDTO.getBookAuthor());
			pstmt.setString(++idx, booksDTO.getBookPublisher());
			pstmt.setInt(++idx, booksDTO.getBookPublicationYear());
			pstmt.setString(++idx, booksDTO.getBookISBN());
			pstmt.setInt(++idx, booksDTO.getBookApplicationMark());
			pstmt.setInt(++idx, booksDTO.getBookCategory());
			pstmt.setInt(++idx, booksDTO.getBookPrice());			
			pstmt.setString(++idx, booksDTO.getBookRegistNumber());

			rs = pstmt.getGeneratedKeys();
			while (rs.next()) {
				result = (int) rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pstmt.close();
		}

		return result;

	}

	public ArrayList<BooksDTO> selectBook(BooksDTO booksDTO, int option,
			String keyword) {

		option = 15;
		keyword = "자바";

		conn = JDBCUtil.getInstance().getConnection();
		// 결과 마인드맵 리스트를 담을 객체
		ArrayList<BooksDTO> list = new ArrayList<BooksDTO>();
		try {
			System.out.println("나와랏");

			if (option == StatusUtil.bookOptionRegistNumber) {
				pstmt = conn.prepareStatement(GET_BOOKS_REGISTNUMBER);

			} else if (option == StatusUtil.bookOptionTitle) {
				pstmt = conn.prepareStatement(GET_BOOKS_TITLE);

			} else if (option == StatusUtil.bookOptionAuthor) {
				pstmt = conn.prepareStatement(GET_BOOKS_AUTHOR);

			} else if (option == StatusUtil.bookOptionPublisher) {
				pstmt = conn.prepareStatement(GET_BOOKS_PUBLISHER);

			} else if (option == StatusUtil.bookOptionISBN) {
				pstmt = conn.prepareStatement(GET_BOOKS_ISBN);

			}
			
			System.out.println("키워드당"+keyword);
			pstmt.setString(1, "%" + keyword + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BooksDTO books = new BooksDTO();
				UsersDTO users = new UsersDTO();
				
				books.setBookRegistNumber(rs.getString("bookRegistNumber"));
				books.setBookTitle(rs.getString("bookTitle"));
				books.setBookAuthor(rs.getString("bookAuthor"));
				books.setBookPublisher(rs.getString("bookPublisher"));
				books.setBookPublicationYear(rs.getInt("bookPublicationYear"));
				books.setBookISBN(rs.getString("bookISBN"));
				books.setBookApplicationMark(rs.getInt("bookApplicationMark"));
				books.setBookCategory(rs.getInt("bookCategory"));
				books.setBookPrice(rs.getInt("bookPrice"));
				books.setBookCount(rs.getInt("bookCount"));

				users.setUserId(rs.getString("bookRentedBy"));
				books.setBookRentedBy(users);

				books.setBookStatus(rs.getInt("bookStatus"));
				books.setBookRentDate(rs.getDate("bookRentDate"));
				books.setBookReturnDate(rs.getDate("bookReturnDate"));

				list.add(books);
			}

			// test
			for (int i = 0; i < list.size(); i++) {
				System.out.println("list얌 " + list.get(i).getBookTitle() + ", "
						+ list.get(i).getBookRentedBy().getUserId());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

public ArrayList<BooksDTO> getRentedList (BooksDTO booksDTO, String userId) {
	
	conn = JDBCUtil.getInstance().getConnection();
	//결과 마인드맵 리스트를 담을 객체
	ArrayList<BooksDTO> list = new ArrayList<BooksDTO>();
	try {
			System.out.println( "나와랏2" );
			pstmt = conn.prepareStatement(GET_LENTED_LIST);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BooksDTO books = new BooksDTO();
				UsersDTO users = new UsersDTO();
				
				books.setBookRegistNumber(rs.getString("bookRegistNumber"));
				books.setBookTitle(rs.getString("bookTitle"));
				books.setBookAuthor(rs.getString("bookAuthor"));
				books.setBookPublisher(rs.getString("bookPublisher"));
				books.setBookPublicationYear(rs.getInt("bookPublicationYear"));
				books.setBookISBN(rs.getString("bookISBN"));
				books.setBookApplicationMark(rs.getInt("bookApplicationMark"));
				books.setBookCategory(rs.getInt("bookCategory"));
				books.setBookPrice(rs.getInt("bookPrice"));
				books.setBookCount(rs.getInt("bookCount"));

				users.setUserId(rs.getString("bookRentedBy"));
				books.setBookRentedBy(users);

				books.setBookStatus(rs.getInt("bookStatus"));
				books.setBookRentDate(rs.getDate("bookRentDate"));
				books.setBookReturnDate(rs.getDate("bookReturnDate"));

				list.add(books);
			}

			// test
			for (int i = 0; i < list.size(); i++) {
				System.out.println("내가 빌린 list얌 " + list.get(i).getBookTitle()
						+ ", " + list.get(i).getBookRentedBy().getUserId());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
}
