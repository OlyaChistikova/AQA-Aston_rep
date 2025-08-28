package tests;

import helpers.ConfProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestPage;


public class CheckLinkTest extends BaseTest {

    @Test(description = "Checking the operation of the 'More about the service' link")
    public void testCheckLink() {
        TestPage testPage = new TestPage(driver);
        testPage.clickAboutServiceLink();
        Assert.assertEquals(driver.getCurrentUrl(), ConfProperties.getProperty("linkAboutService"));
        driver.navigate().back();
    }
}
