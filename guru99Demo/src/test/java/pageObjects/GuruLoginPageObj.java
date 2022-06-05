package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GuruLoginPageObj {
	WebDriver driver;

	public GuruLoginPageObj(WebDriver driver) {
		this.driver = driver;
	}
	
By usedid = By.xpath("//input[@name = 'uid']");
By password = By.xpath("//input[@name = 'password']");
By loginbtn = By.xpath("//input[@name = 'btnLogin']");
By resetbtn = By.xpath("//input[@name = 'btnReset']");


//method for login
	public void loginMtd(String usrid, String passw) throws InterruptedException {
	
		driver.findElement(usedid).sendKeys(usrid);
		driver.findElement(password).sendKeys(passw);
		driver.findElement(loginbtn).click();
		//new WebDriverWait(driver, 25).until(ExpectedConditions.alertIsPresent());
		Thread.sleep(1000);
	}
	
	//assertion for validLogin
	
		public boolean isLoginSuccess() {
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.demo.guru99.com/V4/manager/Managerhomepage.php";
		boolean status = actualUrl.equals(expectedUrl);
		return status;
			
		}
		
		//validate invalid login 
		
		public boolean isInvalidLogin() {
			Alert alert = driver.switchTo().alert();
			String actualmsg = alert.getText();
			
			String expectedmsg = "User or Password is not valid";
		boolean	status = actualmsg.equals(expectedmsg);
		return status;
			
		}
		
		
	}
