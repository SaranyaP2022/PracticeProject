package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageobjects.PracticePage;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

public class TC_002 extends BaseClass {
 
	@Test
	 @Parameters("crossbrowser")
  public void TC_002(String crossbrowser) {
		Logger logger =  Logger.getLogger(TC_002.class);
		PropertyConfigurator.configure("log4j.properties");
		
		testcase = extentreport.createTest("TC_002").assignDevice(crossbrowser).assignCategory("functional");
		
		//creating object for Practice page
		PracticePage page = new PracticePage(driver);
		 
		logger.info("getting the url");
	    page.getUrl();
	    
	    logger.info("Click on the radio button for Benz");
	    page.clickRadioButton("Benz");
	    
	    logger.info("Verifying the radio btn for benz is clicked");
	    Assert.assertTrue(page.isRadioBtnClicked("Benz"), "The radio button for benz is not clicked");
	    
	    logger.info("verifying only one radio btn is clicked");
	    Assert.assertEquals(page.isOneRadioBtnSelected(), 1);
	    
	    testcase.log(Status.PASS, "Only one radio button is selected");
  }
 
	 @AfterTest
	  public void afterTest() {
		  driver.quit();
	  }

}
