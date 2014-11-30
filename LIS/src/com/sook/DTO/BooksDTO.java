package com.sook.DTO;

import java.io.Serializable;
import java.util.Date;

public class BooksDTO implements Serializable{
	private int bookRegistNumber; 		/* 등록번호 */
	private String bookTitle;
	private String bookAuthor;  	 	/* 책 저자 */
	private String bookPublisher;  	/* 출판사 */
	private int bookPublicationYear; 		/* 출판년도 */
	private int bookISBN;
	private int bookApplicationMark; 	/* 청구기호 */
	private int bookCategory; 	/* 도서분류 ( literature, history, IT, art, social, others ) */
	private int bookPrice;
	private int bookCount;		/* 빌린 권수 ( 남은 권수는 7-Count ) */
	private int bookStatus;		/* 도서상태 (available | borrowed) */
	private Date bookRentDate;			/* 대출일자  (YYMMDD) */
	private Date bookReturnDate; 		/* 반납일자  (YYMMDD) */
	private UsersDTO bookRentedBy;
	public int getBookRegistNumber() {
		return bookRegistNumber;
	}
	public void setBookRegistNumber(int bookRegistNumber) {
		this.bookRegistNumber = bookRegistNumber;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookPublisher() {
		return bookPublisher;
	}
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	public int getBookPublicationYear() {
		return bookPublicationYear;
	}
	public void setBookPublicationYear(int bookPublicationYear) {
		this.bookPublicationYear = bookPublicationYear;
	}
	public int getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(int bookISBN) {
		this.bookISBN = bookISBN;
	}
	public int getBookApplicationMark() {
		return bookApplicationMark;
	}
	public void setBookApplicationMark(int bookApplicationMark) {
		this.bookApplicationMark = bookApplicationMark;
	}
	public int getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(int bookCategory) {
		this.bookCategory = bookCategory;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public int getBookCount() {
		return bookCount;
	}
	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}
	public int getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(int bookStatus) {
		this.bookStatus = bookStatus;
	}
	public Date getBookRentDate() {
		return bookRentDate;
	}
	public void setBookRentDate(Date bookRentDate) {
		this.bookRentDate = bookRentDate;
	}
	public Date getBookReturnDate() {
		return bookReturnDate;
	}
	public void setBookReturnDate(Date bookReturnDate) {
		this.bookReturnDate = bookReturnDate;
	}
	public UsersDTO getBookRentedBy() {
		return bookRentedBy;
	}
	public void setBookRentedBy(UsersDTO bookRentedBy) {
		this.bookRentedBy = bookRentedBy;
	}
	
}
