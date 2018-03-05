package appium.listeners;

import appium.common.BasicTestCase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener{

    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {

    }

    public void onTestFailure(ITestResult iTestResult) {
        //构造输出对象
        File srcFile = BasicTestCase.getDriver().getScreenshotAs(OutputType.FILE);
        //拼接错误截图的名称（类名+方法名）
        String scriptName = iTestResult.getMethod().getRealClass().getSimpleName() + "." + iTestResult.getMethod().getMethodName();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        //设置截图存放路径
        String destDir = "screenshots";
        //拼接最后的错误截图名称（类名+方法名+时间戳.png）
        String fileName =  scriptName + dateFormat.format(new Date()) + ".png";
        try {
            FileUtils.copyFile(srcFile,new File(destDir + "/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
