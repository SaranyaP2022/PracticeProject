package orangeHrmPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VacanciesPageObject {
	WebDriver driver;
	public VacanciesPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='menu_recruitment_viewJobVacancy']")
	WebElement vacanciesTab;
	
	@FindBy(xpath = "//a[@class = 'toggle tiptip']")
	WebElement vacanciesText;
	
	
	
	
	
	//assertion
	//verify it is vacancies page
	public String verifyVacancyPage() {
		String actualText = vacanciesText.getText();
		return actualText;
	}
	
	
	
}
