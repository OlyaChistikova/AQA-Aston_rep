package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestPage;

public class CheckLinkTest extends BaseTest {

    @Test(description = "Checking the operation of the 'More about the service' link")
    public void testCheckLink() {
        TestPage testPage = new TestPage(driver);
        testPage.clickAboutServiceLink();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/");
        driver.navigate().back();
    }
}
