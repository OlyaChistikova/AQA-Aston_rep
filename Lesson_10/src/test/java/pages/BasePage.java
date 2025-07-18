package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
    protected final WebDriver driver;
    private By payWrapper = By.className("pay__wrapper");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void hoverToPayWrapper(){
        WebElement payElement = driver.findElement(payWrapper);
        Actions actions = new Actions(driver);
        actions.moveToElement(payElement).perform();
    }

    public void refreshWindow(){
        driver.navigate().refresh();
    }
}
