package testCases;

import org.testng.annotations.Test;

import pageObjects.AddNewCustPageObj;

import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TC_005_AddCustPin {
	
	WebDriver driver;
 @BeforeClass
	  public void beforeClass() {
	 
	 System.setProperty("webdriver.chrome.driver","./drivers\\chromedriver.exe");  
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  }	
	
  @Test
  public void GURU_TC_005_AddNewCustomerPin() {
	 
	  AddNewCustPageObj add = new AddNewCustPageObj(driver);
		//enter the url for new customer page
		driver.get("https://www.demo.guru99.com/V4/manager/addcustomerpage.php");
		//verifying the current page is add new customer page.
		Assert.assertTrue(add.verifyPage());
		//enter the pin number
		String s = add.addCustPin("12");
		// verifying the pin number length
		Assert.assertTrue(add.PinValidation(s),"The pin length is less than 6 digits");
		
  }
 
  @AfterClass
  public void afterClass() {
	driver.close();
  }

}
