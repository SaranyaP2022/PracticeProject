package testcases;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
 WebDriver driver;
 public static ExtentReports extentreport =new ExtentReports();
 public static ExtentSparkReporter spark;
 ExtentTest testcase;
	
 @BeforeTest
 public void beforeTest() throws IOException {
	 String filepath = System.getProperty("user.dir");
		spark = new ExtentSparkReporter(filepath+ "/ExtentReport.html");
		/*spark.config().setDocumentTitle("Automation report");
		spark.config().setReportName("Extent report for Letkodiet");*/
		
		/*final File CONF = new File("extentconfig.xml");
		spark.loadXMLConfig(CONF);*/
		
		final File CONF = new File("extentconfig.json");
		spark.loadJSONConfig(CONF);

		extentreport.attachReporter(spark);
 }
 
@BeforeClass
  @Parameters("crossbrowser")
  public void launchBrowser(String crossbrowser) {
	// launch browser
			if(crossbrowser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
		  		driver = new ChromeDriver();
				}else if (crossbrowser.equalsIgnoreCase("firefox")) {
					WebDriverManager.firefoxdriver().setup();
				 driver = new FirefoxDriver();
				 
				}
	  		
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

	  
  
  @AfterMethod
	public void getResult(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {
			testcase.log(Status.FAIL, result.getName());
			testcase.log(Status.FAIL, result.getThrowable());
			TakesScreenshot screenshot = (TakesScreenshot)driver;
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir")+"/FailedTestsScreenshots/"+result.getName()+".png";
			File destinationfile = new File(destination);
			FileUtils.copyFile(sourceFile,destinationfile);
			testcase.addScreenCaptureFromPath(destination);
		}
		else if(result.getStatus()==ITestResult.SKIP){
			testcase.log(Status.SKIP, "Test Case SKIPPED: " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			testcase.log(Status.PASS, "Test Case PASSED: " + result.getName());
		}
		}
	@AfterClass ()
	public void afterClass() {
		extentreport.flush();
	}
	
	
}
