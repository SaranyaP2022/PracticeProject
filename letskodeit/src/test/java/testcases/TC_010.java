package testcases;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.Status;

import pageobjects.PracticePage;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

public class TC_010 extends BaseClass {
 
  @Test
  @Parameters("crossbrowser")
  public void TC_010(String crossbrowser) {
	  Logger logger =  Logger.getLogger(TC_010.class);
		PropertyConfigurator.configure("log4j.properties");
		testcase = extentreport.createTest("TC_010").assignDevice(crossbrowser).assignCategory("functional");
		
		//creating object for Practise page
		PracticePage page = new PracticePage(driver);
		 
		logger.info("getting the url");
	    page.getUrl();
	    logger.info("click on 'open tab' btn and navigate to new tab ");
	    page.clickOpenTab();
	    logger.info("click on link 'JavaScript for beginners'");
	    page.clickLink();
	    logger.info("verify on clicking link in the new tab opens the related page");
	    Assert.assertTrue(page.isdirectedtolinkedPage(), "On clicking the link in the new tab, it doesn't take to the corresponding page");
	    driver.close();
	    testcase.log(Status.PASS, "On clicking the link in the new tab, it takes to the corresponding page");
	 
  }
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
