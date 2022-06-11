package testcases;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.Status;

import pageobjects.PracticePageObj;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

public class TC_018 extends BaseClass{

	@Test
	@Parameters("crossbrowser")
  public void TC_018(String crossbrowser) {
		
		testcase = extentreport.createTest("TC_018").assignDevice(crossbrowser).assignCategory("functional");
		Logger logger = Logger.getLogger(TC_018.class);
		PropertyConfigurator.configure("log4j.properties");
		
		//creating object for Practice page
				PracticePageObj page = new PracticePageObj(driver);
			 
				logger.info("getting the url");
			    page.getUrl();
			    logger.info("click on hide btn");
			    page.clickHideBtn();
			    logger.info("verify the text box is hidden on clicking hide btn");
			    Assert.assertTrue(page.isBtnHidden(), "The text box is not hidden on clicking the hide btn");
			    logger.info("click on the show btn under element displayed example");
			    page.clickShowBtn();
			    logger.info("Verifying whether the text field is shown");
			    Assert.assertTrue(page.isBtnShown(), "The text box is not shown on clicking show btn");
			    logger.info("verify the text box has place holder");
			    Assert.assertTrue( page.placeHolder(), "The text box either doesnt have place holder or place holder text mismatch");
			    testcase.log(Status.PASS, "The text box has place holder");
			    
  }
  
	@AfterTest
  public void afterTest() {
		driver.quit();
  }

}
