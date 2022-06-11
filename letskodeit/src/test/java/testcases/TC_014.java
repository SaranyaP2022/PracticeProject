package testcases;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.Status;

import pageobjects.PracticePage;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TC_014 extends BaseClass{
  @Test
  public void TC_014() {
	  Logger logger =  Logger.getLogger(TC_014.class);
		PropertyConfigurator.configure("log4j.properties");
		testcase = extentreport.createTest("TC_014").assignDevice("chrome").assignDevice("Firefox").assignCategory("functional");
		
		//creating object for Practice page
		PracticePage page = new PracticePage(driver);
		 
		logger.info("getting the url");
	    page.getUrl();
	    logger.info("Verifying whether the table has 4 rows ");
	    Assert.assertTrue(page.rowCount(), "web table row count is not equal to 4");
	    logger.info("Verifying whether the table has 3 columns ");
	    Assert.assertTrue(page.colCount(), "web table column count is not equal to 3");
	    logger.info("verifying the course has corresponding price");
	    Assert.assertTrue(page.webContent(), "The course doen't related to the correct price");
	    testcase.log(Status.PASS, "The web table has the required rows and columns populatedwith values");
	    
  }
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
