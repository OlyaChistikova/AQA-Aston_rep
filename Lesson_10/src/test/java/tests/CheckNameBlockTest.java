package tests;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestPage;


public class CheckNameBlockTest extends BaseTest {

    @Test(description = "Check the name of the specified block")
    public void testCheckNameBlock() {
        TestPage testPage = new TestPage(driver);
        String normalizedNameBlock = StringUtils.normalizeSpace(testPage.checkNameBlock());
        Assert.assertEquals(normalizedNameBlock, "Онлайн пополнение без комиссии", "Blog 'Онлайн пополнение без комиссии' not found.");
    }
}
