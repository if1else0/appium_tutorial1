package appium.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.URL;

public class BasicTestCase {
    //声明静态的对象引用driver
    static AppiumDriver driver;
    private Helper helper;
    public PageHelper pageHelper;

    @BeforeMethod
    public void setUp() throws Exception {
        File app = new File(System.getProperty("user.dir"), "AUT/osc.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "My Android Device");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "net.oschina.app");
        capabilities.setCapability("appActivity", "net.oschina.app.AppStart");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("unicodeKeyboard", true);
        File chromeDriverPath = new File(System.getProperty("user.dir"));
        capabilities.setCapability("chromedriverExecutable",chromeDriverPath.getAbsolutePath()+"/chromedriver.exe");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        helper = new Helper(driver);
        pageHelper = new PageHelper(helper);
        //跳转到我的设置页面
        pageHelper.getPageCommon().goToMySettingsTab();
        //判断是否是登录状态，是的话就退出，不是的话就不做处理
        if("aotu12345aotu".equals(pageHelper.getPageMySettings().getNickName())){
            pageHelper.getPageMySettings().clickSettingsBtn();
            pageHelper.getPageSettings().clickLogout();
        }
        //回到首页，每个测试脚本的入口就是首页
        pageHelper.getPageCommon().goToHomeTab();
    }


    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    //添加获取driver对象引用的方法

    public static AppiumDriver getDriver(){
        return  driver;
    }


}
