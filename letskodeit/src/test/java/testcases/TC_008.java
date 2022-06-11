package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageobjects.PracticePage;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

public class TC_008 extends BaseClass{
 
	@Test
	@Parameters("crossbrowser")
  public void TC_008(String crossbrowser) {
		Logger logger = Logger.getLogger(TC_008.class);
		PropertyConfigurator.configure("log4j.properties");
		
		testcase = extentreport.createTest("TC_008").assignDevice(crossbrowser).assignCategory("functional");
		
		//creating object for Practice page
		PracticePage page = new PracticePage(driver);
	 
		logger.info("getting the url");
	    page.getUrl();
	    logger.info("click on 'open window' btn");
	    page.clickOpenwindow();
	    logger.info("verifying a new window opened on clicking 'open window' btn");
	    Assert.assertTrue(page.isNewWindowOpened(),"No new window opened");  
	    logger.info("click on home link in child window");
	    page.childWindowActions();
	    logger.info("verifying the current page is home page in child window");
	    Assert.assertTrue(page.isHomePageOnChildwindow(), "The current page in child window is not home page");
	    logger.info("closing the child window");
	    page.closeChildWindow();
	    logger.info("verifying the child window is closed");
	    Assert.assertTrue(page.ischildWindowClosed(), "Child window is not closed");
	    testcase.log(Status.PASS, "The home link on child window navigated to the corresponding page and child window got closed on closing the window");
  }
 
	@AfterTest
  public void afterTest() {
		driver.quit();
  }

}
