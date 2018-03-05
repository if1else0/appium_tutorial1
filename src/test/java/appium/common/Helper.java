package appium.common;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.logging.Handler;

public class Helper {
    private AppiumDriver driver;
    //设置默认超时时间
    private final long DEFAULT_TIMEOUT = 5;
    private final long LONG_TIMEOUT = 10;

    //通过构造方法来初始化AppiumDriver对象引用，这样才能获得Appium提供的方法
    public  Helper(AppiumDriver driver){
        this.driver = driver;
    }

    //封装智能等待的方法，取代Thread.sleep()，这样可以节省时间，默认等待5秒
    public void waitForElement(By by){
        WebDriverWait wait = new WebDriverWait(driver,DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //如果需要等待比较长的时候可以调用这个方法
    public void waitForElementForLongTime(By by){
        WebDriverWait wait = new WebDriverWait(driver,LONG_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * 封装常见定位方法
     */

    //按id定位
    public WebElement findById(String id){
        waitForElement(By.id(id));
        return driver.findElement(By.id(id));
    }

    //多个相同id的定位方法，index从0开始
    public WebElement findById(String id, int index){
        waitForElement(By.id(id));
        return (WebElement) driver.findElements(By.id(id)).get(index - 1);
    }

    //按控件类型定位
    public WebElement findByClassName(String clsName,int index){
        waitForElement(By.className(clsName));
        return  (WebElement) driver.findElements(By.className(clsName)).get(index - 1);
    }

    //按文本定位
    public WebElement findByText(String text){
        waitForElement(By.xpath("//*[@text='"+text+"']"));
        return driver.findElement(By.xpath("//*[@text='"+text+"']"));
    }

    //多个相同文本，可通过这个方法去获取
    public WebElement findByText(String text,int index){
        waitForElement(By.xpath("//*[@text='"+text+"']"));
        return (WebElement) driver.findElements(By.xpath("//*[@text='"+text+"']")).get(index - 1);
    }

    //常见控件的定位方式
    //控件点击
    public void click(WebElement element){
        System.out.println("执行控件点击操作--->");
        element.click();
    }

    //控件输入
    public void enterText(WebElement element,String text){
        System.out.println("执行输入操作，输入文本为"+text+"--->");
        element.sendKeys(text);
    }

    public void clearText(WebElement element){
        System.out.println("执行清空输入框操作--->");
        element.clear();
    }

    //清空
    public void enterTextWithPreClear(WebElement element,String text){
        clearText(element);
        enterText(element,text);
    }

    //获取文本
    public String  getText(WebElement element){
        System.out.println("执行如下操作：获取控件文本--->");
        return  element.getText();
    }

    //硬件返回
    public void goBack(){
        driver.navigate().back();
    }

    //webview相关操作的API
    //通过xpath定位
    public WebElement findByXpath(String xpath){
        return driver.findElementByXPath(xpath);
    }

    //获取当前的句柄
    public Set<String> getContentHandlers(){
        return driver.getContextHandles();
    }

    //切换执行环境
    public void content(String name){
        driver.context(name);
    }

}
