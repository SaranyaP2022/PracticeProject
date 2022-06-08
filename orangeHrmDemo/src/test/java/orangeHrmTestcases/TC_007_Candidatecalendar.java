package orangeHrmTestcases;

import org.testng.annotations.Test;

import orangeHrmPageObjects.CandidatesPageObject;
import orangeHrmPageObjects.DashBoardPageObject;
import orangeHrmPageObjects.LoginPageObject;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TC_007_Candidatecalendar extends BaseClass{
	
 @Test
 @Parameters("crossbrowser")
  public void TC_008_candidateCalendar(String crossbrowser) {
		
	 testcase = extentreport.createTest("TC_007_Candidatecalendar").assignDevice(crossbrowser).assignCategory("functional");
		LoginPageObject login = new LoginPageObject(driver); 
		  DashBoardPageObject obj = new DashBoardPageObject(driver); 
		  CandidatesPageObject candidate = new CandidatesPageObject(driver);
		// get url
		  driver.get("https://opensource-demo.orangehrmlive.com/");
		  //calling the loginmtd 
		  login.loginMtd("Admin", "admin123");
		  //verifying whether the login is successful
		 Assert.assertTrue(login.isLoginSuccess());
		 // click on recruitment module
		 obj.clickRecruitmentModule();
		 //verifying the current page is candidate page
		 Assert.assertTrue(candidate.verifyURL());
		//candidate.jobTitle("Network Administrator");
		//candidate.status(0);
		candidate.fromDateOfApplication("2022-04-05");
		candidate.toDateOfApplication();
		
	 }
  

		/*
		 * @AfterClass public void afterClass() { driver.close(); }
		 */

}
