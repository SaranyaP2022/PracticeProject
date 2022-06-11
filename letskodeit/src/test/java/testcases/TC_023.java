package testcases;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.Status;

import pageobjects.PracticePageObj;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

public class TC_023 extends BaseClass {
  @Test
  @Parameters("crossbrowser")
  public void TC_023(String crossbrowser) {
	  
	  testcase = extentreport.createTest("TC_023").assignDevice(crossbrowser).assignCategory("functional");
		Logger logger = Logger.getLogger(TC_023.class);
		PropertyConfigurator.configure("log4j.properties");
		//creating object for Practice page
		PracticePageObj page = new PracticePageObj(driver);
		logger.info("getting the url");
	    page.getUrl();
	    logger.info("Switch to iframe and click home link");
	    page.iFrame();
	    logger.info("verify home page is displayed inside the frame");
	    Assert.assertTrue(page.isframeHome(), "The home page is not displayed inside the frame");
	    testcase.log(Status.PASS, "contents inside the home page is accessible");
	   
  }
 
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
