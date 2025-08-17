package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CookiePage extends BasePage{
    @FindBy(className = "cookie__wrapper")
    private WebElement cookieWrapper;

    @FindBy(xpath = "//button[text()='Отклонить']")
    private WebElement dismissButton;

    public CookiePage(WebDriver driver) {
        super(driver);
    }

    @Step("Cookie Rejection")
    public void dismissCookies(){
        try{
            wait.until(ExpectedConditions.visibilityOf(cookieWrapper));
            wait.until(ExpectedConditions.elementToBeClickable(dismissButton));
            dismissButton.click();
        } catch (NoSuchElementException e) {
            System.out.println("Dismiss button not found: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("Timed out waiting for the cookie consent dialog: " + e.getMessage());
        }
    }
}
