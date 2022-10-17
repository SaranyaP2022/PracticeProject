package testcase;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class TC_001_InValidLogin {
 
	WebDriver driver;
	
	 @BeforeClass
	  public void beforeClass() {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		 
	  }
	
	
	@Test(dataProvider = "dp")
  public void TC_001_InValidLogin(String username, String pswd) {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		//username
		driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys(username);
		//password
		driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys(pswd);
		//login button
		driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
		
  }

	
	
	//Object[][] data= null;
	//{
	//{"Admin", "admin123"}
	//};
	
	
	public String[][] getExcelData() throws BiffException, IOException {
		FileInputStream excel = new FileInputStream("C:\\Users\\HP User\\Desktop\\testData.xls");
		Workbook workbook = Workbook.getWorkbook(excel);
		Sheet sheet = workbook.getSheet(0);
		int rowCount = sheet.getRows();
		int colCount = sheet.getColumns();
		
		String testData[][]= new String[rowCount-1][colCount];
		for(int i = 1; i<rowCount; i++) {
			for(int j = 0; j<colCount; j++) {
			testData[i-1][j]= sheet.getCell(j, i).getContents();
			}
		}
		return testData;
		
	}
	
	
	@DataProvider
  public Object[][] dp() throws BiffException, IOException {
		Object[][]	data = getExcelData();
    return data;
  }
 

  @AfterClass
  public void afterClass() {
  }

}
