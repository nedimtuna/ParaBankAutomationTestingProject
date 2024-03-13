package TestBase;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class base {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader fr1;

	@BeforeTest

	public void setUp() throws IOException {
		if (driver == null) {
			FileReader fr = new FileReader(System.getProperty("user.dir")+ ("\\src\\test\\resources\\configFiles\\properties"));
			prop.load(fr);
			
			FileReader fr1 = new FileReader(System.getProperty("user.dir")+("\\src\\test\\resources\\configFiles\\locators"));
			loc.load(fr1);
		}

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.get(prop.getProperty("testUrl"));
		driver.manage().window().maximize();
		

	}
	
	 public static void login(String username, String password) {
			driver.findElement(By.name(loc.getProperty("usernamePath"))).sendKeys("john");
			driver.findElement(By.name(loc.getProperty("passwordPath"))).sendKeys("demo");
			driver.findElement(By.xpath(loc.getProperty("loginButtonPath"))).click();
	    }
	 
	 public static void newAcc() {
		 driver.findElement(By.xpath(loc.getProperty("newAccPath"))).click();
			WebElement ddown = driver.findElement(By.id(loc.getProperty("typeOfAccPath")));
			Select select = new Select(ddown);
			select.selectByValue("1");
			driver.findElement(By.xpath(loc.getProperty("newAccButtonPath"))).click();
	 }

	@AfterTest
	public void tearDown() {

		driver.close();

	}

}
