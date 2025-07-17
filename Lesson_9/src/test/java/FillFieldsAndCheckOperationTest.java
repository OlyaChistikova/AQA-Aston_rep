import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.regex.Pattern;

public class FillFieldsAndCheckOperationTest extends BaseTest{

    @DataProvider(name = "sumHolderValues")
    public Object[][] sumHolderValues() {
        return new Object[][] {
                { "100", true }, // Позитивный тест
                { "0", false }, // Негативный тест
                { "-50", true }, // Позитивный тест (минус исчезает при вводе в поле)
                { "abc", false }, // Негативный тест
                { "200", true } // Позитивный тест
        };
    }

    @DataProvider(name = "emailHolderValues")
    public Object[][] emailHolderValues() {
        return new Object[][] {
                { "username@domain.com", true}, // Позитивный тест
                { "user.name@domain.com", true}, // Позитивный тест
                { "user-name@domain.com", true}, // Позитивный тест
                { "username@domain.co.in", true}, // Позитивный тест
                { ".user.name@domain.com", false}, // Негативный тест
                { "", true} //Позитивный тест
        };
    }

    @Test
    public void testFillSelectHolder() {
        WebElement selectHolder = driver.findElement(By.className("select__header"));
        selectHolder.click();
        WebElement payConnection = driver.findElement(By.xpath("//li[@class='select__item active']"));
        payConnection.click();
        Assert.assertNotNull(payConnection, "The field was not filled in");
    }

    @Test(dependsOnMethods = { "testFillSelectHolder" })
    public void testFillNumberHolder() {
        WebElement numberHolder = driver.findElement(By.id("connection-phone"));
        numberHolder.click();
        numberHolder.sendKeys("297777777");
        Assert.assertNotNull(numberHolder, "The field was not filled in");
    }

    @Test(dependsOnMethods = { "testFillNumberHolder" }, dataProvider = "sumHolderValues")
    public void testFillSumHolder(String value, boolean shouldPass) {
        WebElement sumHolder = driver.findElement(By.id("connection-sum"));
        sumHolder.click();
        sumHolder.clear();
        sumHolder.sendKeys(value);

        String enteredValue = sumHolder.getAttribute("value");
        Assert.assertNotNull(enteredValue);

        if (shouldPass){
            try {
                int number = Integer.parseInt(enteredValue);
                Assert.assertTrue(number > 0, "The field should contain a value greater than 0");
            } catch (NumberFormatException e) {
                Assert.fail("The entered value is not a valid number: " + enteredValue);
            }
        } else {
            try {
                int number = Integer.parseInt(enteredValue);
                Assert.assertFalse(number > 0, "The field should not contain a value greater than 0");
            } catch (NumberFormatException e) {
                Assert.assertFalse(false);
            }
        }

        Assert.assertNotNull(sumHolder, "The field was not filled in");
    }

    @Test(dataProvider = "emailHolderValues", dependsOnMethods = { "testFillSumHolder" })
    public void testFillEmailHolder(String emailAddress, boolean shouldMatch) {
        WebElement emailHolder = driver.findElement(By.id("connection-email"));
        emailHolder.click();
        emailHolder.clear();
        emailHolder.sendKeys(emailAddress);

        boolean matched = patternMatches(emailAddress);
        Assert.assertEquals(matched, shouldMatch, "Email validation failed for: " + emailAddress);
    }

    @Test(dependsOnMethods = { "testFillEmailHolder" })
    public void testCheckOperationButton() {
        WebElement buttonNext = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        buttonNext.click();

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));
        WebElement payDescription = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay-description__text']/span")));
        Assert.assertNotNull(payDescription, "The payment description element was not found");
        String payDescriptionText = payDescription.getText();
        Assert.assertEquals(payDescriptionText, "Оплата: Услуги связи Номер:375297777777",
                "The text of the payment description does not match what is expected");
    }

    public static boolean patternMatches(String emailAddress) {
        if (emailAddress.isEmpty()) return true;
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
}
