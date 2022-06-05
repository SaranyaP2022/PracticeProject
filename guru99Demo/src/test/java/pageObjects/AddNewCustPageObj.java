package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewCustPageObj {

	WebDriver driver;
	
	
	public AddNewCustPageObj(WebDriver driver) {
		super();
		this.driver = driver;
		}
	
	//locators
	By addNewCustText = By.xpath("//p[text() = 'Add New Customer']");
	By custName = By.xpath("//input[@name = 'name']");
	By genderMale = By.xpath("//input[@value = 'm']");
	By genderFemale = By.xpath("//input[@value = 'f']");
	By dob = By.xpath("//input[@id = 'dob']");
	By address = By.xpath("//textarea[@name = 'addr']");
	By city = By.xpath("//input[@name = 'city']");
	By state = By.xpath("//input[@name = 'state']");
	By pin = By.xpath("//input[@name = 'pinno']");
	By mobile = By.xpath("//input[@name = 'telephoneno']");
	By email = By.xpath("//input[@name = 'emailid']");
	By password = By.xpath("//input[@name = 'password']");
	By submit = By.xpath("//input[@name = 'sub']");
	By reset = By.xpath("//input[@name = 'res']");
	By invalidEmailMsg = By.xpath("Email-ID is not valid");
	
	//assertion
	public boolean verifyPage() {
		String actualText = driver.findElement(addNewCustText).getText();
		String expectedText = "Add New Customer";
		boolean status = actualText.equals(expectedText);
		return status;
	}
	
	//assertion for invalidemail
	public boolean emailNotValid() {
	boolean status = driver.findElement(By.xpath("//label[text() = 'Email-ID is not valid']")).isDisplayed();
		return status;
	}
	
	
	//mtd for adding new customer
	
	public void addCustomer(String name, String gender,String date) {
		driver.findElement(custName).sendKeys(name);
		
		//selecting the gender
		if(gender.equals("male")) {
			driver.findElement(genderMale).click();
			
		}else if (gender.equals("female")) {
			driver.findElement(genderFemale).click();
		}
		
		driver.findElement(dob).sendKeys(date);
	}
	
	public void custAddress(String Address) {
		driver.findElement(address).sendKeys(Address);
		}
	public void addCustPlace(String cityname, String statename) {
		driver.findElement(city).sendKeys(cityname);
		driver.findElement(state).sendKeys(statename);
		
	}
	
	public String addCustPin(String pinNumber) {
		driver.findElement(pin).sendKeys(pinNumber);
		return pinNumber;
		
	}
		// assertion for invalid pin length
	public boolean PinValidation(String s) {	
		 	if(s.length()<6) {
			boolean status = driver.findElement(By.xpath("//label[@id = 'message6']")).isDisplayed();
			return status;
		}
		return false;
		
		
	}
	
			
	public boolean addCustMobile(String mobilenumber) {
		driver.findElement(mobile).sendKeys(mobilenumber);
		if(mobilenumber.length()>10) {
			return false;
		}
		return true;
		
		}
	
	public void addCustMail(String emailId) {
		driver.findElement(email).sendKeys(emailId);
		}
	
	public void addPassw(String passw) {
		driver.findElement(password).sendKeys(passw);
	}
	
	public void submit() {
		driver.findElement(submit).click();		
	}
}
