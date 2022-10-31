package testcase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DatadrivenUsingPOI {
	static List<String> userNameList = new ArrayList<String>();
	static List<String> passwordList = new ArrayList<String>();
	
	public void readExcel() throws IOException {
		FileInputStream excel = new FileInputStream("./dataForTest\\testData1.xlsx");
		Workbook workbook = new XSSFWorkbook(excel);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		while(rowIterator.hasNext()) {
		Row rowValue =	rowIterator.next();
		Iterator<Cell> columnIterator =	rowValue.iterator();
		int i = 2;
		while(columnIterator.hasNext()) {
			if(i%2==0) {
				//Cell userName = columnIterator.next();
				userNameList.add(columnIterator.next().toString());
			}else {
				//Cell password = columnIterator.next();
				passwordList.add(columnIterator.next().getStringCellValue());
			}
		i++;
		}
		}
	}
	
	public void login(String username, String pswd) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		 driver.get("https://opensource-demo.orangehrmlive.com/");
			//username
			driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys(username);
			//password
			driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys(pswd);
			//login button
			driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
			
		 
	}

	public void executeTest() {
		for(int i = 0; i<userNameList.size();i++) {
			login(userNameList.get(i), passwordList.get(i) );
		}
		
	}
	public static void main(String[] args) throws IOException {
		
DatadrivenUsingPOI usingPOI = new DatadrivenUsingPOI();
usingPOI.readExcel();
System.out.println(userNameList);
usingPOI.executeTest();
	}

}
