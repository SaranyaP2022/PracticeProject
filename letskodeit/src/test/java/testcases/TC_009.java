package testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import com.aventstack.extentreports.Status;
import pageobjects.PracticePage;
import pageobjects.PracticePageObj;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;

public class TC_009 extends BaseClass{
	
	
 
	@Test
	@Parameters("crossbrowser")
  public void TC_009(String crossbrowser)  {
		
		Logger logger =  Logger.getLogger(TC_009.class);
		PropertyConfigurator.configure("log4j.properties");
		testcase = extentreport.createTest("TC_009").assignDevice(crossbrowser).assignCategory("functional");
		
		//creating object for Practise page
		PracticePage page = new PracticePage(driver);
		 
		logger.info("getting the url");
	    page.getUrl();
	    logger.info("Click on the open tab button, navigate to new tab");
	    page.clickOpenTab();
	    logger.info("verifying a new tab is opened");
	  //  Assert.assertTrue(page.isNewTab(), "On clicking 'open tab' no new tab is opened");
	     Assert.assertEquals(page.isNewTab(), true, "On clicking 'open tab' no new tab is opened");
	    //logger.info("close the tab");
	  //  driver.close();
	    testcase.log(Status.PASS, "On clicking 'open tab' new tab is opened");
  }
	@AfterTest
	  public void afterTest() {
		  driver.quit();
	  }
}
