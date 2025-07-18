package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestPage;

public class CheckPlaceHoldersTest extends BaseTest{

    @DataProvider(name = "getHolderValues")
    public Object[][] getHolderValues() {
        return new Object[][] {
                { "Услуги связи", "Номер телефона"},
                { "Домашний интернет", "Номер абонента" },
                { "Рассрочка", "Номер счета на 44" },
                { "Задолженность", "Номер счета на 2073"}
        };
    }

    @Test(dataProvider = "getHolderValues", description = "Check the labels in the blank fields of each payment option")
    public void testPayConnectionPlaceHolder(String nameOption, String textNumber) {
        TestPage testPage = new TestPage(driver);
        String option = testPage.getEnteredValue(testPage.checkPayConnection(nameOption));
        Assert.assertEquals(option,nameOption, "The messages don't match");

        String placeholderNumber = testPage.checkNumberPayConnection(testPage.checkPayConnection(nameOption));
        Assert.assertEquals(placeholderNumber, textNumber, "The messages don't match");
    }
}
