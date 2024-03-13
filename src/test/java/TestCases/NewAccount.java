package TestCases;

import org.testng.annotations.Test;

import TestBase.base;

public class NewAccount extends base {
	@Test
	public static void NewAccountOpening() {
		login ("username", "password");
		newAcc();
	}

}
