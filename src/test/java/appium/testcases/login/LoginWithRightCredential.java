package appium.testcases.login;


import appium.common.BasicTestCase;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class LoginWithRightCredential extends BasicTestCase {

    @Test
    public void testLoginWithRightCredential() throws Exception {
        //切换到我的设置页面
        pageHelper.getPageCommon().goToMySettingsTab();
        //点击登录按钮
        pageHelper.getPageMySettings().clickLoginIcon();
        //登录
        pageHelper.getPageLogin().login("735723619@qq.com", "12345678");
        //校验昵称为aotu12345aotu，如果是的话代表成功登录，不是就是登录校验失败
        assertEquals("aotu12345aotu", pageHelper.getPageMySettings().getNickName());
    }
}
