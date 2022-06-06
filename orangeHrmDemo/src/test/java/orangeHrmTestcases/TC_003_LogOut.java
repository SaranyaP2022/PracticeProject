package orangeHrmTestcases;

import org.testng.annotations.Test;

import orangeHrmPageObjects.HomePageObject;
import orangeHrmPageObjects.LoginPageObject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TC_003_LogOut extends BaseClass{

	@Test
	public void OrangeHrm_TC003_logOut() throws InterruptedException  {
		LoginPageObject login = new LoginPageObject(driver);
		HomePageObject homepage = new HomePageObject(driver);
		// get url
		driver.get("https://opensource-demo.orangehrmlive.com/");

		// calling the login mtd
		login.loginMtd("Admin", "admin123");
		// verifying login is successful
		Assert.assertTrue(login.isLoginSuccess());

		// calling mtd for logging out
		homepage.welcomelink();
		homepage.logOutLink();
		// verifying logout was successful
		Assert.assertTrue(login.isLogoutSuccessful());
	}

	/*
	 * @AfterClass public void afterClass() { driver.quit(); }
	 */

}
