package testcases;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.Status;

import pageobjects.PracticePage;
import pageobjects.PracticePageObj;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

public class TC_022 extends BaseClass{
 
	@Test
	@Parameters("crossbrowser")
  public void TC_022(String crossbrowser) {
		testcase = extentreport.createTest("TC_022").assignDevice(crossbrowser).assignCategory("functional");
		Logger logger = Logger.getLogger(TC_022.class);
		PropertyConfigurator.configure("log4j.properties");
		//creating object for Practice page
		PracticePageObj page= new PracticePageObj(driver);
		PracticePage p = new PracticePage(driver);
		logger.info("getting the url");
	    page.getUrl();
	    logger.info("click on Benz radio btn");
	    p.clickRadioButton("Benz");
	    logger.info("mouse hover over the btn 'Mouse Hover' ");
	    page.mouseHover();
	    logger.info("click on reload option in the drop down");
	    page.clickReload();
	    logger.info("verify whether the page is reloaded");
	    Assert.assertFalse(page.reloaded(), "The page is not reloaded");
	    testcase.log(Status.PASS, "The page is reloaded on clicking reload option");
  }
 
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
