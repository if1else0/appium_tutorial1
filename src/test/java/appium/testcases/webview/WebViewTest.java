package appium.testcases.webview;

import appium.common.BasicTestCase;
import org.testng.annotations.Test;

public class WebViewTest extends BasicTestCase {

    @Test
    public void testWebView() throws Exception {
        //点击首页第1行
        pageHelper.getPageNews().clickNewsItem(2);
        Thread.sleep(3000);
        pageHelper.getPageCommon().switchToWebView();
        String content = pageHelper.getPageNewsDetail().getWebViewFirstLineContent("/html/body/div/p[1]");
        System.out.println(content);
    }
}
