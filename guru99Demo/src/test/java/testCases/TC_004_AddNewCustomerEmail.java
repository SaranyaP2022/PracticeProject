package testCases;

import org.testng.annotations.Test;
import pageObjects.AddNewCustPageObj;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TC_004_AddNewCustomerEmail {
	WebDriver driver;
	 @BeforeClass
	  public void beforeClass() {
		 
		 System.setProperty("webdriver.chrome.driver","./drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  }
	
	@Test
  public void GURU_TC_004_AddNewCustomerEmail()  {
		
		AddNewCustPageObj add = new AddNewCustPageObj(driver);
		//enter the url for adding new customer
		driver.get("https://www.demo.guru99.com/V4/manager/addcustomerpage.php");
		//verifying the current page is the add new customer page
		Assert.assertTrue(add.verifyPage());
		//entering invalid email in the mail text box
		add.addCustMail("test");
		//validating whether on entering invalid maild id it throws error
		Assert.assertTrue(add.emailNotValid(), "The error msg 'email id is not valid' is not displayed");
		}
 

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
