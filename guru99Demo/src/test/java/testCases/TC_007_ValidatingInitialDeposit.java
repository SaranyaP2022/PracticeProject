package testCases;

import org.testng.annotations.Test;

import pageObjects.AddNewAccountPageObj;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TC_007_ValidatingInitialDeposit {
	
	WebDriver driver;
	
	 @BeforeClass
	  public void beforeClass() {
		 
		 	System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");
			ChromeOptions chromeoption = new ChromeOptions();
			chromeoption.addArguments("--start-maximized");
			driver = new ChromeDriver(chromeoption);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  }
	
	
	@Test(dataProvider = "dp")
  public void TC_007_ValidatingInitialDeposit(String depositAmt, String expError) {
		
		 AddNewAccountPageObj add = new AddNewAccountPageObj(driver);
		 driver.get("https://www.demo.guru99.com/V4/manager/addAccount.php");
		 //enter amount and then clear in initial deposit
		 add.initialDeposit(depositAmt);
		 add.clearInitialDeposit();
		 //verifying whether error msg is displayed if field left blank
		 String actualErr = add.actualDepositErrMsg();
		 Assert.assertEquals(actualErr, expError);
		 }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "10", "Initial Deposit must not be blank" },
       };
  }
 

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
