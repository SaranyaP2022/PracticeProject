package orangeHrmPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCandidatePageObject {
	
	WebDriver driver;
	public AddCandidatePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//locators
	@FindBy(xpath = "//h1[@id='addCandidateHeading']")
	WebElement addCandidateText;
	
	@FindBy(xpath = "//input[@id='addCandidate_resume']")
	WebElement chooseFile;
	
	//method
	
	public void uploadCandidateResume(String fileURL) {
		chooseFile.sendKeys(fileURL);
		
	}
	
	//assertion
			//verify it is add candidate page
			public String verifyAddcandidatePage() {
				String actualText = addCandidateText.getText();
				return actualText;
			}

}
