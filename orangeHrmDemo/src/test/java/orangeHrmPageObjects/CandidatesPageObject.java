package orangeHrmPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CandidatesPageObject {

	
	WebDriver driver;
	
	public CandidatesPageObject(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	//locators
	@FindBy(id = "candidateSearch_jobTitle")
	WebElement jobTitle;
	
	@FindBy(id = "candidateSearch_jobVacancy")
	WebElement vacancy;
	
	@FindBy(id = "candidateSearch_hiringManager")
	WebElement hiringManager;
	
	@FindBy(id = "candidateSearch_status")
	WebElement status;
	
	@FindBy(id = "candidateSearch_candidateName")
	WebElement candidateName;
	
	@FindBy(xpath = "//input[@id='btnAdd']")
	WebElement addBtn;
	
	//date of application
	
	//from textbox
	@FindBy(id = "candidateSearch_fromDate")
	WebElement from;
	@FindBy(xpath = "//input[@id='candidateSearch_fromDate']/following::img[1]")
	WebElement fromBoxCalendarImg;
	@FindBy(xpath = "//span[contains(text(),'Prev')]")
	WebElement previousArrowFromCalendar;
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement nextArrowFromCalendar;
	
	//to textbox
	@FindBy(id = "candidateSearch_toDate")
	WebElement to;
	@FindBy(xpath = "//input[@id='candidateSearch_toDate']/following::img")
	WebElement toBoxCalendarImg;
	
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement nextArrowInToCalendar;
	
	@FindBy(xpath = "//span[contains(text(),'Prev')]")
	WebElement previousArrowInToCalendar;
	
	@FindBy(xpath = "//input[@id='btnSrch']")
	WebElement search;
	
	@FindBy(xpath = "//span[@id='helpMessage']")
	WebElement clickOnCandidateMsg;
	
	
	//methods
	
	public void clickAddButton() {
		addBtn.click();
	}
	
	public void jobTitle(String titleOfTheJob) {
		jobTitle.click();
		Select option = new Select(jobTitle);
		option.selectByVisibleText(titleOfTheJob);
		
	}
	
	public void status(int selectStatus) {
		status.click();
		Select option1 = new Select(status);
		option1.selectByIndex(selectStatus);
		
	}
	
	public void fromDateOfApplication(String fromDate) {
		from.clear();
		from.sendKeys(fromDate + Keys.ENTER);
		
	}
	
	public void toDateOfApplication() {
		toBoxCalendarImg.click();
		nextArrowInToCalendar.click();
		driver.findElement(By.xpath("//tbody/tr[2]/td[2]/a[1]")).click();
		}
	
	public void chooseVacancy(String vacancyname) {
		vacancy.click();
		Select option2 = new Select(vacancy);
		option2.selectByVisibleText(vacancyname);
		
	}
	
	
	//assertion
	public boolean gotSearchResults() {
		boolean status = clickOnCandidateMsg.isDisplayed();
		return status;
	}
	
	// verifying the current page is candidates page
	public boolean verifyURL() {
		String actualURL = "https://opensource-demo.orangehrmlive.com/index.php/recruitment/viewCandidates";
		String currentURL = driver.getCurrentUrl();
		boolean status = actualURL.equals(currentURL);
		return status;
		
	}
	
	
}
