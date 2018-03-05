package appium.pages;

import appium.common.Helper;
import org.openqa.selenium.WebElement;

public class PageLogin {
    private Helper helper;

    public PageLogin(Helper helper){
        this.helper = helper;
    }

    //获取用户名输入框
    public WebElement getName(){
        return helper.findById("net.oschina.app:id/et_username");
    }

    //获取密码输入框
    public WebElement getPwd(){
        return helper.findById("net.oschina.app:id/et_password");
    }

    //获取登录按钮
    public WebElement getLoginBtn(){
        return helper.findById("net.oschina.app:id/btn_login");
    }

    //清空用户名输入框
    public void clearName(){
        helper.clearText(getName());
    }

    //清空密码输入框
    public void clearPwd(){
        helper.clearText(getPwd());
    }

    //输入用户名
    public void enterName(String name){
        helper.enterText(getName(),name);
    }

    //输入密码
    public void enterPwd(String password){
        helper.enterText(getPwd(),password);
    }

    //点击登录按钮
    public void clickLoginBtn(){
        helper.click(getLoginBtn());
    }

    //封装登录的方法，只需要提供用户名和密码
    public void login(String name,String password){
        clearName();
        enterName(name);
        clearPwd();
        enterPwd(password);
        clickLoginBtn();
    }

    //判断是否登录界面打开的方法
    public boolean isLoginScreenOpened(){
        boolean result = false;
        if(getLoginBtn() != null){
            return getLoginBtn().isDisplayed();
        }
        return result;
    }
}
