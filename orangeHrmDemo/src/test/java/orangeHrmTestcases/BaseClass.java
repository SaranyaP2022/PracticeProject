package orangeHrmTestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	WebDriver driver;
	
	@BeforeClass
	  @Parameters("crossbrowser")
	  public void launchBrowser(String crossbrowser) {
		// launch browser
				if(crossbrowser.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();
			  		driver = new ChromeDriver();
					}else if (crossbrowser.equalsIgnoreCase("firefox")) {
						driver = WebDriverManager.firefoxdriver().create();
					}
		  		driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	 @AfterClass
	  public void afterClass() {
		// close the browser
				driver.quit();
			}
}
