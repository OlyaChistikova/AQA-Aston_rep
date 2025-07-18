package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
    protected final WebDriver driver;
    private final By payWrapper = By.className("pay__wrapper");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Scroll to the payment page")
    public void hoverToPayWrapper(){
        WebElement payElement = driver.findElement(payWrapper);
        Actions actions = new Actions(driver);
        actions.moveToElement(payElement).perform();
    }
}
