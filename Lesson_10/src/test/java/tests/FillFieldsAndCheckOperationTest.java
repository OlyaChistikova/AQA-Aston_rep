package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestPage;


public class FillFieldsAndCheckOperationTest extends BaseTest {

    @DataProvider(name = "sumHolderValues")
    public Object[][] sumHolderValues() {
        return new Object[][]{
                {"100", true}, // Позитивный тест
                {"0", false}, // Негативный тест
                {"-50", true}, // Позитивный тест (минус исчезает при вводе в поле)
                {"abc", false}, // Негативный тест
                {"200", true} // Позитивный тест
        };
    }

    @DataProvider(name = "emailHolderValues")
    public Object[][] emailHolderValues() {
        return new Object[][]{
                {"username@domain.com", true}, // Позитивный тест
                {"user.name@domain.com", true}, // Позитивный тест
                {"user-name@domain.com", true}, // Позитивный тест
                {"username@domain.co.in", true}, // Позитивный тест
                {".user.name@domain.com", false}, // Негативный тест
                {"", true} //Позитивный тест
        };
    }

    @Test
    public void testFillSelectHolder() {
        TestPage testPage = new TestPage(driver);
        Assert.assertNotNull(testPage.fillSelectHolder(), "The field was not filled in");
        Assert.assertEquals(testPage.fillSelectHolder().getText(), "Услуги связи");
    }

    @Test(dependsOnMethods = {"testFillSelectHolder"})
    public void testFillNumberHolder() {
        TestPage testPage = new TestPage(driver);
        Assert.assertNotNull(testPage.fillNumberHolder(), "The field was not filled in");
    }

    @Test(dependsOnMethods = {"testFillNumberHolder"}, dataProvider = "sumHolderValues")
    public void testFillSumHolder(String value, boolean shouldPass) {
        TestPage testPage = new TestPage(driver);

        String enteredValue = testPage.getEnteredValue(testPage.fillSumHolder(value, shouldPass));
        Assert.assertNotNull(enteredValue);

        Assert.assertNotNull(testPage.fillSumHolder(value, shouldPass), "The field was not filled in");
    }

    @Test(dataProvider = "emailHolderValues", dependsOnMethods = {"testFillSumHolder"})
    public void testFillEmailHolder(String emailAddress, boolean shouldMatch) {
        TestPage testPage = new TestPage(driver);

        String enteredValue = testPage.getEnteredValue(testPage.fillEmailHolder(emailAddress));
        Assert.assertNotNull(enteredValue);

        Assert.assertEquals(testPage.patternMatches(emailAddress), shouldMatch, "Email validation failed for: " + emailAddress);
    }

    @Test(dependsOnMethods = {"testFillEmailHolder"})
    public void testCheckOperationButton() {
        TestPage testPage = new TestPage(driver);
        testPage.clickContinueButton();

        Assert.assertNotNull(testPage.clickContinueButton(), "Button not found");
    }

    @Test(dependsOnMethods = {"testCheckOperationButton"})
    public void testCheckPayDescriptionText() {
        TestPage testPage = new TestPage(driver);
        testPage.waitAndSwitchToFrame();

        String number = "375297777777";
        // Проверка отображения номера телефона
        Assert.assertNotNull(testPage.getPayDescriptionText(), "The payment description element was not found");
        String payDescriptionText = testPage.getPayDescriptionText().getText();
        Assert.assertEquals(payDescriptionText, "Оплата: Услуги связи Номер:" + number,
                "The text of the payment description does not match what is expected");
    }

    @Test(dependsOnMethods = {"testCheckPayDescriptionText"})
    public void testCheckPayDescriptionCost() {
        TestPage testPage = new TestPage(driver);

        String sum = "200";
        // Проверка отображения суммы
        Assert.assertNotNull(testPage.getPayDescriptionCost(), "The payment description element was not found");
        String payDescriptionCost = testPage.getPayDescriptionCost().getText();
        Assert.assertEquals(payDescriptionCost, sum + ".00 BYN",
                "The text of the payment description does not match what is expected");
    }

    @Test(dependsOnMethods = {"testCheckPayDescriptionCost"})
    public void testCheckPayDescriptionCostButton() {
        TestPage testPage = new TestPage(driver);

        String sum = "200";
        // Проверка отображения суммы на кнопке
        Assert.assertNotNull(testPage.getPayDescriptionCostButton(), "The payment description element was not found");
        String payDescriptionCostButton = testPage.getPayDescriptionCostButton().getText();
        Assert.assertEquals(payDescriptionCostButton, "Оплатить " + sum + ".00 BYN",
                "The text of the payment description does not match what is expected");
    }

    @Test(dependsOnMethods = {"testCheckPayDescriptionCostButton"})
    public void testCheckFieldLabels() {
        TestPage testPage = new TestPage(driver);

        // Проверка полей на соответствие сообщений
        Assert.assertEquals(testPage.checkCreditCard().getText(), "Номер карты");
        Assert.assertEquals(testPage.checkExpirationDate().getText(), "Срок действия");
        Assert.assertEquals(testPage.checkCvc().getText(), "CVC");
        Assert.assertEquals(testPage.checkCcName().getText(), "Имя и фамилия на карте");
    }

    @Test(dependsOnMethods = {"testCheckFieldLabels"})
    public void testCheckLogos() {
        TestPage testPage = new TestPage(driver);

        // Проверка логотипов на соответствие сообщений
        Assert.assertFalse(testPage.getPayIcons().isEmpty(), "Logos not found in container");
        for (WebElement logo : testPage.getPayIcons()) {
            String src = logo.getAttribute("src");
            Assert.assertNotNull(src, "The logo does not have the src attribute");
            Assert.assertFalse(src.isEmpty(), "The src attribute of the logo is empty");
        }
    }
}
