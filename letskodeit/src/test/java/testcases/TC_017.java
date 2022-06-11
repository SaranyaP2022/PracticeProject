package testcases;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.Status;

import pageobjects.PracticePageObj;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

public class TC_017 extends BaseClass{
 
	@Test
	@Parameters("crossbrowser")
  public void TC_017(String crossbrowser) {
		testcase = extentreport.createTest("TC_017").assignDevice(crossbrowser).assignCategory("functional");
		Logger logger = Logger.getLogger(TC_017.class);
		PropertyConfigurator.configure("log4j.properties");
		
		//creating object for Practice page
				PracticePageObj page = new PracticePageObj(driver);
			 
				logger.info("getting the url");
			    page.getUrl();
			    logger.info("click on hide btn");
			    page.clickHideBtn();
			    logger.info("verify the text box is hidden on clicking hide btn");
			    Assert.assertTrue(page.isBtnHidden(), "The text box is not hidden on clicking the hide btn");
			    testcase.log(Status.PASS, "The text box got hidden on clicking hide btn");
  }
 
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
