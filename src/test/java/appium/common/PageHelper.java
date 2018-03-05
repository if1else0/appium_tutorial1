package appium.common;

import appium.pages.*;

public class PageHelper {
    private Helper helper;
    private PageCommon pageCommon;
    private PageLogin pageLogin;
    private PageMySettings pageMySettings;
    private PageSettings pageSettings;
    private PageNews pageNews;
    private PageNewsDetail pageNewsDetail;
    private PageFavoritesList pageFavoritesList;
    private PageAbout pageAbout;


    public PageHelper(Helper helper){
        this.helper = helper;
    }

    public PageCommon getPageCommon() {
        if(pageCommon == null){
            pageCommon = new PageCommon(helper);
        }
        return pageCommon;
    }

    public PageLogin getPageLogin() {
        if(pageLogin == null){
            pageLogin = new PageLogin(helper);
        }
        return pageLogin;
    }

    public PageMySettings getPageMySettings() {
        if(pageMySettings == null){
            pageMySettings = new PageMySettings(helper);
        }
        return pageMySettings;
    }

    public PageSettings getPageSettings() {
        if(pageSettings == null){
            pageSettings = new PageSettings(helper);
        }
        return pageSettings;
    }

    public PageNews getPageNews() {
        if(pageNews == null){
            pageNews = new PageNews(helper);
        }
        return pageNews;
    }

    public PageNewsDetail getPageNewsDetail() {
        if(pageNewsDetail == null){
            pageNewsDetail = new PageNewsDetail(helper);
        }
        return pageNewsDetail;
    }

    public PageFavoritesList getPageFavoritesList() {
        if(pageFavoritesList == null){
            pageFavoritesList = new PageFavoritesList(helper);
        }
        return pageFavoritesList;
    }

    public PageAbout getPageAbout(){
        if(pageAbout == null){
            pageAbout = new PageAbout(helper);
        }
        return pageAbout;
    }

}
