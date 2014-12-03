
package com.sook.util;

public class StatusUtil {
	//유저 포지션이 사서인 경우 userStatus가 필요없기 때문에
	
	//userPosition
	public final static String userPositionLibrarian = "librarian";
	public final static String userPositionStudent = "student";
	
	//userState
	public final static int userStatusLibrarian = 2;
	public final static int userStatusRestricted = 3;
	public final static int userStatusOverdue = 4;
	public final static int userStatusAvailable = 5;

	//bookState
	public final static int bookStatusAvailable = 6;
	public final static int bookStatusBorrowed = 7;
	
	//bookCategory
	public final static int bookCategoryLiterature = 8;
	public final static int bookCategoryHistory = 9;
	public final static int bookCategoryIT = 10;
	public final static int bookCategoryArt = 11;
	public final static int bookCategorySocial = 12;
	public final static int bookCategoryOthers = 13;
	
	//bookSearchOption
	   public final static int bookOptionRegistNumber = 14;
	   public final static int bookOptionTitle = 15;
	   public final static int bookOptionAuthor = 16;
	   public final static int bookOptionPublisher = 17;
	   public final static int bookOptionISBN = 18;   
	
}
