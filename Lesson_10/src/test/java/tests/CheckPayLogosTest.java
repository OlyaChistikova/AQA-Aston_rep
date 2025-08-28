package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestPage;


public class CheckPayLogosTest extends BaseTest{

    @Test(description = "Check the availability of payment logos")
    public void testCheckPayLogos() {
        TestPage testPage = new TestPage(driver);
        testPage.checkPayLogos();
//        Assert.assertFalse(testPage.checkPayLogos().isEmpty(),  "Payment system logos not found.");
    }
}
