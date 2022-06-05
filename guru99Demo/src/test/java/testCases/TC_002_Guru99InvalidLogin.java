package testCases;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.GuruLoginPageObj;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TC_002_Guru99InvalidLogin {
 WebDriver driver;

  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }
  
 
  @Test(dataProvider = "dp")
  public void GURU_TC_002_InValidLogin(String user, String pswd) throws InterruptedException  {
	  
	  GuruLoginPageObj login = new GuruLoginPageObj(driver);
	  
	  //enter the url
	  driver.get("https://www.demo.guru99.com/V4/index.php");
	  //enter invalid credentials in the login page
	  login.loginMtd(user, pswd);
	  
	  //verifying the login has failed
	  
	  Assert.assertTrue(login.isInvalidLogin());
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "mgr123", "mgr123" },
      new Object[] { "mgr123",""},
      new Object[] { "mgr1234", "mgr!23" },
      new Object[] { "", "mgr!23" },
    };
  }
}
