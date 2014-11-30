package com.sook.util;

public class StatusUtil {
	//유저 포지션이 사서인 경우 userStatus가 필요없기 때문에
	//userState
	public final static int userStatusLibrarian = 0;
	public final static int userStatusRestricted = 1;
	public final static int userStatusOverdue = 2;
	public final static int userStatusAvailable = 3;

	//bookState
	public final static int bookStatusAvailable = 4;
	public final static int bookStatusBorrowed = 5;
	
	//bookCategory
	public final static int bookCategoryLiterature = 6;
	public final static int bookCategoryHistory = 7;
	public final static int bookCategoryIT = 8;
	public final static int bookCategoryArt = 9;
	public final static int bookCategorySocial = 10;
	public final static int bookCategoryOthers = 11;
	
}
