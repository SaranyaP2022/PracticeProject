package testcases;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.Status;

import pageobjects.PracticePageObj;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

public class TC_015 extends BaseClass{
 
	@Test
	@Parameters("crossbrowser")
  public void TC_015(String crossbrowser) {
		testcase = extentreport.createTest("TC_015").assignDevice(crossbrowser).assignCategory("functional");
		Logger logger = Logger.getLogger(TC_015.class);
		PropertyConfigurator.configure("log4j.properties");
		
		//creating object for Practice page
				PracticePageObj page = new PracticePageObj(driver);
			 
				logger.info("getting the url");
			    page.getUrl();
			    logger.info("click on the disable button");
			    page.clickDisableBtn();
			    logger.info("verifying the text box under disable button is disabled/enabled");
			    Assert.assertFalse(page.isTextBoxDisabledEnabled(), "The text box is not disabled");
			    testcase.log(Status.PASS, "The text box is disabled on clicking disable btn");
			    
		
  }
  
	@AfterTest
  public void afterTest() {
		driver.quit();
  }

}
