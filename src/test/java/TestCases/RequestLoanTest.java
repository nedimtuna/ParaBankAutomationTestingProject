package TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import TestBase.base;

public class RequestLoanTest extends base {
	@Test
	public static void RequestLoan(){
		
		
		login("username","password");
		newAcc();
		driver.findElement(By.xpath(loc.getProperty("requestLoanPath"))).click();
		driver.findElement(By.id(loc.getProperty("loanAmountPath"))).sendKeys("100");
		driver.findElement(By.id(loc.getProperty("downPayPath"))).sendKeys("10");
		driver.findElement(By.xpath(loc.getProperty("applyNowButtonPath"))).click();
		
		
	}

}
