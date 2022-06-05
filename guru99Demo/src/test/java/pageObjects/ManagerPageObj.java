package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManagerPageObj {
	WebDriver driver;

	public ManagerPageObj(WebDriver driver) {
		this.driver = driver;
	}
	
	//locator
	
	By registerSucessMsg = By.xpath("//p[text()= 'Customer Registered Successfully!!!']");
	By newCustomer = By.xpath("//a[text() = 'New Customer']");
	
	//validating whether customer is registered successfully
	
	public boolean isRegisterSuccess() {
		String actual = driver.findElement(registerSucessMsg).getText();
		String expected = "Customer Registered Successfully!!!";
		boolean status = actual.equals(expected);
		return status;
		}
	// to click new customer
	
	public void clickNewCust() {
		driver.findElement(newCustomer).click();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//span[text() = 'Close']")).click();
		driver.switchTo().defaultContent();
	}

}
