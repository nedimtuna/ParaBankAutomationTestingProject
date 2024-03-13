package TestCases;

import org.testng.annotations.Test;

import TestBase.base;

public class LoginWithValidCredentials extends base{
	@Test
	public static void Login() {
		
	login("username", "password");
		
	}
	
	
	
	

}
