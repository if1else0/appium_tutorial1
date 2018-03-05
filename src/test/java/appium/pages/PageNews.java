package appium.pages;

import appium.common.Helper;
import org.openqa.selenium.WebElement;

public class PageNews {
    private Helper helper;

    public PageNews(Helper helper){
        this.helper = helper;
    }

    //获取资讯标题的方法，index是指第几个资讯标题
    public WebElement getNewsTitleTextView(int index){
        return helper.findById("net.oschina.app:id/tv_title",index );
    }

    //点击第几个资讯标题的方法
    public void clickNewsItem(int index){
        helper.click(getNewsTitleTextView(index));
    }

    //获取第几个资讯标题文本的方法
    public String getNewsTitle(int index){
        return helper.getText(getNewsTitleTextView(index));
    }

}
