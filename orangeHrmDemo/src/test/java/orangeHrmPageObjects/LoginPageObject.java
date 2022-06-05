package orangeHrmPageObjects;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject {

WebDriver driver;	
	
public LoginPageObject(WebDriver driver) {
	
	this.driver = driver;
}

//locators
	By username = By.xpath("//*[@id=\"txtUsername\"]");
	By password = By.xpath("//*[@id=\"txtPassword\"]");
	By loginButton = By.xpath("//*[@id=\"btnLogin\"]");
	By actualErrorMsg = By.xpath("//span[@id='spanMessage']");
	
	//method for login
	public void loginMtd(String usern, String passw) {
	
		driver.findElement(username).sendKeys(usern);
		driver.findElement(password).sendKeys(passw);
		driver.findElement(loginButton).click();
	}
	
	//assertion for validLogin
	
	public boolean isLoginSuccess() {
	String actualText = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")).getText(); //dash board text in home page
	String expectedText = "Dashboard";
	boolean status = actualText.equals(expectedText);
	return status;
		
	}
	
	/*assertion for invalidLogin
	
		public boolean isLoginfailed() {
		boolean status = driver.findElement(invalidCredentialMsg).isDisplayed();
		return status;
			
		}*/
	
	//verifying logout url
		public boolean isLogoutSuccessful() {
			String expectedUrl = driver.getCurrentUrl();
			String actualUrl= "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
			boolean status = expectedUrl.equals(actualUrl);
			return status;
			
		}
		
		public String actualError() {
			String error = driver.findElement(actualErrorMsg).getText();
			return error;
		}
}
