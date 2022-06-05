package orangeHrmPageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SystemUsersPageObject {

	WebDriver driver;
	
	public SystemUsersPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//locator
	@FindBy(xpath = "//input[@id = 'searchSystemUser_userName']") 
	WebElement username;
	
	@FindBy(id = "searchSystemUser_userType")
	WebElement userRole;
	
	@FindBy(id = "searchSystemUser_employeeName_empName")
	WebElement employeename;
	
	@FindBy(xpath = "//select[@id = 'searchSystemUser_status']")
	WebElement status;
	
	@FindBy(xpath = "//input[@id = 'searchBtn']")
	WebElement search;
	
	@FindBy(xpath = "//input[@id = 'resetBtn']")
	WebElement reset;
	
	
	@FindBy(xpath = "//input[@id = 'btnAdd']")
	WebElement add;
	
	@FindBy(xpath = "//input[@id = 'btnDelete']")
	WebElement delete;
	
	@FindBy(xpath = "//td[text() = 'No Records Found']")
	WebElement noRecordFound;
	
	@FindBy(xpath = "//div[@class = 'message success fadable']")
	WebElement successfullyDeleted;
	
	//selecting the user to delete
	@FindBy (xpath = "//a[text() ='Reddy']/preceding::td[1]")
	WebElement deleteUser;
	
	//Alert
	
	@FindBy (xpath = "//input[@id='dialogDeleteBtn']")
	WebElement okBtn;
	
	
	//methods
	
	public void enterUserName(String userName) {
		username.sendKeys(userName);
		}
	
	public void enterUserRole(String role) {
		Select select = new Select(userRole);
		if(role.equals("All")) {
			select.selectByVisibleText("All");
		}else if (role.equals("Admin")) {
			select.selectByVisibleText("Admin");
		}else if (role.equals("ESS")) {
			select.selectByVisibleText("ESS");
			}
	}
	
	public void enterStatus(String userstatus) {
		Select select1 = new Select(status);
		if(userstatus.equals("All")) {
			select1.selectByVisibleText("All");
		}else if (userstatus.equals("Enabled")) {
			select1.selectByVisibleText("Enabled");
		}else if (userstatus.equals("ESS")) {
			select1.selectByVisibleText("Enabled");
			}
	}
	
	public void deleteUser() {
		(new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(deleteUser));
		deleteUser.click();
		}
	public void acceptAlert() {
		okBtn.click();
	}
	
	public void clickSearch() {
		search.click();
		}
	public void clickReset() {
	reset.click();
	}
	public void clickAdd() {
		add.click();
	}
	
	public void clickDelete() {
		delete.click();
	}
	
	
	//assertion
	
	public boolean verifyUserPage() {
	String actualUrl =	driver.getCurrentUrl();
	String expectedUrl = "https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers";
	boolean status = actualUrl.equals(expectedUrl);
	return status;
	}
	
	public boolean noRecord() {
	String actualmsg = noRecordFound.getText();
	String expectedlmsg = "No Records Found";
	boolean status1 = actualmsg.equals(expectedlmsg);
	return status1;
	}
	
	public boolean isuserSuccessfullyDeleted() {
		String actualresult = successfullyDeleted.getText();
		String expectedresult = "Successfully Deleted";
		boolean status2 = actualresult.equals(expectedresult);
		return status2;
	}
	
}
