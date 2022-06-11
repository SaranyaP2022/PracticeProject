package testcases;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.Status;

import pageobjects.PracticePageObj;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;

public class TC_016 extends BaseClass{
  
	@Test
	@Parameters("crossbrowser")
  public void TC_016(String crossbrowser) throws InterruptedException{
		testcase = extentreport.createTest("TC_016").assignDevice(crossbrowser).assignCategory("functional");
		Logger logger = Logger.getLogger(TC_016.class);
		PropertyConfigurator.configure("log4j.properties");
		
		//creating object for Practice page
				PracticePageObj page = new PracticePageObj(driver);
			 
				logger.info("getting the url");
			    page.getUrl();
			    logger.info("click on the disable button");
			    page.clickDisableBtn();
			    logger.info("click on enable btn");
			    page.clickEnableBtn();
			    logger.info("verifying the text box under enable button is disabled/enabled");
			    Assert.assertTrue(page.isTextBoxDisabledEnabled(), "The text box is not enabled");
			    logger.info("verifying whether text can be entered after clicking enable btn");
			   Assert.assertEquals(page.isTextEnteredInBox("abc"), "abc");
			    testcase.log(Status.PASS, "The text box is disabled on clicking disable btn");
			    
		
  }
 
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
