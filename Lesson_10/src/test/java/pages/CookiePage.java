package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CookiePage extends BasePage{
    private final By cookieWrapper = By.className("cookie__wrapper");
    private final By dismissLocator = By.xpath("//button[text()='Отклонить']");

    public CookiePage(WebDriver driver) {
        super(driver);
    }

    public void dismissCookies(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(cookieWrapper));

            WebElement dismissButton =  wait.until(ExpectedConditions.elementToBeClickable(dismissLocator));
            dismissButton.click();
        } catch (NoSuchElementException e) {
            System.out.println("Dismiss button not found: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("Timed out waiting for the cookie consent dialog: " + e.getMessage());
        }
    }
}
