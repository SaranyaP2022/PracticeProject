package testCases;

import org.testng.annotations.Test;

import pageObjects.AddNewAccountPageObj;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TC_006_CustomerIdVerification {
	
	WebDriver driver;
	
	@BeforeClass
	  public void beforeClass() {
		//launch browser
		System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");
		ChromeOptions chromeoption = new ChromeOptions();
		chromeoption.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeoption);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  }
	
	
  @Test(dataProvider = "dp")
  public void Guru99_TC006_CustomerIdVerification(String id, String expectedError)  {
	  
	  AddNewAccountPageObj add = new AddNewAccountPageObj(driver);
	  // enter the url for adding new account
	  driver.get("https://www.demo.guru99.com/V4/manager/addAccount.php");
	  // entering customer id
	  add.customerId(id);
	  //verifying whether error msg is thrown on invalid entry
	  String actualError = add.actualCustIdErrMsg(); 
	  Assert.assertEquals(actualError, expectedError);
	  
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "abc", "Characters are not allowed"},
      new Object[] { "a123", "Characters are not allowed"}
      };
  }
  

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
