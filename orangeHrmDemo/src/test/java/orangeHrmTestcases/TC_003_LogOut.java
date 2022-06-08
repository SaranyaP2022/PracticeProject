package orangeHrmTestcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

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
	@Parameters("crossbrowser")
	public void OrangeHrm_TC003_logOut(String crossbrowser) throws InterruptedException  {
		
		testcase = extentreport.createTest("TC_003_LogOut").assignDevice(crossbrowser).assignCategory("functional");
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
		testcase.log(Status.PASS, "The logout was successful");
	}

	/*
	 * @AfterClass public void afterClass() { driver.quit(); }
	 */

}
