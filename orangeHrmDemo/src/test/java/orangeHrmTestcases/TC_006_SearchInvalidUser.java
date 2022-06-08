package orangeHrmTestcases;

import org.testng.annotations.Test;

import orangeHrmPageObjects.DashBoardPageObject;
import orangeHrmPageObjects.LoginPageObject;
import orangeHrmPageObjects.SystemUsersPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TC_006_SearchInvalidUser extends BaseClass {
	
	 
  @Test
  @Parameters("crossbrowser")
  public void OrangeHrm_TC006_invalidUser(String crossbrowser) {
	 
	  testcase = extentreport.createTest("TC_006_invalidUser").assignDevice(crossbrowser).assignCategory("functional");
	  
	  LoginPageObject login = new LoginPageObject(driver); 
	  DashBoardPageObject obj = new DashBoardPageObject(driver); 
	  SystemUsersPageObject user = new SystemUsersPageObject(driver);
	  
	  // get url
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  //calling the loginmtd 
	  login.loginMtd("Admin", "admin123");
	  //verifying the login is successful
	 Assert.assertTrue(login.isLoginSuccess());
	 //click on admintab
	 obj.clickAdmin(); 
	 //click on user management tab
	 obj.clickUserManagement();
	 //click on user
	 obj.clickUser();
	  
	 //verify the current page is system user page
		Assert.assertTrue(user.verifyUserPage());

			user.enterUserName("Sofia");
			user.enterStatus("Enabled");
			user.clickSearch();
		//verify no record msg is displayed
			Assert.assertTrue(user.noRecord());
			
	}
 

	/*
	 * @AfterClass public void afterClass() { driver.quit(); }
	 */

}
