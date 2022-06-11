package pageobjects;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PracticePage {
	WebDriver driver;
	public PracticePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	//locators
	//Radio button example
	
	@FindBy(id = "hondaradio")
	WebElement honda;
	
	@FindBy(id = "benzradio")
	WebElement Benz;
	
	@FindBy(id = "bmwradio")
	WebElement BMW;
	
	//all radio buttons in radio button example
	@FindBy(xpath = "//div[@id = 'radio-btn-example']/fieldset/label/input")
	List<WebElement> radioBtns;
	
	// select class example
	
	@FindBy(id = "carselect")
	WebElement dropdown;
	
	//multiple select
	
	@FindBy(id = "multiple-select-example")
	WebElement multiSelect;
	
	@FindBy(xpath = "//select[@id = 'multiple-select-example']/option")
	List<WebElement> multipleSelect;
	
	//checkbox example
	//all the checkboxes
	@FindBy(xpath = "//div[@id = 'checkbox-example-div']/fieldset/label/input")
	List<WebElement> checkboxes;
	
	//switch window
	@FindBy(id = "openwindow")
	WebElement openWindowBtn;
	
	//switch tab
	@FindBy(id = "opentab")
	WebElement openTabButton;
	
	//switch to Alert
	//text field
	@FindBy(xpath = "//input[@name = 'enter-name']")
	WebElement alertTextfield;
	//Alert btn
	@FindBy(id = "alertbtn")
	WebElement alertBtn;
	
	// home link on child window
	@FindBy(xpath = "//a[text() ='HOME']")
	WebElement home;
	
	// 'JavaScript for beginners' link in new tab
	@FindBy(xpath = "//h4[contains(text(),'JavaScript for beginners' )]")
	WebElement linkintab;
	
	//webtable td[2]
	@FindBy (xpath = "//table[@id = 'product']//td[2]")
	List<WebElement> td2;
	
	//header- web table
	@FindBy(xpath = "//table[@id = 'product']//th")
	List<WebElement> headers;
	
	// web table tr
	@FindBy(xpath = "//table[@id = 'product']//tr")
	List<WebElement> totaltr;
	
	//methods
	
	//get the url
	public void getUrl() {
		driver.get("https://courses.letskodeit.com/practice");
	}
	
	//click on all the radio buttons in radio button example
	
	public void clickRadioBtns()  {
		
		for (WebElement button : radioBtns) {
			button.click();
			}
	}
	
	//click on the radio btn Benz
	public void clickRadioButton(String btnName) {
		switch (btnName) {
		case "honda":
			honda.click();
			break;
		case "BMW":
			BMW.click();
			break;
		case "Benz":
			Benz.click();
			break;
		default:
			System.out.println("enter correct option");
			break;
		}
	}
	
	//Validate whether the options from the drop down is selectable under the title 'Select Class Example'.
	
		public String selectDropDown(String type, String value) {
			Select select = new Select(dropdown);
			switch (type) {
			case "selectByValue":
				select.selectByValue(value);
				break;
				
			case "selectByIndex":
				select.selectByIndex(Integer.parseInt(value));
				break;
				
			case "selectByVisibleText":
				select.selectByVisibleText(value);
				break;

			default:
				System.out.println("Enter correct criteria");
				break;
			}
			WebElement selectedOpt = select.getFirstSelectedOption();
			String s = selectedOpt.getText();
			System.out.println(s);
			return s;
			
			}
		
	//Selecting multiple options in multiple select example and validating whether selected
		
		public boolean selectMultiOption() {
			Actions mouse = new Actions(driver);
			/*mouse.clickAndHold(multipleSelect.get(0));
			 mouse.clickAndHold(multipleSelect.get(1));
			 mouse.clickAndHold(multipleSelect.get(2));
			 mouse.build().perform();*/
			
			mouse.keyDown(Keys.CONTROL).click(multipleSelect.get(0)).click(multipleSelect.get(1)).click(multipleSelect.get(2)).build().perform();
			
			Select select = new Select(multiSelect);
			List<WebElement>selectedOptions =  select.getAllSelectedOptions();
			
			String s = "";
			boolean flag = false;
			for (WebElement option : selectedOptions) {
			s= s+" "+ option.getText();
			flag = true;
			}
			System.out.println(s);
			return flag;
			}
	// validating multiple check boxes are selected
		
	public void clickAllCheckbox() {
		for (WebElement checkbox : checkboxes) {
			checkbox.click();
		}
	}
	
	// validating whether all check boxes can be deselected
	public void deselectAllCheckedBox() {
		for (WebElement checkbox : checkboxes) {
			if(checkbox.isSelected()) {
				checkbox.click();
			}
		}
	}
	
	//clicking on open window btn under switch window example
	
	public void clickOpenwindow() {
		openWindowBtn.click();
	}
	
	// performing action on child window after clicking open window btn
	public void childWindowActions() {
		Set<String> allWindows = driver.getWindowHandles();
		for (String nextwindow : allWindows) {
			driver.switchTo().window(nextwindow);
		}
		home.click();
	}
	
	//closing the child window 
	public void closeChildWindow() {
		driver.close();
		}
	
	// getting number of windows opened
	public void windowsOpened() {
		int numberOfWindowsOpened =  driver.getWindowHandles().size();
		System.out.println(numberOfWindowsOpened);
	}
	
	// clicking on Alert btn under switch to alert
	public void clickAlert() {
		alertBtn.click();
	}
	
	//click on open tab btn , navigate to new tab 
	public void clickOpenTab()  {
		openTabButton.click();
		Set<String> allWindows = driver.getWindowHandles();
		for (String tab : allWindows) {
			driver.switchTo().window(tab);
			}
		}
	
	//click on the link 'JavaScript for beginners' in the new tab
	public void clickLink() {
		linkintab.click();
		
	}
	
	//Assertion
	
	//verifying a new tab is opened
	
	  public boolean isNewTab() { 
	  String currenturl = driver.getCurrentUrl();
	  String expected = "https://courses.letskodeit.com/courses";
	   boolean s =currenturl.equals(expected);
	  return s;
	   }
	 
	//verify on clicking link in the new tab opens the related page
	public boolean isdirectedtolinkedPage() {
	String actual =	driver.getCurrentUrl();
	String expected = "https://courses.letskodeit.com/courses/javascript-for-beginners";
	boolean s = actual.equals(expected);
	return s;
	}
	
	// verifying whether alert box is opened on clicking alert btn and has ok button
	public boolean isAlertOpened() {
	Alert alert= driver.switchTo().alert();
	String actualtext = alert.getText();
	alert.accept();
	System.out.println("Text in the Alert box : " + actualtext);
	String expectedText = "Hello , share this practice page and share your knowledge";
	boolean status = actualtext.equals(expectedText);
	return status;
	}
	
	
	
	// verifying the home link url on child window
	public boolean isHomePageOnChildwindow() {
	String actualUrl= driver.getCurrentUrl();
	String expectedUrl = "https://courses.letskodeit.com/";
	boolean status = actualUrl.equals(expectedUrl);
	return status;
	}
	
	//verify the radio btn is clicked
	
	public boolean isRadioBtnClicked(String btnName) {
		if(btnName.equalsIgnoreCase("honda")) {
			boolean isRadiobtnSelected = honda.isSelected();
			return isRadiobtnSelected;
		}else if(btnName.equalsIgnoreCase("BMW")) {
			boolean isRadiobtnSelected = BMW.isSelected();
			return isRadiobtnSelected;
		}else if (btnName.equalsIgnoreCase("Benz")) {
			boolean isRadiobtnSelected = Benz.isSelected();
			return isRadiobtnSelected;
		}
		return false;
	}
	//verify only one radio btn is clicked
	
	public int isOneRadioBtnSelected() {
		
		int count = 0;
		for (WebElement button : radioBtns) {
			if(button.isSelected()) {
				count++;
			}
		}
		System.out.println("Number of radio buttons clicked: " + count);
		return count;
	}
	
	//Verifying whether all checkboxes are selected
	
	public boolean isAllBoxChecked() {
		boolean flag = false;
	for (WebElement checkbox : checkboxes) {
		if(checkbox.isSelected()) {
			flag = true;
		}else
			flag = false;
	}
	System.out.println(flag);
	return flag;
	}
	
	//verifying whether all check boxes are unchecked
	public boolean isAllCheckboxesUncheck() {
		boolean flag = false;
		for (WebElement checkbox : checkboxes) {
			if(!checkbox.isSelected()) {
				flag = true;
			}else
				flag = false;
		}
		System.out.println(flag);
		return flag;
	}
	
	//validating whether on clicking open window btn opens a new window
	public boolean isNewWindowOpened() {
		int numberOfWindows = driver.getWindowHandles().size();
		boolean flag = false;
		if(numberOfWindows>1) {
			System.out.println("New window is opened");
			flag = true;
		}
		return flag;
	}
	
	//validating whether on child window is closed
		public boolean ischildWindowClosed() {
			int numberOfWindows = driver.getWindowHandles().size();
			boolean flag = false;
			if(numberOfWindows==1) {
				System.out.println("child window is closed");
				flag = true;
			}
			return flag;
		}
	
	// verifying the web table has row count of 4
		public boolean rowCount() {
		int rowcount =	totaltr.size();
		boolean flag = false;
		if(rowcount==4) {
			flag = true;
					System.out.println("Row Count : "+rowcount);
		}else
			flag = false;
		return flag;
		}
	
	
		// verifying the web table has column count of 3
				public boolean colCount() {
				int columncount =	td2.size();
				boolean flag = false;
				if(columncount==3) {
					flag = true;
							System.out.println("column count : "+columncount);
				}
				return flag;
				}
	
		//verifying the course has corresponding price
	public boolean webContent() {
		boolean flag = false;
		String p =  driver.findElement(By.xpath("//table[@id='product']//tr[2]//td[3]")).getText();
	int price =	Integer.parseInt(p);
		if(price ==35) {
			flag = true;
			}else
				flag = false;
		return flag;
		
			}
				
				
				
	
	
	
	
	
}
