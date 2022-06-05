package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewAccountPageObj {
	
	WebDriver driver;
	
	public AddNewAccountPageObj(WebDriver driver){
		this.driver = driver;
	}

	//locators
	By customerId = By.xpath("//input[@name = 'cusid']");
	By accountType = By.xpath("//select[@name = 'selaccount']");
	By initialDeposit = By.xpath("//input[@name = 'inideposit']");
	By submitBtn = By.xpath("//input[@name = 'button2']");
	By current = By.xpath("//option[@value = 'Current']");
	By custIdErrMsg = By.xpath("//label[@id = 'message14']");
	By depositErrMsg = By.xpath("//label[@id = 'message19']");
	
	//methods
	
	public void customerId(String id) {
		driver.findElement(customerId).sendKeys(id);
	}
			
	public void selectAccount(String account) {
		
	WebElement acc = driver.findElement(accountType);
	Select select = new Select(acc);
	if(account.equals("Current")) {
		select.selectByVisibleText("Current");
		
	}else if (account.equals("Savings")) {
		select.selectByVisibleText("Savings");
	}
	
	}
	
	public void initialDeposit( String amount) {
		driver.findElement(initialDeposit).sendKeys(amount);
	}
	public void clearInitialDeposit() {
		driver.findElement(initialDeposit).clear();
	}
	
	public void clickSendBtn() {
		driver.findElement(submitBtn).click();
	}
	//customer id field error msg
	public String actualCustIdErrMsg() {
		String actualError = driver.findElement(custIdErrMsg).getText();
		return actualError;
	}
	
	public String actualDepositErrMsg() {
		String actualError = driver.findElement(depositErrMsg).getText();
		return actualError;
	}
}
