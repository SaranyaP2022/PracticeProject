package orangeHrmTestcases;

import org.testng.annotations.Test;

import orangeHrmPageObjects.DashBoardPageObject;
import orangeHrmPageObjects.LoginPageObject;
import orangeHrmPageObjects.WorkShiftsPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TC_005_DeleteWorkShift {
	
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
  public void OrangeHrm_TC_005_DeleteWorkShift() {
		
		LoginPageObject login = new LoginPageObject(driver);
		DashBoardPageObject obj = new DashBoardPageObject(driver);
		WorkShiftsPageObject object = new WorkShiftsPageObject(driver);
		  
			// get url
					driver.get("https://opensource-demo.orangehrmlive.com/");
			//calling the login mtd	
					login.loginMtd("Admin", "admin123");
			//verifying login is successful		
					Assert.assertTrue(login.isLoginSuccess());
					obj.clickAdmin();
					obj.clickJob();
					obj.clickworkshift();
		 //verifying workshift page url
					  Assert.assertTrue(object.verfyPageUrl());
		//selecting the workshift to be deleted			  
		object.selectTodeleteWorkshift("night");
		//click on delete
		object.clickDelete();
		//click ok in the alert box
		object.clickOkAlert();
		//verifying the selected shift is deleted.
		Assert.assertTrue(object.isDeleted());
  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
