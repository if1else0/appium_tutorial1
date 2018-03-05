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

public class SameIDTest {

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
        //因为首页的标题ID也和列表里资讯标题的id是一样的，因此要取第二行的资讯标题相当于取第3行的标题，因为首页顶部的标题相当于第一行
        //index是从0开始的，所以第三行的index就是2
        //Appium提供driver.findElements方法来获取相同属性的控件集，然后在通过index来获取第几个
        WebElement title3 = driver.findElements(By.id("net.oschina.app:id/tv_title")).get(2);
        //将资讯标题打印出来
        System.out.println(title3.getText().toString());
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
