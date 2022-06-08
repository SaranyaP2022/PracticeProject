package orangeHrmTestcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

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
  @Parameters("crossbrowser")
  public void OrangeHrm_TC001_login(String crossbrowser)  {
	  
	  testcase = extentreport.createTest("TC_001_ValidLogin").assignDevice(crossbrowser).assignCategory("functional");
	  
	  LoginPageObject login = new LoginPageObject(driver);
	  
	// get url
			driver.get("https://opensource-demo.orangehrmlive.com/");
		//calling the login mtd	
			login.loginMtd("Admin", "admin123");
			
	//verifying login is successful		
			Assert.assertTrue(login.isLoginSuccess());
			testcase.log(Status.PASS, "The login was successful");
  }
 
  
	
  }


