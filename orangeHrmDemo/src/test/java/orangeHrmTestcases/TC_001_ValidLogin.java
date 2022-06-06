package orangeHrmTestcases;

import org.testng.annotations.Test;

import orangeHrmPageObjects.LoginPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TC_001_ValidLogin extends BaseClass {
	
  @Test
  public void OrangeHrm_TC001_login()  {
	  
	  LoginPageObject login = new LoginPageObject(driver);
	  
	// get url
			driver.get("https://opensource-demo.orangehrmlive.com/");
		//calling the login mtd	
			login.loginMtd("Admin", "admin123");
			
	//verifying login is successful		
			Assert.assertTrue(login.isLoginSuccess());
  }
 
	/*
	 * @AfterClass public void afterClass() { // close the browser driver.quit(); }
	 */
  }


