package orangeHrmTestcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import orangeHrmPageObjects.AddWorkShiftPageObject;
import orangeHrmPageObjects.DashBoardPageObject;
import orangeHrmPageObjects.LoginPageObject;
import orangeHrmPageObjects.WorkShiftsPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TC_004_AddWorkShift extends BaseClass{
	
  @Test
  @Parameters("crossbrowser")
  public void OrangeHrm_TC004_AddWorkShift(String crossbrowser)  {
	  
	  testcase = extentreport.createTest("TC_004_AddWorkShift").assignDevice(crossbrowser).assignCategory("functional");
	  LoginPageObject login = new LoginPageObject(driver);
	  DashBoardPageObject obj = new DashBoardPageObject(driver);
	  WorkShiftsPageObject object = new WorkShiftsPageObject(driver);
	  AddWorkShiftPageObject add = new AddWorkShiftPageObject(driver);
		
	  // get url
				driver.get("https://opensource-demo.orangehrmlive.com/");
	//calling the login mtd	
				login.loginMtd("Admin", "admin123");
	//verifying login is successful		
				Assert.assertTrue(login.isLoginSuccess());
	  
	  obj.clickAdmin();
	  obj.clickJob();
	  obj.clickworkshift();
	  
	  Assert.assertTrue(object.verfyPageUrl());
	  object.clickAdd();
	  
	  add.addShiftName("night");
	  add.addWorkHourFrom("09:15");
	  add.addWorkHourto("15:00");
	  add.chooseEmployee("Lisa Andrews");
	  add.clickAdd();
	  //checking whether the employee appeared on assigned employee list 
	 Assert.assertTrue(add.isEmployeeAppearedOnList("Lisa Andrews"));
	 
	 add.clickSave();
	  // verifying successfully saved msg is displayed.
		
		 String actualmsg = object.isSuccesfullyAdded(); 
		 String expectedmsg = "Successfully Saved"; 
		 Assert.assertEquals(actualmsg, expectedmsg);
		 testcase.log(Status.PASS, "Workshift was added successfully");
	 
  }
 
	/*
	 * @AfterClass public void afterClass() { driver.quit(); }
	 */

}
