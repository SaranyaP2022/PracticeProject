package testcases;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.Status;

import pageobjects.PracticePageObj;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TC_013 extends BaseClass{
  @Test
  public void TC_013() {
	  
	  testcase = extentreport.createTest("TC_013").assignDevice("chrome").assignDevice("Firefox").assignCategory("functional");
		Logger logger = Logger.getLogger(TC_013.class);
		PropertyConfigurator.configure("log4j.properties");
		
		//creating object for Practise page
				PracticePageObj page = new PracticePageObj(driver);
			 
				logger.info("getting the url");
			    page.getUrl();
			    logger.info("enter text into text box beside the alert button");
			    page.enterTextForAlert();
			    logger.info("Enter the text in the text field beside the alert btn and verifying the text is reflected in the alert box");
			    Assert.assertTrue(page.enterTextForAlert(), "The text entered in the text box is not reflected in the alert");
			    testcase.log(Status.PASS, "The text in the text field reeflected in the alert box");
  }
 
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
