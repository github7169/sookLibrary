package com.sook.DTO;

import java.io.Serializable;

public class UsersDTO implements Serializable{
	private String userId; 
	private String userPwd;
	private String userName; /* 이름	*/
	private String userDepartment;/*소속 부서(학과) */
	private String userPhoneNum;	/* 연락처 (‘-’구분 없이 11자리 이내의  숫자) */
	private int userPostion; 			/*- 신분 (student | librarian) */	
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
	public int getUserPostion() {
		return userPostion;
	}
	public void setUserPostion(int userPostion) {
		this.userPostion = userPostion;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}	
	

}
