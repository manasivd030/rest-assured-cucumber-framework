package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retrycount = 0;
    private int maxretrycount = 2;

    @Override
    public boolean retry(ITestResult result)
    {
        System.out.printf("Retry count: %d %s%n",retrycount,result.getMethod().getDescription());
        if(retrycount < maxretrycount)
        {
            retrycount++;
            return true;
        }
        return false;
    }
}
