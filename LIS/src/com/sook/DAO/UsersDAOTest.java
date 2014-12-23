package com.sook.DAO;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sook.DTO.UsersDTO;
import com.sook.util.StatusUtil;

public class UsersDAOTest {
   private static UsersDAO usersDAO;
   private static UsersDTO usersDTO;
   @BeforeClass
   public static void setUpClass() throws Exception {
      // Code executed before the first test method
      
   }

   @Test
   public void testInsertUser() {
	   usersDAO = new UsersDAO();
	      usersDTO = new UsersDTO();
	      
	      usersDTO.setUserId("100000");
	      usersDTO.setUserName("jisu");
	      usersDTO.setUserPhoneNum("01092454120");
	      usersDTO.setUserPosition("student");
	      usersDTO.setUserDepartment("multimediascience");
	      usersDTO.setUserPwd("12345");
	      usersDTO.setUserStatus(StatusUtil.userStatusAvailable);
      assertEquals(usersDAO.insertUser(usersDTO), 1);
   }

   @Test
   public void testUpdateUser() {
	   usersDAO = new UsersDAO();
	      usersDTO = new UsersDTO();
	      
	      usersDTO.setUserId("100000");
	      usersDTO.setUserName("jisu");
	      usersDTO.setUserPhoneNum("01092454120");
	      usersDTO.setUserPosition("student");
	      usersDTO.setUserDepartment("multimediascience");
	      usersDTO.setUserPwd("12345");
	      usersDTO.setUserStatus(StatusUtil.userStatusAvailable);
      assertEquals(usersDAO.updateUser(usersDTO), 1);
   }
   
   @Test
   public void testLoginUser() {
      assertEquals(usersDAO.login(usersDTO), 1);
   }
   


}