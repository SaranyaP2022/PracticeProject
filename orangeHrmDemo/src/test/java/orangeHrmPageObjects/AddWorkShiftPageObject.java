package orangeHrmPageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddWorkShiftPageObject {
WebDriver driver;

	
	public AddWorkShiftPageObject(WebDriver driver) {
		this.driver = driver;
		}
	
	
	//locators
	By shiftName = By.xpath("//input[@id = 'workShift_name']");
	By from = By.xpath("//select[@id = 'workShift_workHours_from']");
	By to = By.xpath("//select[@id = 'workShift_workHours_to']");
	By duration = By.xpath("//input[contains(@class, 'time_range_duration')]");
	By availableEmployee = By.xpath("//select[@id = 'workShift_availableEmp']");
	By add = By.xpath("//a[@id = 'btnAssignEmployee']");
	By remove = By.xpath("//a[@id = 'btnRemoveEmployee']");
	By save = By.xpath("//input[@id = 'btnSave']");
	By assignedEmployee = By.xpath("//select[@id = 'workShift_assignedEmp']");
	By successfullyAddedMsg = By.xpath(" //div[contains(text(),' Successfully Saved ')]");
	By successfullyDeletedMsg = By.xpath("//div[contains(text(),' Successfully Deleted')]");
	
	public void addShiftName(String shiftname) {
		driver.findElement(shiftName).sendKeys(shiftname);
	}
	
	public void addWorkHourFrom(String time1)  {
		WebElement fromtime = driver.findElement(from);	   
		fromtime.click();
		Select option = new Select(fromtime);
		option.selectByVisibleText(time1);
		
	}
	
	public void addWorkHourto(String time2) {
	 driver.findElement(to).sendKeys(time2);		
	}
	
	public void chooseEmployee(String empName) {
		WebElement  selectEmployee = driver.findElement(availableEmployee);		
		Select option2 = new Select(selectEmployee);
		option2.selectByVisibleText(empName);
		}
	
    public void clickAdd() {
    	driver.findElement(add).click(); 
	}
    
    public void clickSave() {
    	driver.findElement(save).click();
	}
	
	
	//checking the employee got added to the assigned employee list
	
	public boolean isEmployeeAppearedOnList(String empName) {
		
		WebElement addedEmp = driver.findElement(assignedEmployee);
		Select options = new Select(addedEmp);
		List<WebElement> employeesList = options.getOptions();
		for (WebElement employee : employeesList) {
			if(employee.getText().equals(empName)) {
			
		return true;
		}
		
		}
		return false;
	
	}	
	
}






