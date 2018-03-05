package appium.testcases.login;

import appium.common.BasicTestCase;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

//继承抽取的父类，主要关注于具体的脚本实现即可
public class LoginPermissionCheck extends BasicTestCase {

    @Test
    public void testName() throws Exception {
        //通过导航类进行切换
        pageHelper.getPageCommon().goToMySettingsTab();
        //获取我的设置页面Page类，调用点击我的消息列表项的方法
        pageHelper.getPageMySettings().clickMyMsgItem();
        check();

        pageHelper.getPageMySettings().clickMyMsgItem();
        check();


        pageHelper.getPageMySettings().clickMyActivityItem();
        check();

        pageHelper.getPageMySettings().clickMyTeamItem();
        check();
    }

    //每个页面的校验都一致，所以可以进行简单的封装
    public void check() {
        //调用testng的断言，断定登录页面被打开
        assertTrue(pageHelper.getPageLogin().isLoginScreenOpened());
        //调用硬件放回回到我的设置页面
        pageHelper.getPageCommon().goBack();
    }
}
