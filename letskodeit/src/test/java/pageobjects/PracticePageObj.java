package pageobjects;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticePageObj {
	WebDriver driver;

	public PracticePageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// locators
	
	//get the url
		public void getUrl() {
			driver.get("https://courses.letskodeit.com/practice");
		}

	// Radio button example

	@FindBy(id = "hondaradio")
	WebElement honda;
	
	@FindBy(id = "benzradio")
	WebElement Benz;

	// switch to alert example
	// confirm btn
	@FindBy(id = "confirmbtn")
	WebElement confirmBtn;
	
	//Alert btn
		@FindBy(id = "alertbtn")
		WebElement alertBtn;
	
	//text field under switch alert example
	@FindBy(xpath = "//div[@id = 'alert-example-div']//following::input[@name = 'enter-name']")
	WebElement AlertTextField;
	

	// enabled/disabled example
	// disable btn
	@FindBy(id = "disabled-button")
	WebElement disableBtn;
	
	// enable btn
	@FindBy(id = "enabled-button")
	WebElement enableBtn;
	
	// enabled/disabled field
	@FindBy(id = "enabled-example-input")
	WebElement txtField;

	// element displayed example
	// hide btn
	@FindBy(id = "hide-textbox")
	WebElement hideBtn;
	// show btn
	@FindBy(id = "show-textbox")
	WebElement showBtn;
	// text field
	@FindBy(id = "displayed-text")
	WebElement displayedTextField;

	// mouse hover example
	// mouse over btn
	@FindBy(id = "mousehover")
	WebElement mouseHoverBtn;
	
	//mouse hover drop down
	@FindBy(xpath = "//div[@class='mouse-hover-content']")
	WebElement mouseHoverDropdown;
	
	//links in mouse hover drop down 
	@FindBy(xpath = "//div[@class='mouse-hover-content']/a")
	List<WebElement> mousehoverlist;
	
	//top option in mouse hover
	@FindBy(xpath = "//a[contains(text(),'Top')]")
	WebElement top;
	
	//reload option in mouse hover
		@FindBy(xpath = "//a[contains(text(),'Reload')]")
		WebElement reload;
		
	// home link inside the frame
		@FindBy(linkText = "HOME")
		WebElement frameHome;
		
	// sign in 
		@FindBy(xpath = "//a[contains(text(),'Sign In')]")
		WebElement signin;
		
	//iFrame example text
		@FindBy(xpath = "//legend[contains(text(),'iFrame Example')]")
		WebElement frametext;
	
	//signup now
		@FindBy(xpath = "//a[contains(text(),'Sign up now')]")
		WebElement signup;
		
		

	// methods
	// click confirm confirm btn in switch to alert example
	public void clickConfirmBtn() {
		confirmBtn.click();
	}
	
	//click on the text field under switch to alert example and enter the text,click alert btn and verify the text is reflected in alert
	public boolean enterTextForAlert() {
		AlertTextField.sendKeys("abc123");
		alertBtn.click();
		Alert alert = driver.switchTo().alert();
		String actaultext =	alert.getText();
		String expectedText = "Hello abc123, share this practice page and share your knowledge";
		boolean  status = actaultext.equals(expectedText);
		alert.accept();
		return status;
	}
	
	//click on the disable button
	public void clickDisableBtn() {
		disableBtn.click();
	}
	
	//click on enable btn
	public void clickEnableBtn() {
		enableBtn.click();
	}
	
	//click on the hide btn
	public void clickHideBtn() {
		hideBtn.click();
	}
	
	//click on show btn
	public void clickShowBtn() {
		showBtn.click();
	}
	
	//enter text in the text box below 'Element displayed example'
	public void textInElementDisplay(String s) {
		displayedTextField.sendKeys(s);
	}
	
	
	//scroll and mouse hover over the button 'mouse hover'
	public void mouseHover() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", mouseHoverBtn);
		Actions action = new Actions(driver);
		action.moveToElement(mouseHoverBtn).build().perform();
	}
	
	//click on 'top' opt from the mouse hover drop down 
	public void clickTop() {
		top.click();
		}
	
	//click on 'reload' opt from the mouse hover drop down 
		public void clickReload() {
			reload.click();
			}
		
	// switch to iframe and click on home link
		
		public void iFrame() {
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView(false)",frametext);
			driver.switchTo().frame("iframe-name");
			frameHome.click();
			}
	
	// assertion
		
	//verify home page is displayed inside the frame
	public boolean isframeHome() {
	String actual =	signup.getText();
	String expected = "Sign up now";
	boolean status = actual.equals(expected);
	return status;
	}
	
		
	
	//verifying whether on clicking top it takes to the top of the page
	public boolean istopOfPage() {
		String s = driver.findElement(By.xpath("//h1[contains(text(),'Practice Page')]")).getText();
		String expected = "Practice Page";
		boolean status = s.equals(expected);
		return status;
	}
	
	//verifying the page is reloaded
	public boolean reloaded() {
	boolean b =	Benz.isSelected();
		return b;
	}
	
	//verify on hovering mouse hover btn drop down with options are displayed
	public boolean mouseHoverDropDown() {
	List<WebElement> list =	mousehoverlist;
	boolean flag = false;
	for (WebElement link : list) {
		if(link.getText().equals("Reload")) {
			flag = true;
	}else
		flag = false;
	}
	System.out.println(flag);
	return flag;
	}
	
	// verify text is entered in text field for 'Element displayed example'
	public boolean isTextEntered(String x) {
	String s = displayedTextField.getAttribute("value");
	System.out.println(s);
	String actual = x;
	boolean status = s.equals(actual);
	return status;
	}
	
	//verify the text box is hidden on clicking hide btn
	public boolean isBtnHidden() {
	String display = displayedTextField.getCssValue("display");
	boolean flag = false;
	if(display.equals("none")) {
		flag = true;
		}else
			flag = false;
	return flag;
	}
	
	//verify the text box is shown on clicking show btn
		public boolean isBtnShown() {
		String display = displayedTextField.getCssValue("display");
		boolean flag = false;
		if(display.equals("block")) {
			flag = true;
			}else
				flag = false;
		return flag;
		}
	
		//verify the text box under hide/show has place holder
		public boolean placeHolder() {
		String actualTxt = displayedTextField.getAttribute("placeholder");
		String expected = "Hide/Show Example";
		boolean status = actualTxt.equals(expected);
		return status;
		}
		
		
		
		
	
	//verifying the text box under disable button is disabled/enabled
	public boolean isTextBoxDisabledEnabled() {
	boolean isEnabled =	txtField.isEnabled();
	return isEnabled;
	}
	
	//verifying whether text can be entered after clicking enable btn
	public String isTextEnteredInBox(String t)  {
	txtField.sendKeys(t);
	String s = txtField.getAttribute("value");
	System.out.println("the text is  "+ s);
	return s;
	}
	
	// verify whether confirm alert box opens
	public boolean isConfirmAlertOpened() {
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		String expectedAlertText = "Hello , Are you sure you want to confirm?";
		System.out.println("confirm Alert box text: "+ actualAlertText);
		boolean status = actualAlertText.equals(expectedAlertText);
		return status;
	}

	// verify whether confirm alert box has ok button
	public boolean isConfirmAlertHasOkBtn() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		honda.click();
		System.out.println("Radio btn has been clicked after click ok in alert box");
		boolean isSelected = honda.isSelected();
		return isSelected;
	}

	// verify whether confirm alert box has ok button
	public boolean isConfirmAlertHasCancelBtn() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		Benz.click();
		System.out.println("Radio btn has been clicked after click cancel in alert box");
		boolean isSelected = Benz.isSelected();
		return isSelected;
	}

}
