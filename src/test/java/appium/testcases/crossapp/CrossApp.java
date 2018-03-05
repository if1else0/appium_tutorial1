package appium.testcases.crossapp;

import appium.common.BasicTestCase;
import org.testng.annotations.Test;

public class CrossApp extends BasicTestCase {

    @Test
    public void testCrossApp() throws Exception {
        pageHelper.getPageNews().clickNewsItem(2);
        pageHelper.getPageNewsDetail().clickShareIcon();
        pageHelper.getPageNewsDetail().clickShareToQQOption();
        pageHelper.getPageNewsDetail().enterNameInQQLoginPage("277860602");
    }
}
