package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected final WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class = 'pay__wrapper']")
    private WebElement payWrapper;

    @Step("Scroll to the payment page")
    public void hoverToPayWrapper(){
        wait.until(ExpectedConditions.visibilityOf(payWrapper));
        Actions actions = new Actions(driver);
        actions.moveToElement(payWrapper).perform();
    }
}