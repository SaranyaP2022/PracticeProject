package rerun.failedtest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyse implements IRetryAnalyzer {

	int failedCount = 0;
	int limit = 2;
	
	 @Override public boolean retry(ITestResult result) {
		 if(failedCount<limit) {
			 failedCount++;
			 return true;
		 }
	  
	  return false;
	 }
	 

}
