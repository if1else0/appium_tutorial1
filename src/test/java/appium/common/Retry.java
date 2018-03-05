package appium.common;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    //定义重跑的次数
    int retryCount = 1;
    int index = 1;

    //return true的时候会重跑，return false则不会
    public boolean retry(ITestResult iTestResult) {
        if(index <= retryCount){
            index++;
            return true;
        }
        return false;
    }
}
