package testcases;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.Status;

import pageobjects.PracticePageObj;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

public class TC_020 extends BaseClass {
 
	@Test
	@Parameters("crossbrowser")
  public void TC_020(String crossbrowser) {
		testcase = extentreport.createTest("TC_020").assignDevice(crossbrowser).assignCategory("functional");
		Logger logger = Logger.getLogger(TC_020.class);
		PropertyConfigurator.configure("log4j.properties");
		//creating object for Practice page
		PracticePageObj page = new PracticePageObj(driver);
		logger.info("getting the url");
	    page.getUrl();
	    logger.info("mouse hover over the btn 'Mouse Hover' ");
	    page.mouseHover();
	    logger.info("verify the mouse hover has drop down with contents");
	    Assert.assertTrue(page.mouseHoverDropDown(), "Either the dropdown is not displayed or the drop down misses the contents ");
	    testcase.log(Status.PASS, "The mouse hover displays drop down with options on hovering");
  }
 
	@AfterTest
  public void afterTest() {
		driver.quit();
  }

}
