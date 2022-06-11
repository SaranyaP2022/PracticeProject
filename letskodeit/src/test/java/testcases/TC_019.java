package testcases;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.Status;

import pageobjects.PracticePageObj;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

public class TC_019 extends BaseClass{
 
	@Test
	@Parameters("crossbrowser")
 public void TC_019(String crossbrowser) {
		
		testcase = extentreport.createTest("TC_019").assignDevice(crossbrowser).assignCategory("functional");
		Logger logger = Logger.getLogger(TC_019.class);
		PropertyConfigurator.configure("log4j.properties");
		//creating object for Practice page
		PracticePageObj page = new PracticePageObj(driver);
		logger.info("getting the url");
	    page.getUrl();
	    logger.info("click on the show btn under element displayed example");
	    page.clickShowBtn();
	    logger.info("Verifying whether the text field is shown");
	    Assert.assertTrue(page.isBtnShown(), "The text box is not shown on clicking show btn");
	    logger.info("verify the text box has place holder");
	    Assert.assertTrue( page.placeHolder(), "The text box either doesnt have place holder or place holder text mismatch");
	    logger.info("enter text in the text box below 'Element displayed example' ");
	    page.textInElementDisplay("abc");
	    logger.info("verify text is entered in text field for 'Element displayed example'");
	    Assert.assertTrue(page.isTextEntered("abc"), "The text is not entered in the text box under 'Element displayed example'");
	    testcase.log(Status.PASS, "The text is entered in the text box for 'Element displayed example'");
  }
	
	
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  
}
