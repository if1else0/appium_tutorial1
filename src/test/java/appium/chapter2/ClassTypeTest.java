package appium.chapter2;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

public class ClassTypeTest {
    private AppiumDriver<WebElement> driver;

    @BeforeMethod
    public void setUp() throws Exception {
        //构造被测试应用的路径
        File app = new File(System.getProperty("user.dir"), "AUT/osc.apk");
        //实例化DesiredCapabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //deviceName的值可以任意指定
        capabilities.setCapability("deviceName","My Device");
        //设置被测应用的绝对路径
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage","net.oschina.app");
        //设置启动类的信息，这个信息可以通过aapt dump bading apkname来获得
        capabilities.setCapability("appActivity", ".AppStart");
        //初始化AppiumDriver
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void testName() throws Exception {
        //等待控件出现，后续再介绍只能等待的方法
        Thread.sleep(4000);
        //定位到底部tab栏的父级控件
        WebElement parentView = driver.findElementById("net.oschina.app:id/fag_nav");
        //通过父控件去找子控件
        WebElement secondTab = parentView.findElements(By.className("android.widget.FrameLayout")).get(2);
        //点击第二个tab栏
        secondTab.click();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
