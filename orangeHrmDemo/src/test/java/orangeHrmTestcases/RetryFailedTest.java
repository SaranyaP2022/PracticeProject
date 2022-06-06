package orangeHrmTestcases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTest implements IRetryAnalyzer{
	int failedCount = 0;
	int limit = 2;
	public boolean retry(ITestResult result) {
		if(failedCount<limit) {
			failedCount++;
			return true;
		}
		return false;
	}

}
