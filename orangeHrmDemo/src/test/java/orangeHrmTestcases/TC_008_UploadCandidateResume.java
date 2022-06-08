package orangeHrmTestcases;


import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import orangeHrmPageObjects.AddCandidatePageObject;
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

public class TC_008_UploadCandidateResume extends BaseClass{
 
	
  @Test
  @Parameters("crossbrowser")
  public void TC_009_candidateResumeUpload(String crossbrowser) {
	  
	  testcase = extentreport.createTest("TC_008_UploadCandidateResume").assignDevice(crossbrowser).assignCategory("functional");
	  LoginPageObject login = new LoginPageObject(driver); 
	  DashBoardPageObject obj = new DashBoardPageObject(driver); 
	  CandidatesPageObject candidate = new CandidatesPageObject(driver);
	  AddCandidatePageObject addCandidate = new AddCandidatePageObject(driver);
	
	  // get url
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  //calling the loginmtd 
	  login.loginMtd("Admin", "admin123");
	 Assert.assertTrue(login.isLoginSuccess());
	 
	 //click on recruitment module
	 obj.clickRecruitmentModule();
	 Assert.assertTrue(candidate.verifyURL());
	 //under candidates tab click on add button
	 candidate.clickAddButton();
	// verifying the current page is 'Add candidate page'
	 String expectedText = "Add Candidate";
	 Assert.assertEquals(addCandidate.verifyAddcandidatePage(), expectedText);
	  
	 //upload the file in the resume field
	 
	 addCandidate.uploadCandidateResume("C:\\Users\\HP User\\Desktop\\SampleResume.pdf"); 
	 
	 testcase.log(Status.PASS, "The candidate resume was uploaded successfully");
	 }

		/*
		 * @AfterClass public void afterClass() { driver.close(); }
		 */
}
