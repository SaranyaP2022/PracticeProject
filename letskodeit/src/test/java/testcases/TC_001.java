package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.PracticePage;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

public class TC_001 extends BaseClass {
 
	@Test
	 @Parameters("crossbrowser")
  public void TC_001(String crossbrowser) {
		 
		Logger logger = Logger.getLogger(TC_001.class);
		PropertyConfigurator.configure("log4j.properties");
		
		testcase = extentreport.createTest("TC_001").assignDevice(crossbrowser).assignCategory("functional");
		
		//creating object for Practice page
		PracticePage page = new PracticePage(driver);
	 
		logger.info("getting the url");
	    page.getUrl();
	    logger.info("clicking on all the radio buttons under raadio btn example");
	    page.clickRadioBtns();
	    logger.info("Verifying whether the radio btn is selected");
	    Assert.assertTrue(page.isRadioBtnClicked("honda"), "The radio btn is not selected");
	    testcase.log(Status.PASS, "The radio button is clicked");
  }
 
	 @AfterTest 
	  public void afterTest() {
		  driver.quit(); 
		  }
	

}
