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

public class IDTest {

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
        Thread.sleep(3000);
        //通过driver.findElementById方法可以将uiatuomatorviewer获取到的id拿来进行定位
         WebElement publishBtn = driver.findElementById("net.oschina.app:id/nav_item_tweet_pub");
         //跟上面的写法是等价的
//         WebElement publishBtn = driver.findElement(By.id("net.oschina.app:id/nav_item_tweet_pub"));
         //对这个控件进行点击操作
         publishBtn.click();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
