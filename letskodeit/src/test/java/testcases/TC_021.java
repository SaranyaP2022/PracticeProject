package testcases;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.Status;

import pageobjects.PracticePageObj;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

public class TC_021 extends BaseClass{
 
	@Test
	@Parameters("crossbrowser")
  public void TC_021(String crossbrowser) {
		testcase = extentreport.createTest("TC_021").assignDevice(crossbrowser).assignCategory("functional");
		Logger logger = Logger.getLogger(TC_021.class);
		PropertyConfigurator.configure("log4j.properties");
		//creating object for Practice page
		PracticePageObj page = new PracticePageObj(driver);
		logger.info("getting the url");
	    page.getUrl();
	    logger.info("mouse hover over the btn 'Mouse Hover' ");
	    page.mouseHover();
	    logger.info("click on top option in the drop down");
	    page.clickTop();
	    logger.info("verifying whether on clicking top it takes to the top of the page");
	    Assert.assertTrue(page.istopOfPage(), "On clicking top option it doesnt take to the top of the page");
	    testcase.log(Status.PASS, "The top link takes to the top of the page");
  }
  
  
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
