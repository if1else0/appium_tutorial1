package appium.pages;

import appium.common.Helper;
import org.openqa.selenium.WebElement;

public class PageSettings {
    private Helper helper;

    public PageSettings(Helper helper){
        this.helper = helper;
    }

    //抽取退出选项
    public WebElement getLogoutItem(){
        return helper.findById("net.oschina.app:id/rl_cancle");
    }

    //抽取关于选项
    public WebElement getAboutItem(){
        return helper.findById("net.oschina.app:id/rl_about");
    }

    //点击退出
    public void clickLogout(){
        helper.click(getLogoutItem());
    }

    //点击关于
    public void clickAbout(){
        helper.click(getAboutItem());
    }

}