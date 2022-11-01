package actionkeywords;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionKeywords {
	static WebDriver driver;
	
	
//open browser
public static void openBrowser() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	
// go to url

public static void goToURL() {
	driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
// enter username

public static void enterUsername() {
	WebElement username = driver.findElement(By.xpath("//input[@name = 'username']"));
	username.sendKeys("Admin");
	}
	
//enter password
	
public static void enterPassword() {
	WebElement password = driver.findElement(By.xpath("//input[@name ='password']"));
	password.sendKeys("admin123");
	}	

//click login btn
	
public static void clickLogin() {
    WebElement loginButton =  driver.findElement(By.xpath("//button[@type ='submit']"));
	loginButton.click();
}	

}
