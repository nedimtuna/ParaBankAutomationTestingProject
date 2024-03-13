package TestCases;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import TestBase.base;

public class TransferFundsTest extends base {
	@Test
	public static void TransferFunds() throws NoSuchElementException {
		login("username", "password");
		newAcc();

		driver.findElement(By.xpath(loc.getProperty("transferFundsPath"))).click();
		driver.findElement(By.id(loc.getProperty("amountFieldPath"))).sendKeys(loc.getProperty("amountNo"));
		WebElement ddown = driver.findElement(By.id(loc.getProperty("fromAccPath")));
		Select select = new Select(ddown);
		select.selectByIndex(0);
		WebElement ddown1 = driver.findElement(By.id(loc.getProperty("toAccPath")));
		Select select1 = new Select(ddown1);
		select1.selectByIndex(0);

		driver.findElement(By.xpath(loc.getProperty("transferButtonPath"))).click();

	}
}
