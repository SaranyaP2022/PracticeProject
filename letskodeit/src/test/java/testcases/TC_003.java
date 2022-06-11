package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageobjects.PracticePage;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

public class TC_003 extends BaseClass{
 
	@Test
	@Parameters("crossbrowser")
  public void TC_003(String crossbrowser) {
		
		testcase = extentreport.createTest("TC_003").assignDevice(crossbrowser).assignCategory("functional");
		Logger logger = Logger.getLogger(TC_003.class);
		PropertyConfigurator.configure("log4j.properties");
		
		//creating object for Practise page
				PracticePage page = new PracticePage(driver);
				 
				logger.info("getting the url");
			    page.getUrl();
			    logger.info("Validating the option from the drop down is selectable under the title 'Select Class Example'");
			    logger.info("Verifying whether the selected value from the drop down is displayed in the text field");
			  Assert.assertEquals(page.selectDropDown("selectByValue", "honda"), "Honda");
			   	testcase.log(Status.PASS, "The selected option is displayed in the text field of drop down");
  }
  
	@AfterTest
  public void afterTest() {
		driver.quit();
  }

}
