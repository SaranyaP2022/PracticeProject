package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageobjects.PracticePage;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

public class TC_004 extends BaseClass{
 
	@Test
	@Parameters("crossbrowser")
  public void TC_004(String crossbrowser)  {
		testcase = extentreport.createTest("TC_004").assignDevice(crossbrowser).assignCategory("functional");
		Logger logger = Logger.getLogger(TC_004.class);
		PropertyConfigurator.configure("log4j.properties");
		
		//creating object for Practice page
				PracticePage page = new PracticePage(driver);
				 
				logger.info("getting the url");
			    page.getUrl();
			    
			    logger.info("Validating and verifying whether multiple options can be selected  under Multiple Select Example");
			
			    boolean b =  page.selectMultiOption();
			   
			  
			   Assert.assertTrue(b, "Multiple option not selected");
			    testcase.log(Status.PASS, "Multiple options got selected");
			   
			   
	  
  }
	 @AfterTest 
	  public void afterTest() {
		  driver.quit(); 
		  }
  
}
