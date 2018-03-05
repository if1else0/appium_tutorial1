package appium.pages;

import appium.common.Helper;
import org.openqa.selenium.WebElement;

public class PageMySettings {

    private Helper helper;

    public PageMySettings(Helper helper){
        this.helper = helper;
    }

    //抽取顶部设置按钮项
    public WebElement getSetingsBtn(){
        return  helper.findById("net.oschina.app:id/iv_logo_setting");
    }

    //抽取登录按钮项
    public WebElement getLoginIcon(){
        return helper.findById("net.oschina.app:id/iv_portrait");
    }

    //抽取我的消息列表项
    public WebElement getMyMsgItem(){
        return  helper.findById("net.oschina.app:id/rl_message");
    }

    //抽取我的博客列表项
    public WebElement getMyBlogItem(){
        return  helper.findById("net.oschina.app:id/rl_blog");
    }

    //抽取我的活动列表项
    public WebElement getMyActivityItem(){
        return  helper.findById("net.oschina.app:id/rl_info_avtivities");
    }

    //抽取我的团队列表项
    public WebElement getMyTeamItem(){
        return  helper.findById("net.oschina.app:id/rl_team");
    }

    //获取昵称控件
    public WebElement getNickNameTextView(){
        return helper.findById("net.oschina.app:id/tv_nick");
    }

    //后期收藏布局
    public WebElement getFavoritesLayout(){
        return helper.findById("net.oschina.app:id/ly_favorite");
    }

    //封装各个点击方法
    public  void clickMyMsgItem(){
        helper.click(getMyMsgItem());
    }

    public void clickMyBlogItem(){
        helper.click(getMyBlogItem());
    }

    public void clickMyActivityItem(){
        helper.click(getMyActivityItem());
    }

    public void clickMyTeamItem(){
        helper.click(getMyTeamItem());
    }

    public void clickLoginIcon(){
        helper.click(getLoginIcon());
    }

    public void clickSettingsBtn(){
        helper.click(getSetingsBtn());
    }

    public void clickFavoritesLayout(){
        helper.click(getFavoritesLayout());
    }

    //封装获取昵称文本的方法
    public String getNickName(){
        return helper.getText(getNickNameTextView());
    }

}
