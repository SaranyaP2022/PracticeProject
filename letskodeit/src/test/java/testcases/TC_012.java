package testcases;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.Status;

import pageobjects.PracticePage;
import pageobjects.PracticePageObj;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

public class TC_012 extends BaseClass{
  
	@Test
	@Parameters("crossbrowser")
  public void TC_012(String crossbrowser) {
		
		testcase = extentreport.createTest("TC_012").assignDevice(crossbrowser).assignCategory("functional");
		Logger logger = Logger.getLogger(TC_012.class);
		PropertyConfigurator.configure("log4j.properties");
		
		//creating object for Practice page
				PracticePageObj page = new PracticePageObj(driver);
			 
				logger.info("getting the url");
			    page.getUrl();
			    logger.info("click on confirm btn");
			    page.clickConfirmBtn();
			    logger.info("verifying the confirm alert has opened");
			    Assert.assertTrue( page.isConfirmAlertOpened(), "the confirm alert box is not opened");
			    logger.info("verifying whether the confirm alert box has ok button");
			     Assert.assertTrue(page.isConfirmAlertHasOkBtn(), "The confirm box doesn't have ok btn");
			     logger.info("clicking on confirm btn again");
			     page.clickConfirmBtn();
			    logger.info("verifying whether the confirm alert box has cancel button");
			    Assert.assertTrue(page.isConfirmAlertHasCancelBtn(), "The confirm box doesn't have cancel btn");
			    testcase.log(Status.PASS, "The confirm alert box opens with ok and confirm btn");
  }
 
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
