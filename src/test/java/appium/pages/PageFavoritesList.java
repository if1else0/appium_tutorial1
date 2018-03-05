package appium.pages;

import appium.common.Helper;
import org.openqa.selenium.WebElement;

public class PageFavoritesList {
    private Helper helper;

    public PageFavoritesList(Helper helper){
        this.helper = helper;
    }

    //获取指定的收藏资讯标题控件
    public WebElement getFavoritesTitleTextView(int index){
        return helper.findById("net.oschina.app:id/tv_favorite_title",index );
    }

    //获取指定收藏列表资讯标题文本值
    public String getFavoritesTitle(int index){
        return helper.getText(getFavoritesTitleTextView(index));
    }
}
