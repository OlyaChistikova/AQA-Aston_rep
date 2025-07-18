package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestPage;


public class CheckNameBlockTest extends BaseTest{

    @Test(description = "Check name block")
    public void testCheckNameBlock() {
        TestPage testPage = new TestPage(driver);
        Assert.assertNotNull( testPage.сheckNameBlock(), "Blog 'Онлайн пополнение без комиссии' not found.");
    }
}
