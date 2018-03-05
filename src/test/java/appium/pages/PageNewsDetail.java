package appium.pages;

import appium.common.Helper;
import org.openqa.selenium.WebElement;

public class PageNewsDetail {
    private Helper helper;

    public PageNewsDetail(Helper helper){
        this.helper = helper;
    }

    //封装收藏按钮
    public WebElement getAddToFavoritesBtn(){
        return helper.findById("net.oschina.app:id/iv_fav");
    }

    //封装底部的分享按钮
    public WebElement getShareIcon(){
        return helper.findById("net.oschina.app:id/iv_share");
    }

    //封装QQ分享项控件
    public WebElement getQQShareOption(){
        return helper.findByText("QQ");
    }

    //封装QQ登录页面的用户名输入框
    public WebElement getUserNameInQQLoginPage(){
        return helper.findById("u");
    }

    //封装点击底部分享按钮
    public void clickShareIcon(){
        helper.click(getShareIcon());
    }

    //点击收藏按钮的方法
    public void clickAddToFavorites(){
        helper.click(getAddToFavoritesBtn());
    }

    //封装点击分享到QQ的操作
    public void clickShareToQQOption(){
        helper.click(getQQShareOption());
    }

    //封装输入QQ用户名输入框的方法
    public void enterNameInQQLoginPage(String name ){
        helper.enterText(getUserNameInQQLoginPage(),name);
    }

    //根据传递的xpath查找第一段的控件
    public WebElement getWebViewFirstLine(String xpath){
        return helper.findByXpath(xpath);
    }

    //获取第一段控件的内容
    public String getWebViewFirstLineContent(String xpath){
        return helper.getText(getWebViewFirstLine(xpath));
    }
}
