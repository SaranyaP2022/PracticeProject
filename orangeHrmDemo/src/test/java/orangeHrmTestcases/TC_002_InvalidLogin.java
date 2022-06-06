package orangeHrmTestcases;

import org.testng.annotations.Test;

import orangeHrmPageObjects.LoginPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class TC_002_InvalidLogin extends BaseClass{

	@BeforeMethod
		public void beforeMethod( ) {
		
		LoginPageObject login = new LoginPageObject(driver);

		// get url
		driver.get("https://opensource-demo.orangehrmlive.com/");
		}

	@Test(dataProvider = "dp")
	public void OrangeHrm_TC002_InValidlogin(String username, String password, String expectedError){
		
		LoginPageObject login = new LoginPageObject(driver);
		
		// calling the login mtd
		login.loginMtd("username", "password");
		
		// verify the login fails
		Assert.assertEquals(login.actualError(), expectedError);
		
}

	@AfterMethod
	public void afterMethod() {
	driver.get(driver.getCurrentUrl());	
	}

	/*
	 * @AfterClass public void afterClass() { driver.quit(); }
	 */
	@DataProvider
	public Object[][] dp() {
		return new Object[][] { 
			new Object[] { "admin1",  "admin1234",  "Invalid credentials"},
			new Object[] { "ADMIN", "admin123","Invalid credentials" },
			new Object[] { "",  "admin123", "Username cannot be empty" },
			new Object[] { "Admin","", "Password cannot be empty", },
			};
	}
}
