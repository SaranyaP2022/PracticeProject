package testCases;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.GuruLoginPageObj;

import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TC_001_Guru99ValidLogin {
	WebDriver driver;
	@BeforeClass
	  public void beforeClass() {
		WebDriverManager.chromedriver().setup();  
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  }	
	
	
  @Test
  public void GURU_TC_001_ValidLogin() throws InterruptedException {
	  GuruLoginPageObj login = new GuruLoginPageObj(driver);
	 //enter the URL
	  driver.get("https://www.demo.guru99.com/V4/index.php");
	  //login with credentials
	  login.loginMtd("mgr123", "mgr!23");
	  //verifying the login is success
	 Assert.assertTrue(login.isLoginSuccess(), "Login was unsuccessful");
	  
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
