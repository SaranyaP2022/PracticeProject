package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrangeHrmLogin {
	WebDriver driver;
	
 public	OrangeHrmLogin(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
 
//locators
	By username = By.xpath("//*[@id=\"txtUsername\"]");
	By password = By.xpath("//*[@id=\"txtPassword\"]");
	By loginButton = By.xpath("//*[@id=\"btnLogin\"]");

}
