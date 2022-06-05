package orangeHrmPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
	
	
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.XPATH , using = "//a[@id = 'welcome']")
	WebElement welcome;
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logOut;
	
	
	public void welcomelink() throws InterruptedException {
		welcome.click();
		Thread.sleep(2000);
	}
 
	public void logOutLink() {
		logOut.click();
	}
	
	
}
