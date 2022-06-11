package testcases;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.Status;

import pageobjects.PracticePage;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

public class TC_007 extends BaseClass{
 
	@Test
	@Parameters("crossbrowser")
  public void TC_007(String crossbrowser) {
		Logger logger = Logger.getLogger(TC_007.class);
		PropertyConfigurator.configure("log4j.properties");
		testcase = extentreport.createTest("TC_007").assignDevice(crossbrowser).assignCategory("functional");
		
		//creating object for Practice page
		PracticePage page = new PracticePage(driver);
	 
		logger.info("getting the url");
	    page.getUrl();
	    logger.info("click on 'open window' button");
	    page.clickOpenwindow();
	    logger.info("Verifying a new window is opened");
	    Assert.assertTrue(page.isNewWindowOpened(), "New window is not opened");
	    testcase.log(Status.PASS, "New window opened");
  }
  
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
