package testCases;

import org.testng.annotations.Test;

import pageObjects.AddNewCustPageObj;

import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TC_003_AddCustMobileNumber {
	WebDriver driver;
	
	@BeforeClass
	  public void beforeClass() {
		
		System.setProperty("webdriver.chrome.driver","./drivers\\chromedriver.exe");  
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  }	
	
  
	@Test
  public void GURU_TC_003_IsMobileNumberValid() {
		
		AddNewCustPageObj add = new AddNewCustPageObj(driver);
		
		driver.get("https://www.demo.guru99.com/V4/manager/addcustomerpage.php");
		
		// verifying the mobile number field by adding more than 10 digits
		Assert.assertTrue(add.addCustMobile("123456789012"), "The mobile number is more than 10 digit");
		
  }
  

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
