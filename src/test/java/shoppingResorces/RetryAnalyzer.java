package shoppingResorces;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	int count = 0;
	int maxtry = 2;
	
	@Override
	public boolean retry(ITestResult result) {
		if(count<maxtry) {
			count++;
			return true;
		}
		
		// TODO Auto-generated method stub
		return false;
	}
	
}
