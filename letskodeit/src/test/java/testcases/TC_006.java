package testcases;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.Status;

import pageobjects.PracticePage;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

public class TC_006 extends BaseClass{
  @Test
  @Parameters("crossbrowser")
  public void TC_006(String crossbrowser) {
	  testcase = extentreport.createTest("TC_006").assignDevice(crossbrowser).assignCategory("functional");
	  Logger logger = Logger.getLogger(TC_006.class);
	  PropertyConfigurator.configure("log4j.properties");
	  
	//creating object for Practise page
			PracticePage page = new PracticePage(driver);
		 
			logger.info("getting the url");
		    page.getUrl();
		    
		    logger.info("selecting all the check boxes");
		    page.clickAllCheckbox();
		    logger.info("uncheck all the checked boxes");
		    page.deselectAllCheckedBox();
		    logger.info("verifying all the check boxes are unchecked");
		    Assert.assertTrue(page.isAllCheckboxesUncheck(), "All the checked boxes are not unchecked");
		    testcase.log(Status.PASS, "All checked boxes are unchecked");
  }
  
  
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
