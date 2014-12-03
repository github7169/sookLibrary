package com.sook.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sook.DTO.BooksDTO;
import com.sook.util.JDBCUtil;

public class BooksDAO {
	final String INSERT_BOOK="INSERT INTO books(bookRegistNumber, bookTitle, bookAuthor, bookPublisher, "
			+ "bookPublicationYear, bookISBN, bookApplicationMark, bookCategory, bookPrice) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	final String DELETE_BOOK="DELETE FROM books WHERE bookResgistNumber = ?";
	final String UPDATE_BOOK="UPDATE books SET bookRegistNumber=? bookTitle=? bookAuthor=? bookPublisher=?"
			+ "bookPublicationYear=? bookISBN=? bookApplivationMark=? bookCategory=? bookPrice=? WHERE bookRegistNumber=?";
	
	//final String SAVE_MINDMAP="UPDATE mindmaps SET mm_path = ? WHERE mm_id = ?";
	//stmt.executeUpdate("update Category set count ='" + rscount +"' where Subject ='" + newSubject +"';");
	//int rowNum = stmt.executeUpdate("delete from Broadcast where id ='" + id + "' and Title ='" + rowtitle + "';");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public int insertBook (BooksDTO booksDTO) throws SQLException{	// 등록번호, 서명, 저자, 출판사, 출판 년도, ISBN, 청구기호, 분류, 가격
		//if insertion fail -> return 0
		int result = 0;
		conn = JDBCUtil.getInstance().getConnection();
		
		try {
			pstmt=conn.prepareStatement(INSERT_BOOK, Statement.RETURN_GENERATED_KEYS);
			
			int idx=0;
			pstmt.setInt(++idx, booksDTO.getBookRegistNumber());
			pstmt.setString(++idx, booksDTO.getBookTitle());
			pstmt.setString(++idx, booksDTO.getBookAuthor());
			pstmt.setString(++idx, booksDTO.getBookPublisher());
			pstmt.setInt(++idx, booksDTO.getBookPublicationYear());
			pstmt.setInt(++idx, booksDTO.getBookISBN());
			pstmt.setInt(++idx, booksDTO.getBookApplicationMark());
			pstmt.setInt(++idx, booksDTO.getBookCategory());
			pstmt.setInt(++idx, booksDTO.getBookPrice());
			
			rs = pstmt.getGeneratedKeys();

			/*
			while(rs.next()){
				result = (int)rs.getInt(1);
			}*/
			
			if(!rs.next()){
				System.out.println("삽입 실패, 등록번호를 확인하세요.");
				//이부분은 리턴값 받을때 처리하나 !
			}
			else result = (int)rs.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pstmt.close();
		}
		
		
		return result;
	}

	
	public int deleteBook (ArrayList<BooksDTO> list) throws SQLException{
		
		int i=0;
		int result = 1;
		BooksDTO book = new BooksDTO();
		
		conn = JDBCUtil.getInstance().getConnection();
		// BooksDTO list를 받아와서 등록번호 키를 가지고 하나씩 delete query 수행
		
		while(i<list.size()) {
			
			book = list.get(i++);
			
			pstmt.setInt(1, book.getBookRegistNumber());
			rs = pstmt.executeQuery();
	
		}
		
		if(!rs.first()){
			System.out.println("등록번호"+book.getBookRegistNumber()+"와 일치하는 삭제데이터 없음. 샂게 실패");
			result = 0;
		}
		
		pstmt.close();
		
		return result;
	}
	
	public int updateBook (BooksDTO booksDTO) throws SQLException{
		int result=0;
		
		conn = JDBCUtil.getInstance().getConnection();
		
		//이용자, 대출상태, 대출날짜, 반납예정일은 편집 불가능
		
		try {
			pstmt=conn.prepareStatement(UPDATE_BOOK, Statement.RETURN_GENERATED_KEYS);
		
			int idx=0;
			pstmt.setInt(++idx, booksDTO.getBookRegistNumber());
			pstmt.setString(++idx, booksDTO.getBookTitle());
			pstmt.setString(++idx, booksDTO.getBookAuthor());
			pstmt.setString(++idx, booksDTO.getBookPublisher());
			pstmt.setInt(++idx, booksDTO.getBookPublicationYear());
			pstmt.setInt(++idx, booksDTO.getBookISBN());
			pstmt.setInt(++idx, booksDTO.getBookApplicationMark());
			pstmt.setInt(++idx, booksDTO.getBookCategory());
			pstmt.setInt(++idx, booksDTO.getBookPrice());
			
			pstmt.setInt(++idx, booksDTO.getBookRegistNumber());
			
			rs = pstmt.getGeneratedKeys();
			while(rs.next()){
				result = (int)rs.getInt(1);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pstmt.close();
		}
		
		return result;
		
	}
	
	private void ConnectDB(){

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sooklibrary", "root", "1108");
			
			if (conn == null)
				System.out.println("Cannot connect to DB...");
				//throw new Exception("Cannot connect to DB . . .<BR>");
			else	System.out.println("DB connection succeeded.");	
			stmt = conn.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void DisconnectDB(){
		
		try {
			stmt.close();
		} 
		catch (Exception ignored) {
		}
		try {
			conn.close();
		} 
		catch (Exception ignored) {
		}

	}
	
}
