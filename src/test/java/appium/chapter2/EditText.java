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

public class EditText {

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
        //通过添加如下设置来支持中文输入
        capabilities.setCapability("unicodeKeyboard",true);
        //初始化AppiumDriver
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void testName() throws Exception {
        Thread.sleep(3000);
        //点击底部"我的"tab页
        driver.findElement(By.id("net.oschina.app:id/nav_item_me")).click();
        //点击我的登录按钮
        driver.findElement(By.id("net.oschina.app:id/iv_portrait")).click();
        //通过ID定位到输入框控件
        WebElement name = driver.findElement(By.id("net.oschina.app:id/et_username"));
        //输入文本
        name.sendKeys("世界你好！");
        Thread.sleep(3000);
        //清空输入框
        name.clear();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
