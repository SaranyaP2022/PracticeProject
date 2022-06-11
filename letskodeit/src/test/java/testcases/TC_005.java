package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageobjects.PracticePage;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

public class TC_005 extends BaseClass {
 
	
	@Test
	 @Parameters("crossbrowser")
  public void TC_005(String crossbrowser) {
		Logger logger = Logger.getLogger(TC_005.class);
		PropertyConfigurator.configure("log4j.properties");
		
		testcase = extentreport.createTest("TC_005").assignDevice(crossbrowser).assignCategory("functional");
		
		//creating object for Practise page
		PracticePage page = new PracticePage(driver);
	 
		logger.info("getting the url");
	    page.getUrl();
	    logger.info("clicking all the check boxes");
	    page.clickAllCheckbox();
	    logger.info("verifying all check boxes all clicked");
	    Assert.assertTrue(page.isAllBoxChecked(), "All check boxess are not checked");
	    testcase.log(Status.PASS, "All check boxes are checked");
  }
 
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
