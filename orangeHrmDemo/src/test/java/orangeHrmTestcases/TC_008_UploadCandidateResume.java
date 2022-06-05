package orangeHrmTestcases;


import org.testng.annotations.Test;
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

public class TC_008_UploadCandidateResume {
 
	WebDriver driver;
	
	@BeforeClass
	 @Parameters("crossbrowser")
	 public void beforeClass(String crossbrowser) {
		
		// launch browser
				if(crossbrowser.equals("chrome")) {
					System.setProperty("webdriver.chrome.driver","./drivers\\chromedriver.exe");  
					driver = new ChromeDriver();
					}else if (crossbrowser.equals("firefox")) {
						System.setProperty("webdriver.gecko.driver", "./drivers\\geckodriver.exe");
						driver = new FirefoxDriver();
					}
		
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 } 
  
  @Test
  public void TC_009_candidateResumeUpload() {
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
	 
	 }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
