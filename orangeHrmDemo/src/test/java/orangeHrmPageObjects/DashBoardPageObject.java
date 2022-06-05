package orangeHrmPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPageObject {

	WebDriver driver;

	public DashBoardPageObject(WebDriver driver) {
		
		this.driver = driver;
	}
	
	//locators
	
	By admin = By.xpath("//a[@id = 'menu_admin_viewAdminModule']");
	By job = By.xpath("//a[@id = 'menu_admin_Job']");
	By workshift = By.xpath("//a[@id = 'menu_admin_workShift']");
	By userManagement = By.xpath("//a[@id = 'menu_admin_UserManagement']");
	By user = By.xpath("//a[@id = 'menu_admin_viewSystemUsers']");
	By recruitmentModule = By.xpath("//a[@id='menu_recruitment_viewRecruitmentModule']");
	
	
	//methods
	
	public void clickRecruitmentModule() {
		driver.findElement(recruitmentModule).click();
	}
	
	public void clickAdmin() {
		driver.findElement(admin).click();
	}
	
	public void clickJob() {
		driver.findElement(job).click();
	}
	
	public void clickworkshift() {
		driver.findElement(workshift).click();
	}
	
	public void clickUserManagement() {
		driver.findElement(userManagement).click();
	}
	
	public void clickUser() {
		driver.findElement(user).click();
	}
	
	
}
