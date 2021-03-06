package com.sook.DTO;

import java.io.Serializable;

public class UsersDTO implements Serializable{
	private String userId; 
	private String userPwd;
	private String userName; /* 이름	*/
	private String userDepartment;/*소속 부서(학과) */
	private String userPhoneNum;	/* 연락처 (‘-’구분 없이 11자리 이내의  숫자) */
	private String userPosition; 			/*- 신분 (student | librarian) */	
	private int userStatus; 	/* 이용자 상태 (available | overdue | restricted) */
	
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public String getUserPwd() {
		return userPwd;
	}
	
	
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	
	public String getUserName() {
		return userName;
	}
	
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public String getUserDepartment() {
		return userDepartment;
	}
	
	
	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}
	
	
	public String getUserPhoneNum() {
		return userPhoneNum;
	}
	
	
	public void setUserPhoneNum(String userPhoneNum) {
		this.userPhoneNum = userPhoneNum;
	}

	
	public String getUserPosition() {
		return userPosition;
	}
	
	
	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}
	
	
	public int getUserStatus() {
		return userStatus;
	}
	
	
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}	
	

	public void set(String userPhoneNum, String userDepartment, String userName, String userPwd, String userId){
		this.userPhoneNum = userPhoneNum;
		this.userDepartment = userDepartment;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userId = userId;
	}
}