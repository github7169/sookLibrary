package com.sook.DAO;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sook.DTO.BooksDTO;
import com.sook.DTO.UsersDTO;
import com.sook.util.StatusUtil;

public class UsersDAOTest {
   private static UsersDAO usersDAO;
   private static UsersDTO usersDTO;
   private static BooksDAO booksDAO;
   private static BooksDTO booksDTO;
   @BeforeClass
   
   
   public static void setUpClass() throws Exception {
      // Code executed before the first test method
      usersDAO = new UsersDAO();
      usersDTO = new UsersDTO();
      booksDTO = new BooksDTO();
      
      usersDTO.setUserId("1211453");
      usersDTO.setUserName("jisu");
      usersDTO.setUserPhoneNum("01092454120");
      usersDTO.setUserPosition("student");
      usersDTO.setUserDepartment("multimediascience");
      usersDTO.setUserPwd("12345");
      usersDTO.setUserStatus(StatusUtil.userStatusOverdue);
   }


   @Test
   public void testInsertUser() {
      assertEquals(usersDAO.insertUser(usersDTO), 1);
   }

   @Test
   public void testUpdateUser() {
	   usersDTO.setUserName("limjisu");
      assertEquals(usersDAO.updateUser(usersDTO), 1);
   }
   
   
   @Test
   public void testLoginUser() {
      assertEquals(usersDAO.login(usersDTO), 1);
   }
 

   @Test
   public void testGetUsers(){
   		assertEquals(usersDAO.getUsers(usersDTO,20,"jisu").get(0).getUserName(),"jisu");
   }
   
   @Test
   public void testGetUsersByStatus(){
	   assertEquals(usersDAO.getUsersByStatus(usersDTO,5,5).get(0).getUserName(),"jisu");
   }
   
   
}


   


