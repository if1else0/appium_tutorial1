package appium.pages;

import appium.common.Helper;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class PageCommon {

    private Helper helper;

    //通过构造方法给Helper赋值，这样就可以使用Helper方法的方法
    public PageCommon(Helper helper){
        this.helper = helper;
    }

    //封装底部的各个tab页，通过uiautomatorviewer查看控件id

    public WebElement getHomeTab(){
        return helper.findById("net.oschina.app:id/nav_item_news");
    }

    public WebElement getMomentTab(){
        return helper.findById("net.oschina.app:id/nav_item_tweet");
    }

    public WebElement getPublishBtn(){
        return helper.findById("net.oschina.app:id/nav_item_tweet_pub");
    }

    public WebElement getExploreTab(){
        return helper.findById("net.oschina.app:id/nav_item_explore");
    }

    public WebElement getMySettingsTab(){
        return helper.findById("net.oschina.app:id/nav_item_me");
    }

    //封装点击各个tab页的方法
    public void goToHomeTab(){
        helper.click(getHomeTab());
    }

    public void goToMomentTab(){
        helper.click(getMomentTab());
    }

    public void clickPublishBtn(){
        helper.click(getPublishBtn());
    }

    public void goToExploreTab(){
        helper.click(getExploreTab());
    }

    public void goToMySettingsTab(){
        helper.click(getMySettingsTab());
    }

    //封装硬件返回的方法
    public void goBack(){
        helper.goBack();
    }

    public void switchToWebView(){
        Set<String> handlers = helper.getContentHandlers();
        for(String handler : handlers){
            System.out.println("==============="+handler);
        }
        helper.content("WEBVIEW_net.oschina.app");
    }

    public void switchToNative(){
        helper.content("NATIVE_APP");
    }

}
