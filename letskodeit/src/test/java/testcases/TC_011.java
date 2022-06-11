package testcases;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.Status;

import pageobjects.PracticePage;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

public class TC_011 extends BaseClass{

	@Test
	@Parameters("crossbrowser")
  public void TC_011(String crossbrowser) {
		
		testcase = extentreport.createTest("TC_011").assignDevice(crossbrowser).assignCategory("functional");
		Logger logger = Logger.getLogger(TC_011.class);
		PropertyConfigurator.configure("log4j.properties");
		
		//creating object for Practise page
				PracticePage page = new PracticePage(driver);
			 
				logger.info("getting the url");
			    page.getUrl();
			    logger.info("clicking on the alert button");
			    page.clickAlert();
			    logger.info("verifying whther the alert box  is opened and has ok button");
			    Assert.assertTrue(page.isAlertOpened(), "The alert either didn't open or didn't have ok btn");
			    testcase.log(Status.PASS, "The alert box opened and has ok btn");
  }
  
	@AfterTest
  public void afterTest() {
		driver.quit();
  }

}
