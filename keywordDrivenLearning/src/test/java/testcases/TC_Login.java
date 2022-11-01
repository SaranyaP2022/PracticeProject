package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Login {

	public static void main(String[] args) {
	//System.setProperty("webdriver.chrome.driver", "./driver\\chromedriver.exe");
	WebDriverManager.chromedriver().setup();	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	WebElement username = driver.findElement(By.xpath("//input[@name = 'username']"));
	username.sendKeys("Admin");
	WebElement password = driver.findElement(By.xpath("//input[@name = 'password']"));
	password.sendKeys("admin123");
	WebElement loginButton =  driver.findElement(By.xpath("//button[@type = 'submit']"));
	loginButton.click();
	}

}
