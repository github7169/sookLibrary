package com.sook.DTO;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UsersDTOTest {
	private static UsersDTO usersDTO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		usersDTO = new UsersDTO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSet() {
		usersDTO.set("010", "multi", "yj", "1235", "yjyj");
		assertEquals(usersDTO.getUserPhoneNum(), "010");
	}

}
