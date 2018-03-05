package appium.testcases.favorites;

import appium.common.BasicTestCase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class AddToFavorites extends BasicTestCase {

    @Test
    public void testAddToFavorites() throws Exception {
        //跳转到我的设置页面
        pageHelper.getPageCommon().goToMySettingsTab();
        //登录
        pageHelper.getPageMySettings().clickLoginIcon();
        pageHelper.getPageLogin().login("735723619@qq.com","12345678");
        //回到首页
        pageHelper.getPageCommon().goToHomeTab();
        //获取第二行资讯标题，因为顶部的标题栏id和资讯标题的id一样，所以资讯类别栏第一个相当于第二个
        // index是从0开始,定位方式封装的方法里会自减1
        String title = pageHelper.getPageNews().getNewsTitle(2);
        //点击第一个资讯标题，进入资讯详情页面
        pageHelper.getPageNews().clickNewsItem(2);
        //点击收藏的按钮
        pageHelper.getPageNewsDetail().clickAddToFavorites();
        Thread.sleep(1000);
        //通过硬件返回
        pageHelper.getPageCommon().goBack();
        //跳转到我的设置页面
        pageHelper.getPageCommon().goToMySettingsTab();
        //点击进入收藏的列表页面
        pageHelper.getPageMySettings().clickFavoritesLayout();
        //打印出收藏的资讯标题，
        System.out.println(title);
        //要导入testng的包
        assertEquals(title,pageHelper.getPageFavoritesList().getFavoritesTitle(1));
    }

}
