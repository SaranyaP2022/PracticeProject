package orangeHrmPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkShiftsPageObject {
	
	WebDriver driver;
	
	
	public WorkShiftsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	//locators
	
	By Add = By.xpath("//input[@id = 'btnAdd']");
	By Delete = By.xpath("//input[@id = 'btnDelete']");
	By checkbox = By.xpath("//input[@id = 'ohrmList_chkSelectRecord_1']");
	By successfullyAddedMsg = By.xpath(" //div[contains(@class, 'message success fadable')]");
	By successfullyDeletedMsg = By.xpath("//div[contains(@class, 'message success fadable')]");
	//By selectToDel = By.xpath("//a[text()='General']/preceding::td[1]");
	By alertClickOk = By.xpath("//input[@id = 'dialogDeleteBtn']");
	
	
	//Assertion
	public String isSuccesfullyAdded() {
		WebElement element = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(successfullyAddedMsg));
		String actual = element.getText();	
		return actual;
		}
	
	public boolean isDeleted() {
		WebElement element = new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(successfullyDeletedMsg));
		String actualtext = element.getText();	
		String expectedtext = "Successfully Deleted";
		if(actualtext.equals(expectedtext)) {
			System.out.println("Successfully Deleted");
		}
		return true;
	}
	
	//verifying the url
	public boolean verfyPageUrl() {
	String actualUrl= driver.getCurrentUrl();
	String expectedUrl = "https://opensource-demo.orangehrmlive.com/index.php/admin/workShift";
	boolean status = actualUrl.equals(expectedUrl);
	return status;
		
	}
	
	//methods
	public void clickAdd() {
		driver.findElement(Add).click();
	}
	
	public void clickDelete() {
		driver.findElement(Delete).click();
	}

	public void selectTodeleteWorkshift(String shiftName) {
		
		//driver.findElement(selectToDel).click();
		
		String finalXpath ="//a[text()=\'"+shiftName+"\']/preceding::td[1]" ;
		driver.findElement(By.xpath(finalXpath)).click();
	}
	
	public void clickOkAlert() {
		driver.findElement(alertClickOk).click();
	}
	
	public void print() {
		System.out.println("print");
	}
}
