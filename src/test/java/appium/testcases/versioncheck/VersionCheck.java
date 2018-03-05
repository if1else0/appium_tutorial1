package appium.testcases.versioncheck;

import appium.common.BasicTestCase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class VersionCheck extends BasicTestCase {

    //这个脚本是故意让其执行失败的
    @Test
    public void testVersionCheck() throws Exception {
        pageHelper.getPageCommon().goToMySettingsTab();
        pageHelper.getPageMySettings().clickSettingsBtn();
        pageHelper.getPageSettings().clickAbout();
        //获取实际界面上的版本号文本
        String actualVersion = pageHelper.getPageAbout().getVersion();
        //跟预期的版本号对比v2.9.1(1609281026)
        assertEquals(actualVersion,"v2.9.1(1609281026) ");
    }

}
